package server;

import java.rmi.*;
import java.rmi.registry.*;

import common.IItem;
import common.Icommand;
import common.Idepartment;


/***
 * 
 * This class binds a remote object to the rmi registry at the machine specified.
 *
 ***/
public class RemoteAccount {
		public static void main (String args[]) {
			try {
				
				Idepartment groceryDept = new Department();
				Naming.rebind("rmi://in-csci-rrpc01:2327/Department", groceryDept);
				
				Icommand addItemCommand = new AddItemCommand();
				Naming.rebind("rmi://in-csci-rrpc01:2327/AddItemCommand", addItemCommand);
				
				Icommand removeItemCommand = new RemoveItemCommand();
				Naming.rebind("rmi://in-csci-rrpc01:2327/RemoveItemCommand", removeItemCommand);
				
				Icommand browseItemsCommand = new BrowseItemsCommand();
				Naming.rebind("rmi://in-csci-rrpc01:2327/BrowseItemsCommand", browseItemsCommand);
				
				Icommand updateItemCommand = new UpdateItemCommand();
				Naming.rebind("rmi://in-csci-rrpc01:2327/UpdateItemCommand", updateItemCommand);
				
				IItem item = new Item();
				Naming.rebind("rmi://in-csci-rrpc01:2327/Item", item);
				
				
				System.out.println("Server is ready");
			}catch(Exception e) {
				
				System.out.println("Server err: " + e.getMessage());
				e.printStackTrace();
			}
		}
}
