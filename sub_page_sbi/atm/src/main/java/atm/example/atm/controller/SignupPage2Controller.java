package atm.example.atm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import atm.example.atm.model.SignupPage2Model;
import atm.example.atm.repo.SignupPage2Repo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/signup")
public class SignupPage2Controller {

    @Autowired
    private SignupPage2Repo signupRepo;

    @PostMapping("/page2")
    public ResponseEntity<?> savePage2(@RequestBody SignupPage2Model model) {
    	signupRepo.save(model);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Page 2 data saved");

        return ResponseEntity.ok()
            .header("Content-Type", "application/json")
            .body(response);
    }

}

