package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Icommand;
import common.Idepartment;


public class BrowseItemsCommand extends UnicastRemoteObject implements Icommand {
	private Idepartment d = new Department();
	private String [] info;
	int i;
	public BrowseItemsCommand() throws RemoteException
	{
		super();
		
	}

	@Override
	public Idepartment execute() throws RemoteException {
		
		return d;
		
	}

	
	public void getParameters(Idepartment d) throws RemoteException {
		
		this.d = d;
	}

	
	public Idepartment returnDepartment() throws RemoteException {
	
		return d;
	}

	
	public void getParameters(String type, String description, double price) throws RemoteException {
	
		
	}

	
	public void getParameters(String type, String description) throws RemoteException {
		
		
	}

	@Override
	public void getParameters(String type, String description, String newType, String newDescription, double newPrice)
			throws RemoteException {
		
		
	}





}
