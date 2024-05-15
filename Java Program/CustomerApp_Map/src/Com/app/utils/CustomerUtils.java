package Com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Com.app.CustomException.CustomerException;
import Com.app.CustomerApplication.Customer;
import Com.app.CustomerApplication.ServicePlan;

public class CustomerUtils {
	
	public static Customer SigninCustomer(String email,String passwd,Map<String,Customer> map)throws CustomerException
	{
		
		Customer cst=map.get(email);
		if(cst == null && cst.getPassword()!=passwd)
			throw new CustomerException("login failed..");
		return cst;
	}
	
	public static String unregisterCustomer(String email,String pass,Map<String,Customer>map) throws CustomerException
	{
		Customer customer=SigninCustomer(email,pass,map);
		map.remove(customer.getEmail());
		
	
	    return "removed:";
	}
	public static void RemoveBornAfter(String plan,String bornafter,Map<String,Customer> map) throws CustomerException
	{
		System.out.println("in remove");
		ServicePlan serviceplan=ServicePlan.valueOf(plan.toUpperCase());
		LocalDate BornAfter=LocalDate.parse(bornafter);
		
		ArrayList<Customer> lists=new ArrayList<>(map.values());
		Iterator<Customer> itr=lists.iterator();
		
		while(itr.hasNext()) {
			Customer c1=itr.next();
		if(c1.getPlan()==serviceplan && c1.getDob().isAfter(BornAfter))
		{
			itr.remove();
			
		}
		throw new CustomerException("no such customer to remove");
		
		}
		
		
		
		
	}
	
	
	public static Map<String,Customer> populated()
	{
		//Enter customer details : firstName,  lastName,  email,  password,	regAmount,  dob,  plan\"");
		Customer c1 = new Customer("a1", "b1", "prath@123","Pass@123",5000, LocalDate.parse("1991-10-27"),
				            ServicePlan.DIAMOND);
		Customer c2 = new Customer("b1", "b2", "abc@123","Pqr@123",1000, LocalDate.parse("1999-10-27"),
	            ServicePlan.SILVER);
		Customer c3 = new Customer("c1", "b1", "pqr@123","Abc@123",2000, LocalDate.parse("2001-10-27"),
	            ServicePlan.GOLD);
		Customer c4 = new Customer("d1", "g1", "xyz@123","Xyz@123",5000, LocalDate.parse("1991-10-27"),
	            ServicePlan.DIAMOND);
		Customer[] cust={c1,c2,c3,c4};
		Map<String,Customer> map=new HashMap<>();
		for(Customer c:cust)
			System.err.println(map.put(c.getEmail(),c));
		return map;
	}

}
