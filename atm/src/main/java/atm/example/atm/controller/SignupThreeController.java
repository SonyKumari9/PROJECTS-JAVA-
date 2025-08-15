package atm.example.atm.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import atm.example.atm.model.SignupThreeModel;
import atm.example.atm.repo.SignupThreeRepo;



@RestController
@RequestMapping("/signup")
@CrossOrigin(origins = "*")
public class SignupThreeController {

    @Autowired
    private SignupThreeRepo signupThreeRepo;

    @PostMapping("/page3")
    public ResponseEntity<?> savePage3(@RequestBody SignupThreeModel model) {
        SignupThreeModel saved = signupThreeRepo.save(model);

        
        Map<String, String> response = new HashMap<>();
        response.put("cardNumber", saved.getCardNumber());
        response.put("pin", saved.getPin());

        return ResponseEntity.ok(response);
    }

}

