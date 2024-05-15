package Com.app.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import Com.app.CustomerApplication.Customer;

public interface IOUtils {
	
	static void writedata(Map<String,Customer>customer,String filename)throws IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename))){
			out.writeObject(customer);
		}
	}
	
	static Map<String,Customer> readdata(String filename)throws IOException, ClassNotFoundException
	{
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(filename))){
			return (Map<String,Customer>) in.readObject();
		}
		
	}

}
