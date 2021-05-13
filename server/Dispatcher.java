package server;

public class Dispatcher {

	private AdminView adminView;
	private ShopperView shopperView;
	
	
	public Dispatcher()
	{
		adminView = new AdminView();
		shopperView = new ShopperView();
	}
	
	public void dispatch (String request)
	{
		if (request.equalsIgnoreCase("ADMIN"))
		{
			adminView.show();
		}
		
		else if (request.equalsIgnoreCase("SHOPPER"))
		{
			shopperView.show();
		}
		
	}
}
