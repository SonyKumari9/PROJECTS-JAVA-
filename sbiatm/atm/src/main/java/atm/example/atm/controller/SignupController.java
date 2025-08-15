package atm.example.atm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import atm.example.atm.model.SignupModel;
import atm.example.atm.repo.SignupRepo;

@RestController
@RequestMapping("/signup")
@CrossOrigin(origins = "*") 
public class SignupController {

    @Autowired
    private SignupRepo signupRepo;

    @PostMapping("/create")
    public ResponseEntity<?> createSignup(@RequestBody SignupModel signup) {
        signupRepo.save(signup);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Signup saved successfully");

        return ResponseEntity.ok()
            .header("Content-Type", "application/json")
            .body(response);
    }

}

