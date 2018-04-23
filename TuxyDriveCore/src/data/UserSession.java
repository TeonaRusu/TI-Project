package data;

public class UserSession {
	
	private static UserSession instance;
	
	private UserLogin user;
	
	private UserSession(){}
		
	public UserLogin getUser() {
		return user;
	}

	public void setUser(UserLogin user) {
		this.user = user;
	}

	public static UserSession getInstance ()
	{
		if (instance == null) {
			instance = new UserSession();
		}
		return instance;
	}
	
	public static void removeInstance ()
	{
		instance = null;
	}
}
