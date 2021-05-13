package server;

import common.IItem;

public class System_Admin implements Iuser {

	
	
	
	private String username;
	private String password;
	
	static int adminID = 0;
	
	public System_Admin() {
		username = null;
		password = null;
	}
	
	public System_Admin(String user, String pass) {
		username = user;
		password = pass;
	}

	
	public String getUsername()
{
		return username;
}
	

	public String getPassword()
{
		return password;
}

	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

	
	
	
	
	
	
	
	
	/* Unused methods */
	
	public void getItem(IItem item) {
		
		
	}

	@Override
	public void purchaseItems() {
		
		
	}

	@Override
	public int getItemCounter() {
		
		return 0;
	}



}

