package mainPackage;

public class Player 
{
	private String username;
	private String password;
	
	public Player(String playerUserName, String playerPassWord) 
	{
		this.username = playerUserName;
		this.password = playerPassWord;
	}
	public String getUserName() 
	{
		return username;
	}

	public void setId(String newUsername) 
	{
		this.username = newUsername;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String newPassword) 
	{
		this.password = newPassword;
	}
}
