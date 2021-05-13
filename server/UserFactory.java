package server;

public class UserFactory {

	public static Iuser getUser (String userType)
	{
		if(userType == null)
			return null;
		
		if(userType.equalsIgnoreCase("ADMIN"))
		{
			return new System_Admin();
		}
		else if(userType.equalsIgnoreCase("SHOPPER"))
		{
			return new Shopper();
		}
		
		return null;
					
	}
	
}
