package Com.app.banking;

import java.time.LocalDate;

import Com.app.Exception.BankingException;
import Com.app.utils.BankingValidations;

public class BankAccount {
	
	private int accNo;
	private String firstnme;
	private String lastname;
	private AcType actype;
	private LocalDate dob;
	private LocalDate creationDate;
	private double balance;
	
	

	public BankAccount(int accNo, String firstnme, String lastname, AcType actype, LocalDate dob,
			LocalDate creationDate, double balance) {
		super();
		this.accNo = accNo;
		this.firstnme = firstnme;
		this.lastname = lastname;
		this.actype = actype;
		this.dob = dob;
		this.creationDate = creationDate;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", firstnme=" + firstnme + ", lastname=" + lastname + ", actype="
				+ actype + ", dob=" + dob + ", creationDate=" + creationDate + ", balance=" + balance + "]";
	}
	public BankAccount(int accNo)
	{
		this.accNo=accNo;
	}
	
	public double deposite(double amount)
	{
		this.balance += amount;
		return this.balance;
	}
	public double withdraw(double amount) throws BankingException
	{
		//validate balance 
		BankingValidations.validatebalance(this.actype,balance-amount);
		this.balance -= amount;
		return balance;
		
	}
	public void transferfund(BankAccount dest,double amount) throws BankingException
	{
		this.withdraw(amount);
		dest.deposite(amount);
	}
	@Override
	public boolean equals(Object o)		
	{
		System.out.println("in acc equals");
		if(o instanceof BankAccount)
		{
			return this.accNo == ((BankAccount) o).accNo;
		}
		return false;
		
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getFirstnme() {
		return firstnme;
	}

	public void setFirstnme(String firstnme) {
		this.firstnme = firstnme;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public AcType getActype() {
		return actype;
	}

	public void setActype(AcType actype) {
		this.actype = actype;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
			
	

}
