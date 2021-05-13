package common;




import java.rmi.*;

public interface Idepartment extends Remote{

	/***
	 * Returns # of department instances. This represents 
	 * how many departments there are
	 ***/
	public int getDepartmentCounter() throws RemoteException;
	
	
	/***
	 *   Returns String array containing type,description,price (as String)
	 *   for the element in the specified index. Use loop for entire catalog
	 ***/
	public String [] browseItems(int index) throws RemoteException;
	
	
	/***
	 *  Update property of an item in arrayList
	 *  @propertyTypes: type,description,price
	 ***/
	public void updateItems (String type,String description,String newType,String newDescription,double newPrice)throws RemoteException;
	
	
	/***
	 *  Add item to department objects arrayList 
	 *  @params String,String,double
	 ***/
	public void addItems(String type,String description,double price) throws RemoteException;
	
	
	
	/***
	 * Remove all items in department arrayList
	 * User will see a confirmation prompt
	 ***/
	public void removeItems() throws RemoteException;
	
	
	/***
	 * Remove item from arrayList given by
	 * specified index
	 * @param type
	 * @param description
	 * @param price
	 ***/
	public void removeItems(String type,String description) throws RemoteException;
	
	
	
	public void removeSingleItem(String type, String description) throws RemoteException;
	
	/***Searches through the item ArrayList for exact matches of type,description, and price
	 *  if matched, increment value which represents total amount in inventory
	 * @param type
	 * @param description
	 * @param price
	 * @return amtOfItem
	 ***/
	public int itemCount(String type,String description) throws RemoteException;
		
		
	
	
	
}
