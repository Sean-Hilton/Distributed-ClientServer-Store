package server;




	import java.rmi.Remote;

import common.IItem;
	/***
	 * 
	 * Factory interface implemented by child classes
	 * System_Admin and Shopper
	 *
	 ***/
	public interface Iuser extends Remote{

		
		
		
		public String getUsername();

		
		public String getPassword();


		public void setPassword(String string);
		
		public void setUsername(String string);
		
		public void getItem(IItem item);
		
		public void purchaseItems();
		
	    public int getItemCounter();
		
		

	}

