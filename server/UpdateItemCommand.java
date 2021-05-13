package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Icommand;
import common.Idepartment;

public class UpdateItemCommand extends UnicastRemoteObject implements Icommand {
	
	String type,description,newType,newDescription;
	double price,newPrice;

	private Idepartment d = new Department();
	
	public UpdateItemCommand() throws RemoteException
	{
		super();
		
	}
	
	public Idepartment execute() throws RemoteException {
		
		d.updateItems(type, description, newType, newDescription, newPrice);
		
		return d;
	}

	
	public void getParameters(String type, String description, double price) throws RemoteException {
		
			this.type = type;
			this.description = description;
			this.price = price;
	}

	
	public void getParameters(String type, String description) throws RemoteException {
		
			this.type = type;
			this.description = description;
	}

	
	public Idepartment returnDepartment() throws RemoteException {
		
		return d;
	}

	
	public void getParameters(Idepartment d) throws RemoteException {
		this.d = d;

	}

	@Override
	public void getParameters(String type, String description, String newType, String newDescription, double newPrice)
			throws RemoteException {
			
			this.type = type;
			this.description = description;
			this.newType = newType;
			this.newDescription = newDescription;
			this.newPrice = newPrice;
		
	}

}
