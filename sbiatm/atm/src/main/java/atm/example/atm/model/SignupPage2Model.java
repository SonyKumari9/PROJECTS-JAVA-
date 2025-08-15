package atm.example.atm.model;


import javax.persistence.*;

@Entity
@Table(name = "signup_details_2")
public class SignupPage2Model {

    @Id
    private String formNo;

    private String religion;
    private String category;
    private String income;
    private String education;
    private String occupation;
    private String pan;
    private String aadhar;
    private String seniorCitizen;
    private String existingAccount;
	public String getFormNo() {
		return formNo;
	}
	public void setFormNo(String formNo) {
		this.formNo = formNo;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getSeniorCitizen() {
		return seniorCitizen;
	}
	public void setSeniorCitizen(String seniorCitizen) {
		this.seniorCitizen = seniorCitizen;
	}
	public String getExistingAccount() {
		return existingAccount;
	}
	public void setExistingAccount(String existingAccount) {
		this.existingAccount = existingAccount;
	}

    
}

