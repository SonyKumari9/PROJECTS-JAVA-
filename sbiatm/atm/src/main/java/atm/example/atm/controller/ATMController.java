package atm.example.atm.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import atm.example.atm.model.ATMUserModel;
import atm.example.atm.repo.ATMUserRepo;

@RestController
@RequestMapping("/atm")
@CrossOrigin("*")
public class ATMController {

    @Autowired
    private ATMUserRepo repo;

    // Create ATM Account
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody ATMUserModel user) {
        Optional<ATMUserModel> existing = repo.findByCardNo(user.getCardNo());
        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Card number already exists.");
        }
        return ResponseEntity.ok(repo.save(user));
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        String cardNo = payload.get("cardNo");
        String pin = payload.get("pin");

        Optional<ATMUserModel> user = repo.findByCardNoAndPin(cardNo, pin);
        return user.<ResponseEntity<?>>map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                                 .body("Invalid card number or PIN."));
    }

    // Change PIN
    @PutMapping("/change-pin")
    public ResponseEntity<?> changePin(@RequestBody Map<String, String> payload) {
        String cardNo = payload.get("cardNo");
        String oldPin = payload.get("oldPin");
        String newPin = payload.get("newPin");

        Optional<ATMUserModel> user = repo.findByCardNoAndPin(cardNo, oldPin);
        if (user.isPresent()) {
            ATMUserModel u = user.get();
            u.setPin(newPin);
            repo.save(u);
            return ResponseEntity.ok("PIN updated successfully.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect old PIN.");
    }
}
