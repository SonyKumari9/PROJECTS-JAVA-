package atm.example.atm.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class ATMUserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNo;
    private String pin;
    private String name;

    public ATMUserModel() {} 

    public ATMUserModel(Long id, String cardNo, String pin, String name) {
        this.id = id;
        this.cardNo = cardNo;
        this.pin = pin;
        this.name = name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    
}
