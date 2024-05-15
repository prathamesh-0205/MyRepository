package Com.app.utils;

import java.time.LocalDate;
import java.time.Period;

import Com.app.CustomException.CustomerException;
import Com.app.CustomerApplication.Customer;
import Com.app.CustomerApplication.ServicePlan;

public class Validation {
	
	public static Customer validatecustomer(String fname, String lname, String email, String password, double regAmount, String dob,
			String plan) throws CustomerException
	{
		LocalDate birthdate=LocalDate.parse(dob);
		ServicePlan serviceplan=validateplan(plan,regAmount);
		
		
		
		return new Customer(fname,lname,email,password,regAmount,birthdate,serviceplan);
		
	}
	public static ServicePlan validateplan(String plan,double cost)throws CustomerException
	{
		ServicePlan serviceplan=ServicePlan.valueOf(plan);
		
		if(serviceplan.getPlancost()==cost)
			return serviceplan;
		throw new CustomerException("plan cost is not valid");
		
	}
	public static void 	validatepass(String pass) throws CustomerException
	{
		 String regex="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
		 if(!pass.matches(regex))
			 throw new CustomerException("password is too weak");
		 
	}
	public static void validateDateAndAge(String date)throws CustomerException 
	{
		LocalDate bdate=LocalDate.parse(date);
		int age=Period.between(bdate,LocalDate.now()).getYears();
		
		if(age<21)
			throw new CustomerException("age should be more than 21");
	}

}
