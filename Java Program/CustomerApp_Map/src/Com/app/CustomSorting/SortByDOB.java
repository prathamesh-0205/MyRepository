package Com.app.CustomSorting;

import java.util.Comparator;

import Com.app.CustomerApplication.Customer;

public class SortByDOB implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return o1.getDob().compareTo(o2.getDob());
		
	}

}
