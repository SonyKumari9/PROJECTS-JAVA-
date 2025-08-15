package atm.example.atm.controller;

import atm.example.atm.model.BalanceResponseModel;
import atm.example.atm.model.BankTransactionModel;
import atm.example.atm.repo.BankTransactionRepository;
import atm.example.atm.service.BalanceService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atm")
@CrossOrigin(origins = "*")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private BankTransactionRepository repo;

    // Check balance by PIN only
    @PostMapping("/balance/check")
    public ResponseEntity<BalanceResponseModel> getBalanceByPin(@RequestBody Map<String, String> request) {
        String pin = request.get("pin");

        // latest transaction by pin
        BankTransactionModel txn = repo.findTopByPinOrderByDateDesc(pin);
        if (txn == null) {
            return ResponseEntity.status(404).body(new BalanceResponseModel(0));
        }

        String accountNo = txn.getAccountNo();

        BalanceResponseModel balance = balanceService.getBalance(accountNo);
        return ResponseEntity.ok(balance);
    }
}

