package atm.example.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atm.example.atm.model.BankTransactionModel;
import atm.example.atm.model.DepositRequest;
import atm.example.atm.repo.BankTransactionRepository;

import java.sql.Date;
import java.util.List;

@Service
public class DepositService {

    @Autowired
    private BankTransactionRepository repo;

    public String deposit(DepositRequest request) {
        String accountNo = request.getCardNo();
        String pin = request.getPin();

        // 1. Check if account exists
        List<BankTransactionModel> accountTxns = repo.findByAccountNoOrderByDateDesc(accountNo);

        if (!accountTxns.isEmpty()) {
            // Check latest known PIN 
            String lastKnownPin = accountTxns.get(0).getPin();

            //  for a PIN_UPDATE for this account
            for (BankTransactionModel tx : accountTxns) {
                if ("PIN_UPDATE".equalsIgnoreCase(tx.getType())) {
                    lastKnownPin = tx.getPin(); // new updated pin
                    break;
                }
            }

            // If new deposit's PIN doesn't match current valid PIN 
            if (!lastKnownPin.equals(pin)) {
                return " Incorrect PIN for existing account.";
            }

        } else {
            // New account  Check if this PIN is already used
            BankTransactionModel pinUsedElsewhere = repo.findTopByPinOrderByDateDesc(pin);
            if (pinUsedElsewhere != null) {
                return " This PIN is already used with another account.";
            }
        }

        // Passed all checks proceed to deposit
     // Generate random transaction number
        String transactionNumber = "TXN" + System.currentTimeMillis();

        // Generate  response number
        String responseNumber = "RESP" + (int)(Math.random() * 1000000);

        BankTransactionModel txn = new BankTransactionModel();
        txn.setAccountNo(accountNo);
        txn.setAmount(String.valueOf(request.getAmount()));
        txn.setDate(new java.sql.Date(System.currentTimeMillis()));
        txn.setType("Deposit");
        txn.setPin(pin);
        txn.setName(null);
        txn.setTranxationNo(transactionNumber);
        txn.setResponseNo(responseNumber);

        repo.save(txn);
        return "Rs. " + request.getAmount() + " deposited successfully! Transaction No: " + transactionNumber;

    }

}

