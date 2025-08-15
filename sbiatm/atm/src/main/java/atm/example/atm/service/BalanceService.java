package atm.example.atm.service;

import atm.example.atm.model.BankTransactionModel;
import atm.example.atm.model.BalanceResponseModel;
import atm.example.atm.repo.BankTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService {

    @Autowired
    private BankTransactionRepository repo;

    public BalanceResponseModel getBalance(String accountNo) {
        List<BankTransactionModel> history = repo.findByAccountNoOrderByDateDesc(accountNo);
        return calculateBalance(history);
    }

    private BalanceResponseModel calculateBalance(List<BankTransactionModel> history) {
        double balance = 0;

        for (BankTransactionModel tx : history) {
            try {
                double amount = Double.parseDouble(tx.getAmount());
                if ("Deposit".equalsIgnoreCase(tx.getType())) {
                    balance += amount;
                } else if ("Withdraw".equalsIgnoreCase(tx.getType())) {
                    balance -= amount;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid amount format: " + tx.getAmount());
            }
        }

        return new BalanceResponseModel(balance);
    }
}
