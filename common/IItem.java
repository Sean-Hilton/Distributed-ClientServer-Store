package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IItem extends Remote{

	
	/***
	 * Set type of department such as "grocery"
	 * @params String
	 * 
	 ***/
	public void setType(String x) throws RemoteException;
	
	
	/***
	 * Returns a String that acts as the item "type"
	 * 
	 ***/
	public String getType() throws RemoteException;
	
	
	/***
	 * Set description such as "apple"
	 * @params String
	 * 
	 ***/
	public void setDescription(String x) throws RemoteException;
	
	
	/***
	 * Returns a String that acts as the "description"
	 * 
	 ***/
	public String getDescription() throws RemoteException;
	
	
	/***
	 * Set price as double such as "2.00"
	 * @params double
	 * 
	 ***/
	public void setPrice(double x) throws RemoteException;
	
	
	
	/***
	 * Returns a double that acts as the "price"
	 * 
	 ***/
	public double getPrice() throws RemoteException;
	
	
	
	
	
}
