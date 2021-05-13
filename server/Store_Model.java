package server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/***
 * 
 * The store model is the front controller for registration
 *
 */
public class Store_Model {

	
	private Dispatcher dispatch;
	public Store_Model()
	{
		dispatch = new Dispatcher();
	}
	
	

	//This method appends a username and password combination to a file
	//effectively making them a "registered user"
	public void newRegistrationAdmin(String username,String password)
	{
		try
		{
		    String filename= "AdminRegistrations.txt";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write("Username:\n" + username + "\nPassword:\n" + password + "\n\n");//appends the string to the file
		    fw.close();
		    System.out.println("\nUser Added\n");
		    
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
	
	
		//This method appends a username and password combination to a file
		//effectively making them a "registered user"
		public void newRegistrationShopper(String username,String password)
		{
			try
			{
			    String filename= "ShopperRegistrations.txt";
			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
			    fw.write("Username:\n" + username + "\nPassword:\n" + password + "\n\n");//appends the string to the file
			    fw.close();
			    System.out.println("\nUser Added\n");
			    
			}
			catch(IOException ioe)
			{
			    System.err.println("IOException: " + ioe.getMessage());
			}
		}
		
	
	
	public boolean isAuthenticatedAdmin(String strToCheck)
	{
		File file = new File("AdminRegistrations.txt");
		
		if(file!=null)
		{
		
		
		try {
			final Scanner scan = new Scanner(file);
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				if(line.contains(strToCheck))
				{
					return true;
				}
				
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		}
		
		
		System.out.println("No file found or no users on file\n");
		return false;
		
	}
	
	public boolean isAuthenticatedShopper(String strToCheck)
	{
		File file = new File("ShopperRegistrations.txt");
		
		if(file!=null)
		{
		
		
		try {
			final Scanner scan = new Scanner(file);
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				if(line.contains(strToCheck))
				{
					return true;
				}
				
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		}
		
		
		System.out.println("No file found or no users on file\n");
		return false;
		
	}
	
	public void dispatchRequest (String request)
	{
		dispatch.dispatch(request);
	}
}
