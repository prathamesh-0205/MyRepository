package Com.app.utils;

import java.time.LocalDate;
import java.util.List;
import Com.app.Exception.BankingException;
import Com.app.banking.AcType;
import Com.app.banking.BankAccount;

public class BankingValidations {
	
	public static void validatebalance(AcType actype,double balance)throws BankingException
	{
		if(balance < actype.getMinBalance())
			throw new BankingException("insufficient balance !!");
		System.out.println("valid balance :)");
		
	}
	public static AcType parseAndValidateAcType(String actype)throws BankingException
	{
		return AcType.valueOf(actype.toUpperCase()); 
	}
	public static LocalDate parseDate(String dob) throws BankingException
	{
		return LocalDate.parse(dob);
	}
	public static void checkforDup(int accno,List<BankAccount> accts) throws BankingException
	{
		BankAccount acct=new BankAccount(accno);
		if(accts.contains(acct))
			throw new BankingException("duplicate accno");
	}
	
	public static BankAccount validateAccountDetails(int accNo,String firstname,String lastname,String actype,String dob,String creationDate,double balance,List<BankAccount> accounts)throws BankingException
	{
		//validatebalance(actype,balance);
		LocalDate creation=parseDate(creationDate);
		LocalDate birthdate=parseDate(dob);
		AcType type=parseAndValidateAcType(actype);
		checkforDup(accNo,accounts);
		validatebalance(type,balance);
		
		return new BankAccount(accNo,firstname,lastname,type,birthdate,creation,balance);
		
	}

}
