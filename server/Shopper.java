package server;

import java.rmi.RemoteException;
import java.util.ArrayList;

import common.IItem;

public class Shopper implements Iuser {
	
	IItem item;
    int itemCounter;
	ArrayList<IItem> cart = new ArrayList<IItem>();
	private String username;
	private String password;
	
	public Shopper(){
		username = null;
		password = null;
	}
	
	public Shopper(String user,String pass){
		username = user;
		password = pass;
	}
	
	
	
	public String getUsername(){
		
		return username;
}
	
	
	
	public String getPassword(){
		
		return password;
}

	@Override
	public void setPassword(String password) {
		this.password = password;
		
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
		
	}

	@Override
	public void getItem(IItem item) {
		this.item = item;
		
		cart.add(this.item);
		itemCounter++;
		
	}
	
	public void purchaseItems()
	{
	
			cart.clear();
			itemCounter = 0;
			
			
		
	}

	@Override
	public int getItemCounter() {
		
		return itemCounter;
	}
	
	
	
}
