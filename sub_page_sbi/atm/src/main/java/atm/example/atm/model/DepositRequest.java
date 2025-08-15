package atm.example.atm.model;

import javax.persistence.Column;

public class DepositRequest {
    private String cardNo;
    private String amount;
    @Column(name = "account_no")
    private String accountNo;
    @Column(name = "pin")
    private String pin;
    
    @Column(name = "tranxation_no")
    private String tranxationNo;
    
    @Column(name = "response_no")
    private String responseNo;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

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
