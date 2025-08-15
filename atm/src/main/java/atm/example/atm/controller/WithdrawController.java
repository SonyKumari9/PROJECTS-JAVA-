package atm.example.atm.controller;

import atm.example.atm.model.BankTransactionModel;
import atm.example.atm.model.WithdrawRequest;
import atm.example.atm.repo.BankTransactionRepository;
import atm.example.atm.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/atm")
@CrossOrigin(origins = "*")
public class WithdrawController {

    @Autowired
    private WithdrawService withdrawService;

    @Autowired
    private BankTransactionRepository repo;

    @PostMapping("/withdraw")
    public String withdraw(@RequestBody WithdrawRequest request) {
        return withdrawService.processWithdrawal(request);
    }
    
    
    // only for Auhorization
    @GetMapping("/checkPin/{pin}")
    public ResponseEntity<String> checkPin(@PathVariable String pin) {
        BankTransactionModel txn = repo.findTopByPinOrderByDateDesc(pin);
        if (txn != null) {
            return ResponseEntity.ok("VALID");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("INVALID");
        }
    }
    
    
    
    
    @GetMapping("/getStatementByPin/{pin}")
    public ResponseEntity<Map<String, Object>> getStatementByPin(@PathVariable String pin) {
        BankTransactionModel txn = repo.findTopByPinOrderByDateDesc(pin);
        if (txn == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        String cardNo = txn.getAccountNo();
        List<BankTransactionModel> transactions = repo.findByAccountNoOrderByDateDesc(cardNo);
        Double balance = repo.getBalanceByAccountNo(cardNo);
        if (balance == null) balance = 0.0;

        Map<String, Object> result = new HashMap<>();
        result.put("cardNo", cardNo);
        result.put("transactions", transactions);
        result.put("balance", balance);
        return ResponseEntity.ok(result);
    }



    @GetMapping("/miniStatement/{cardNo}")
    public Map<String, Object> getMiniStatement(@PathVariable String cardNo) {
        List<BankTransactionModel> transactions = repo.findByAccountNoOrderByDateDesc(cardNo);
        Double balance = repo.getBalanceByAccountNo(cardNo);
        if (balance == null) balance = 0.0;

        Map<String, Object> result = new HashMap<>();
        result.put("transactions", transactions);
        result.put("balance", balance);
        return result;
    }
    
    
   


}
