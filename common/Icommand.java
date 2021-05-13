package common;

import java.rmi.*;

import server.Department;
public interface Icommand extends Remote{

	public Idepartment execute() throws RemoteException;

	

	
	
	//possibly throw on other interface
	public void getParameters(String type, String description, double price) throws RemoteException;
	public void getParameters(String type, String description) throws RemoteException;
	public void getParameters(Idepartment returnDepartment) throws RemoteException;
	public void getParameters(String type,String description,String newType,String newDescription,double newPrice) throws RemoteException;
	
	public Idepartment returnDepartment() throws RemoteException;


	


	
}


