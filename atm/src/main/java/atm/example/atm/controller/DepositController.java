package atm.example.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import atm.example.atm.model.DepositRequest;
import atm.example.atm.service.DepositService;

@RestController
@RequestMapping("/atm")
@CrossOrigin(origins = "*")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PostMapping("/deposit")
    public String deposit(@RequestBody DepositRequest request) {
        return depositService.deposit(request);
    }
}

