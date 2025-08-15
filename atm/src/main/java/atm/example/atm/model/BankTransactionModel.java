package atm.example.atm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "balance_table")
public class BankTransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "amount")
    private String amount;

    @Column(name = "date")
    private Date date;

    @Column(name = "name")
    private String name;

    @Column(name = "pin")
    private String pin;

    @Column(name = "type")
    private String type;
    
    
    @Column(name = "total_amount")
    private String totalAmount;
    
    @Column(name = "tranxation_no")
    private String tranxationNo;
    
    @Column(name = "response_no")
    private String responseNo;
    
  

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
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

