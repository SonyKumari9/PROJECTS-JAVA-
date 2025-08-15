package atm.example.atm.model;

import javax.persistence.Column;

public class WithdrawRequest {
    private String cardNo;
    private double amount;
    private String pin;
    
    @Column(name = "tranxation_no")
    private String tranxationNo;
    
    @Column(name = "response_no")
    private String responseNo;
    

    public String getCardNo() { return cardNo; }
    public void setCardNo(String cardNo) { this.cardNo = cardNo; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getTranxationNo() {
		return tranxationNo;
	}
	public void setTranxationNo(String tranxationNo) {
		this.tranxationNo = tranxationNo;
	}
	public String getResponseNo() {
		return responseNo;
	}
	public void setResponseNo(String responseNo) {
		this.responseNo = responseNo;
	}
	
	
    
    
}
