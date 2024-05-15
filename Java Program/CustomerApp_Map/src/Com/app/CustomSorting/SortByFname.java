package Com.app.CustomSorting;

import java.util.Comparator;
import Com.app.CustomerApplication.Customer;


public class SortByFname implements Comparator<Customer> {

	
	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return o2.getFname().compareTo(o1.getFname());
		
	}

}
