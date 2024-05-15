package Com.app.tester;

import static Com.app.utils.CustomerUtils.SigninCustomer;
import static Com.app.utils.CustomerUtils.unregisterCustomer;
import static Com.app.utils.IOUtils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import Com.app.CustomSorting.SortByDOB;
import Com.app.CustomSorting.SortByFname;
import Com.app.CustomerApplication.Customer;
import Com.app.utils.CustomerUtils;
import Com.app.utils.Validation;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner in=new Scanner(System.in)){
			// TODO Auto-generated method stub
			boolean exit=false;
			Map<String,Customer> customerlist=CustomerUtils.populated(); 
			
			
			
			while(!exit)
			{
				System.out.println("ENTER 1.CUSTOMER SIGNUP 2.DISPLAY 3.SIGN IN 4.REMOVE ACC 5.CHANGE ACC PASS 6.SORT USING EMAIL 7.Sort desc Fname 8.ADD TO BINARY FILE 9:DE-SERIALIZATION 0.EXIT");
				System.out.println("choose");
				try {
				switch(in.nextInt())
				{
				case 1: //register new customer
					System.out.println("Enter customer details : firstName,  lastName,  email,  password,	regAmount,  dob,  plan\"");
					Customer customer=Validation.validatecustomer(in.next(), in.next(), in.next(),in.next() , in.nextDouble(), in.next(), in.next());
				    customerlist.put(customer.getEmail(),customer);
				    System.out.println("customer is register!!");
				    break;
				case 2:
					System.out.println("Bank account details !");
					for(Customer c:customerlist.values())
					{
						System.out.println(c);
					}
					break;
				case 3:
					System.out.println("enter email and password for signin");
					Customer cust=SigninCustomer(in.next(), in.next(), customerlist);
					System.out.println(cust);
					break;
				case 4:
					System.out.println("enter email and password for removeAccount");
					String msg=unregisterCustomer(in.next(), in.next(), customerlist);
					System.out.println(msg);
					
					
					break;
				case 5:
					System.out.println("enter email and old_password to chane password:");
					Customer cust2=SigninCustomer(in.next(), in.next(), customerlist);
					
					System.out.println("enter new password:");
					cust2.setPassword(in.next());
					break;
				case 6:
					TreeMap<String,Customer> lists=new TreeMap<>(customerlist);
					for(Customer c: lists.values())
						System.out.println(c);
					break;
				case 7:
					ArrayList<Customer> arrylist=new ArrayList<>(customerlist.values());
					Collections.sort(arrylist,new SortByDOB());
					System.out.println("sort using dob");
					for(Customer c:arrylist)
					{
						System.out.println(c);
					}
					break;
				case 8:
					ArrayList<Customer> listss=new ArrayList<>(customerlist.values());
					Collections.sort(listss,new SortByFname());
					System.out.println("sort using dob");
					
					for(Customer c:listss)
					{
						System.out.println(c);
					}
				case 9:
					System.out.println("enter plan and bornAfter date to remove account:");
					CustomerUtils.RemoveBornAfter(in.next(),in.next(),customerlist);
					System.out.println("remove");
					break;
				case 10:
					System.out.println("enter filename:");
					writedata(customerlist,in.next());
					break;
				case 11:
					System.out.println("enter file name");
					Map<String,Customer> map=readdata(in.next());
					map.forEach((k,v)->System.out.println(v));
					break;
					
					
				
						
					
					
					
					
					
				
					
				
					
				case 0:
					exit=true;
					break;
					
				}
				}catch(Exception e) {
					in.nextLine();
					
				}
			}
			
			}

	}

	
	


	}


