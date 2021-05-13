package client;



import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import common.IItem;
import common.Idepartment;
import common.Icommand;

import server.AddItemCommand;
import server.Department;
import server.Item;
import server.Iuser;

import server.Shopper;
import server.Store_Model;
import server.System_Admin;
import server.UserFactory;

public class StoreClient {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String type,description;
		String [] infoString = new String [3];
		double price;
		int x = 0;
		
		Icommand addItem;   //addItem command
		Icommand browseItems; // browseItem command
		Icommand removeItems; //removeItems
		Icommand updateItems;
		IItem item;
		Idepartment groceryDept;
		Store_Model model = new Store_Model();
		
		
		
		
			try {
				  groceryDept = (Idepartment)Naming.lookup("rmi://in-csci-rrpc01:2327/Department");
				  addItem = (Icommand)Naming.lookup("rmi://in-csci-rrpc01:2327/AddItemCommand");
				  browseItems = (Icommand)Naming.lookup("rmi://in-csci-rrpc01:2327/BrowseItemsCommand");
				  removeItems = (Icommand)Naming.lookup("rmi://in-csci-rrpc01:2327/RemoveItemCommand");
				  updateItems = (Icommand)Naming.lookup("rmi://in-csci-rrpc01:2327/UpdateItemCommand");
				  item = (IItem)Naming.lookup("rmi://in-csci-rrpc01:2327/Item");
			
		
	
		
		System.out.println("Welcome user, please select proper login option\n"
						  + "1. Admin\n"
						  + "2. Shopper\n");
		
		int y = in.nextInt();
		
		
		
		/***
		 * Presented here is the "menu" that decides which version
		 * of the "view" will be used. For assignment 3, I plan
		 * on crafting actual views for each type of user
		 * 
		 * Outer switch- Type of user
		 * 
		 * Inner switch- Deals with registration type which will
		 * matter for assignment 3
		 * 
		 ***/
				
		
		switch (y)
		{
		case 1:
			x=0;
			Iuser admin = UserFactory.getUser("ADMIN");
			while(x!=1 && x!=2)
			{
				
				
				System.out.println("You're an Admin: New registration or existing admin?\n"
						         + "1. New registration\n"
						         + "2. Existing admin\n");
				x = in.nextInt();
				in.nextLine();
				switch(x)
				{
				case 1:
					System.out.println("Please enter username: ");
					admin.setUsername(in.nextLine());
					System.out.println("Please enter password: ");
					admin.setPassword(in.nextLine());
					
					model.newRegistrationAdmin(admin.getUsername(), admin.getPassword());
					
					break;
				case 2:
					System.out.println("Please enter username: ");
					admin.setUsername(in.nextLine());
					System.out.println("Please enter password: ");
					admin.setPassword(in.nextLine());
					
					
					
					if(model.isAuthenticatedAdmin(admin.getUsername()) == false || model.isAuthenticatedAdmin(admin.getPassword()) == false )
					{
						System.out.println("\nAuthentication failed");
						x = 3;
					}
					break;
				default: 
					System.out.println("Invalid Choice");
				
				}
			}
		
			
			//AFTER THIS POINT, INVOKE ADMIN VIEW FROM DISPATCHER
			
			while(x != 5)
			{
				
				model.dispatchRequest("ADMIN"); //displays admin view
				
				
				x = in.nextInt();
				in.nextLine();
				
				
				/***
				 * This switch statement involves operations that an 
				 * admin can perform. Type of operations are listed
				 * above.
				 * 
				 * Note*
				 * 
				 * Case1- Items added are added with the departments 
				 * add method. This involves adding an object of type
				 * "Item" to the arrayList unique to each department
				 * 
				 ***/
				switch (x)
				{
				case 1: System.out.println("Enter type: ex 'Grocery'");
						type = in.nextLine();
						System.out.println("Enter description: ex 'Apple'");
						description = in.nextLine();
						System.out.println("Enter price: ex '2.00'");
						price = in.nextDouble();
						in.nextLine();
						addItem.getParameters(type, description, price);
						
						
						groceryDept = addItem.execute();
					  
					   
						break;
						
				case 2:
					
					groceryDept = addItem.returnDepartment();
					browseItems.getParameters(groceryDept);
					System.out.println("ITEMCOUNT: " + groceryDept.getDepartmentCounter());
					if(groceryDept.getDepartmentCounter() == 0)
						System.out.println("No product in department\n");
					else
					{
						groceryDept = browseItems.execute();
						for(int i = 0; i<groceryDept.getDepartmentCounter(); i++)
						{
							infoString = groceryDept.browseItems(i);
							System.out.println("\n" +infoString[0] + " " + infoString[1] + " " + infoString[2] + "\n");
						}
					}
					break;
				
				case 3:
					
					
					if(groceryDept.getDepartmentCounter() == 0)
						System.out.println("No product in department\n");
					else
					{
						System.out.println("Enter type to remove: ex 'Grocery'\n");
						type = in.nextLine();
						System.out.println("Enter description to remove: ex 'Apple'\n");
						description = in.nextLine();
						removeItems.getParameters(type,description);
						removeItems.getParameters(groceryDept);
						groceryDept = removeItems.execute();
						 
						System.out.println("\nRequested item removed");
					}
					
					break;
			
				case 4:
					if(groceryDept.getDepartmentCounter() == 0)
						System.out.println("No product in department\n");
					else
					{
						String newType,newDescription; // for updating product label with these strings
						double newPrice;
						System.out.println("Enter type to update: ex 'Grocery'\n");
						type = in.nextLine();
						System.out.println("\nEnter NEW type: ex 'Grocery'\n");
						newType = in.nextLine();
						System.out.println("Enter description to update: ex 'Apple'\n");
						description = in.nextLine();
						System.out.println("\nEnter NEW description: ex 'Apple'\n");
						newDescription = in.nextLine();
						System.out.println("Enter NEW price: ex '2.00'\n");
						newPrice = in.nextDouble();
						
						updateItems.getParameters(groceryDept);
						updateItems.getParameters(type, description, newType, newDescription, newPrice);
						groceryDept = updateItems.execute();
					}
					break;
				case 5:
					System.exit(0);
					
				default:
					System.out.println("Invalid choice");
				
				}//end switch
			}//end while
			
		
			
			break; // break case 1 (admin) of most outer switch
		
		
			
		/***
		 * This case presents itself much like case 1.
		 * There are a few differences such as wording
		 * and ability to do certain actions
		 * 	
		 ***/
			
		case 2:  //Starts case 2 (shopper) of most outer switch
			x=0;
			Iuser shopper = UserFactory.getUser("SHOPPER");
		    
			while(x!=1 && x!=2)
			{
				System.out.println("You're a shopper: New registration or existing account?\n"
				         + "1. New registration\n"
				         + "2. Existing shopper\n");
				x = in.nextInt();
				in.nextLine();
				
				
				switch(x)
				{
				case 1:
					System.out.println("Please enter username: ");
					shopper.setUsername(in.nextLine());
					System.out.println("Please enter password: ");
					shopper.setPassword(in.nextLine());
					
					model.newRegistrationShopper(shopper.getUsername(), shopper.getPassword());
					
					break;
				case 2:
					System.out.println("Please enter username: ");
					shopper.setUsername(in.nextLine());
					System.out.println("Please enter password: ");
					shopper.setPassword(in.nextLine());
					
					if(model.isAuthenticatedShopper(shopper.getUsername()) == false || model.isAuthenticatedShopper(shopper.getPassword()) == false )
					{
						System.out.println("\nAuthentication failed");
						x = 3;
					}
					break;
				default: 
					System.out.println("Invalid Choice");
		
				}
			}
		
			
			while(x != 4 )
			{
				
			
				model.dispatchRequest("SHOPPER");
				
				x = in.nextInt();
				in.nextLine();
				
				
				
				/***
				 * This switch statement involves operations that a
				 * shopper can perform. Type of operations are listed
				 * above.
				 * 
				 ***/
				switch (x)
				{
				case 1: 
						int itemAmt=-1;
						do {
						System.out.println("\nPlease enter type of item you wish to add to cart.  Ex: 'Grocery'");
						type = in.nextLine();
						item.setType(type);
						System.out.println("\nPlease enter description of item you wish to add to cart.  Ex: 'Apple'");
						description = in.nextLine();
						item.setDescription(description);
						System.out.println("\nHow many of this would you like to add to cart?");
						itemAmt = in.nextInt();
						System.out.println("\n");
						in.nextLine();
						if(groceryDept.itemCount(type, description) < itemAmt)
							System.out.println("\nERROR: Not enough stock\n" + "Availability: " + groceryDept.itemCount(type, description));
						}while(itemAmt > groceryDept.itemCount(type, description));
						
						for(int i = 0; i < itemAmt; i++)
						{	
						shopper.getItem(item);  //adds to shopping cart
						groceryDept.removeSingleItem(type, description);
						
						}
						break;
						
				case 2:
						groceryDept = addItem.returnDepartment();
						browseItems.getParameters(groceryDept);
						System.out.println("ITEMCOUNT: " + groceryDept.getDepartmentCounter());
						if(groceryDept.getDepartmentCounter() == 0)
						System.out.println("No product in department\n");
					else
					{
						groceryDept = browseItems.execute();
						for(int i = 0; i<groceryDept.getDepartmentCounter(); i++)
						{
							infoString = groceryDept.browseItems(i);
							System.out.println("\n" +infoString[0] + " " + infoString[1] + " " + infoString[2] + "\n");
						}
					}
					

					break;
					
			
				case 3:
						if(shopper.getItemCounter()==0)
							System.out.println("No purchase. Cart is empty");
				
						else
						{
							System.out.println("Cart is now cleared.");
							System.out.println("Thank you for your purchase.\n");
							shopper.purchaseItems();
						}
					break;
					
				case 4:
					System.exit(0);
				default:
					System.out.println("Invalid choice");
				
				}//end switch
			}//end while
			
		}//end switch
			}//end try
			catch (Exception e) {
				System.out.println("Client err: " + e.getMessage());
				e.printStackTrace();
			}
		}//end main
	

		

	}
	
			



