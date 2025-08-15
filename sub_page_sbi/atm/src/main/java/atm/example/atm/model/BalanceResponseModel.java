package atm.example.atm.model;

public class BalanceResponseModel {
    private double balance;

    public BalanceResponseModel(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
