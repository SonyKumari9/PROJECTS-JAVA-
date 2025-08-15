package atm.example.atm.service;

import atm.example.atm.model.BankTransactionModel;
import atm.example.atm.model.WithdrawRequest;
import atm.example.atm.repo.BankTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class WithdrawService {

    @Autowired
    private BankTransactionRepository repo;

    public String processWithdrawal(WithdrawRequest request) {
        String pin = request.getPin();
        double amount = request.getAmount();

        //  matching transaction by PIN
        BankTransactionModel lastTxn = repo.findTopByPinOrderByDateDesc(pin);
        if (lastTxn == null) {
            return " Invalid PIN. No account found.";
        }

        String accountNo = lastTxn.getAccountNo(); // dynamically fetch account no
        Double balance = repo.getBalanceByAccountNo(accountNo);
        if (balance == null) balance = 0.0;

        if (amount > balance) {
            return " Insufficient balance. Current balance: Rs. " + balance;
        }

        double newBalance = balance - amount;

        // withdrawal with updated total_amount
     // Generate random transaction number and response number
        String transactionNumber = "TXN" + System.currentTimeMillis();
        String responseNumber = "RESP" + (int)(Math.random() * 1000000);

        // Create withdrawal transaction with transaction info
        BankTransactionModel txn = new BankTransactionModel();
        txn.setAccountNo(accountNo);
        txn.setPin(pin);
        txn.setAmount(String.valueOf(amount));
        txn.setType("Withdraw");
        txn.setDate(new java.sql.Date(System.currentTimeMillis()));
        txn.setTotalAmount(String.valueOf(newBalance));
        txn.setTranxationNo(transactionNumber);
        txn.setResponseNo(responseNumber);

        repo.save(txn);

        return "Withdrawal successful. Transaction No: " + transactionNumber + ". Updated balance: Rs. " + newBalance;

    }


}
