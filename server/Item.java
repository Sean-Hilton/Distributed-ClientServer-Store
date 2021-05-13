package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.IItem;

public class Item extends UnicastRemoteObject implements IItem{

	
	private String type;
	private String description;
	private double price;
	
	 Item() throws RemoteException {
			super();
			
		}
	
	Item(String type,String description, double price) throws RemoteException
	{
		this.type=type;
		this.description=description;
		this.price=price;
	}
	
	
	/***
	 * Set type of department such as "grocery"
	 * @params String
	 * 
	 ***/
	public void setType(String x)
	{
		type = x;
	}
	
	/***
	 * Returns a String that acts as the item "type"
	 * 
	 ***/
	public String getType() 
	{
		return type;
	}
	
	
	/***
	 * Set description such as "apple"
	 * @params String
	 * 
	 ***/
	public void setDescription(String x)
	{
		description = x;
	}
	
	
	/***
	 * Returns a String that acts as the "description"
	 * 
	 ***/
	public String getDescription() 
	{
		return description;
	}

	
	/***
	 * Set price as double such as "2.00"
	 * @params double
	 * 
	 ***/
	public void setPrice(double x)
	{
		price = x;
	}
	
	
	/***
	 * Returns a double that acts as the "price"
	 * 
	 ***/
	public double getPrice() 
	{
		return price;
	}
	

}
