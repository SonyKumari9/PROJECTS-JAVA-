package atm.example.atm.controller;

import atm.example.atm.model.BankTransactionModel;
import atm.example.atm.repo.BankTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/atm")
@CrossOrigin(origins = "*")
public class PinGenerateChangeController {

    @Autowired
    private BankTransactionRepository repo;

    @PostMapping("/updatePin")
    public ResponseEntity<String> updateOrGeneratePin(@RequestBody Map<String, String> request) {
        String cardNo = request.get("cardNo");
        String newPin = request.get("newPin");

        if (cardNo == null || newPin == null || newPin.length() != 4) {
            return ResponseEntity.badRequest().body("Invalid request. Provide 4-digit new PIN and account number.");
        }

        //  Get balance from DB
        Double currentBalance = repo.getBalanceByAccountNo(cardNo);
        if (currentBalance == null) currentBalance = 0.0;

        BankTransactionModel txn = new BankTransactionModel();
        txn.setAccountNo(cardNo);
        txn.setPin(newPin);
        txn.setType("PIN_UPDATE");
        txn.setAmount(String.valueOf(currentBalance));
        txn.setDate(new java.sql.Date(System.currentTimeMillis()));
        txn.setTotalAmount(String.valueOf(currentBalance)); 

        repo.save(txn);

        return ResponseEntity.ok("PIN saved/updated successfully for account " + cardNo);
    }
}
