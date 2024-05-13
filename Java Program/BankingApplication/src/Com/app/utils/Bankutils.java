package Com.app.utils;

import java.util.List;

import Com.app.Exception.BankingException;
import Com.app.banking.BankAccount;

public class Bankutils {
	
	public static BankAccount findaccByAccNo(int accno,List<BankAccount> accounts )throws BankingException
	{
		BankAccount acc=new BankAccount(accno);
		int index=accounts.indexOf(acc);
		if(index == -1)
			throw new BankingException("acc not found!!");
		return accounts.get(index);
				
	}
	public static String transferFunds(int srcAcNo,int destAcNo,double amount,List<BankAccount> list)throws BankingException
	{
		BankAccount src=findaccByAccNo(srcAcNo,list);
		BankAccount dest=findaccByAccNo(destAcNo,list);
		src.transferfund(dest, amount);
		
		return "fund is transfer";
	}
	
	public static void closeAccount(int accno,List<BankAccount> accounts) throws BankingException
	{
		BankAccount acc=new BankAccount(accno);
		int index=accounts.indexOf(acc);
		if(index == -1)
			throw new BankingException("acc not found!!");
		accounts.remove(index);
				
		
	}
	

}
