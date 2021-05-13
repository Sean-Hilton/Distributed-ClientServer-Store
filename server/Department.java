package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.Idepartment;

public class Department extends UnicastRemoteObject  implements Idepartment{

	

	public Department() throws RemoteException {
		//super();
		
	}
	
	Item item;
	
	//number of each unique item
	private int amtOfItem = 0;
	
	
	//each implementation of Department has its own items
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	//Number of items in department
	static int item_counter = 0;
	
	
	/***
	 * Returns # of department instances. This represents 
	 * how many departments there are
	 ***/
	public int getDepartmentCounter() throws RemoteException {
		
		return item_counter;
	}
	
	/***
	 *   Returns String array containing type,description,price (as String)
	 *   for the element in the specified index. Use loop for entire catalog
	 ***/
	public String [] browseItems(int index) throws RemoteException {
		
		
		String [] s = new String [3];
		item=itemList.get(index);
		s[0] = item.getType();
		s[1] = item.getDescription();
		s[2] = String.valueOf(item.getPrice());
		return s;
		
	}
	
	
	
	/***
	 *  Update property of an item in arrayList
	 *  @propertyTypes: type,description,price
	 ***/
	public void updateItems(String type,String description,String newType,String newDescription,double newPrice) throws RemoteException {
		if(item_counter == 0)
			;
		else
		{
		for (int i = 0; i<item_counter; i++)
		{
			if(itemList.get(i).getType().equals(type) && itemList.get(i).getDescription().equals(description))
			{
				
				itemList.get(i).setType(newType);
				itemList.get(i).setDescription(newDescription);
				itemList.get(i).setPrice(newPrice);
			}
			
		}
		
	  }
		
	}
	
	
	/***
	 *  Add item to department objects arrayList 
	 *  @params String,String,double
	 ***/
	public void addItems(String type, String description, double price) throws RemoteException {
		item = new Item(type, description, price);
		itemList.add(item);
		item_counter++;
		
	}
	
	
	/***
	 * Remove all items in department arrayList
	 * User will see a confirmation prompt
	 ***/
	public void removeItems() throws RemoteException {
		for (int i = 0; i<item_counter; i++)
		{
			itemList.remove(i);
		}
	}
	
	
	/***
	 * Remove item from arrayList given by
	 * specified index
	 * @param type
	 * @param description
	 * @param price
	 ***/
	public void removeItems(String type,String description) throws RemoteException {
		if(item_counter == 0)
			;
		else
		{
		for (int i = 0; i<item_counter; i++)
		{
			if(itemList.get(i).getType().equals(type) && itemList.get(i).getDescription().equals(description))
			{
				itemList.remove(i);
				item_counter--;
			}
			
		}
		
	  }
	}
	
	
	
	
	@Override
	public void removeSingleItem(String type, String description) throws RemoteException {
		if(item_counter == 0)
			;
		else
		{
		for (int i = 0; i<item_counter; i++)
		{
			if(itemList.get(i).getType().equals(type) && itemList.get(i).getDescription().equals(description))
			{
				itemList.remove(i);
				item_counter--;
				return;
			}
			
		}
		
	  }
		
	}
	
	
	/***Searches through the item ArrayList for exact matches of type,description, and price
	 *  if matched, increment value which represents total amount in inventory
	 * @param type
	 * @param description
	 * @param price
	 * @return amtOfItem
	 ***/
	
	public int itemCount(String type,String description) throws RemoteException
	{
		amtOfItem = 0;
		for (int i = 0; i<item_counter; i++)
		{
			if(itemList.get(i).getType().equals (type) && itemList.get(i).getDescription().equals (description))
			{
				amtOfItem++;
			}
		}
		return amtOfItem;
	}

	
	
	
	

}
