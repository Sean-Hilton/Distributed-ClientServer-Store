package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Icommand;
import common.Idepartment;


public class AddItemCommand extends UnicastRemoteObject implements Icommand{

	private Idepartment d = new Department();
	String type,description;
	double price;
	
	
	public AddItemCommand() throws RemoteException
	{
		super();
		
	}
	public Idepartment execute() {
		
		
	 
	  try {
		d.addItems(type, description, price);
	} catch (RemoteException e) {
		
		e.printStackTrace();
	}
	  return d;
	}



    public void getParameters(String type, String description, double price) 
	{
   
	this.type = type;
	this.description = description;
	this.price = price;
	
	}
    
    //for use in browse items MAY NOT NEED
    public Idepartment returnDepartment()
    {
    	return this.d;
    }
	
	
	public void getParameters(Idepartment d) {
		this.d = d;
		
	}
	@Override
	public void getParameters(String type, String description) throws RemoteException {
		this.type = type;
		this.description = description;
		
	}
	@Override
	public void getParameters(String type, String description, String newType, String newDescription, double newPrice)
			throws RemoteException {
		
		
	}
	
	
	



}
