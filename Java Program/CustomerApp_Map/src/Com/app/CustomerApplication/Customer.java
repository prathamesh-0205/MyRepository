package Com.app.CustomerApplication;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable{
	
	private int cid;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idcount=0;
	public Customer(String fname, String lname, String email, String password, double regAmount, LocalDate dob,
			ServicePlan plan) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
		this.cid=++idcount;
	}
	public Customer(String email,String password)
	{
		this.email=email;
		this.password=password;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public ServicePlan getPlan() {
		return plan;
	}
	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}
	public static int getIdcount() {
		return idcount;
	}
	public static void setIdcount(int idcount) {
		Customer.idcount = idcount;
	}
	
	

}
