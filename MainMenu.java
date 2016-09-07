package mainPackage;
import java.util.Scanner;

import mainPackage.Player;

public class MainMenu 
{
	final static Player [] playerDatabase = new Player[20];
	final static Player [] loginPlayers = new Player[2];
	final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{	
		Player player1 = new Player("coolguy69","********");
		playerDatabase[0] = player1;
		Player player2 = new Player("admin","password");
		playerDatabase[1] = player2;
		
		int userInput;
		do
		{
			printMainMenu();
			
			System.out.print("Enter selection: ");
			while (!sc.hasNextInt())
			{
				printMainMenu();
				sc.next(); // Resets the input without enter selection, prevents users from entering a letter
			}
			userInput = sc.nextInt();
			
			System.out.println();

			switch (Integer.valueOf(userInput)) // The number the user inputs correlates to a method below
			{

			case 1:
				createUser();
				break;

			case 2:
				loginPlayer1();
				break;
			
			case 3:
				loginPlayer2();
				break;
			
			case 4:
				if(loginPlayers[0]!= null && loginPlayers[1]!= null)
				{
					playGame(loginPlayers[0],loginPlayers[1]);
				}
				break;
			
			case 5:
				exitProgram();
				break;
			
			default:
				System.out.println("Error - invalid selection!");
			}
			System.out.print();
		}
		while (userInput != 0);
	}
	public static void printMainMenu()
	{
		System.out.println("========================== CHESS LIKE GAME ==========================");
		System.out.println();
		System.out.println("1. Sign up user");
		System.out.println("2. Login Player 1");
		System.out.println("3. Login Player 2");
		System.out.println("4. Play Game");
		System.out.println("5. Exit Game");
		
		System.out.println(
				"==============================================================================");
	}
	public static void createUser()
	{	
		System.out.println("Enter the Username:"); // username
		String username = sc.next();
		System.out.println("Enter the Password:"); // password of user
		String password = sc.next();
		
		int i;
		int j = playerDatabase.length; 
		for(i=0; i < j; i++)
		{
			if (playerDatabase[i].getUsername == username) // in case of errors
			{
				System.out.println("This username already exists, enter a valid username and try again");
				break; // continues are used so that it reloops again, this is done for all code in case there was a break function outside of all loops
			}
			if (playerDatabase[i] != null) // in case of errors
			{
				continue; // continues are used so that it reloops again, this is done for all code in case there was a break function outside of all loops
			}
			else if (playerDatabase[i] == null)
			{
				playerDatabase[i] = new Player(username,password); // creates a new object an immediately places inside of the holding array
				System.out.println("This player has been recorded into the system");
				System.out.println("----------------------------------------------");
				break;
			}
			else
			{
				System.out.println("Too many holdings, delete some holdings and try again");
				break;
			}
		}
		return;
	}
	public static void loginPlayer1() //9
	{
		System.out.println("Enter a valid player Username:");
		String searchedUser= sc.next();
		
		int i;
		int j = playerDatabase.length;
		System.out.println("----------------------------------------------");
		for(i=0; i < j; i++)
		{
			if (playerDatabase[i] == null)
			{
				continue;
			}
			else if(searchedUser.equals(playerDatabase[i].getUsername()))
			{
				System.out.println("Enter this User's Password:");	
				String password= sc.next(); 
				if(password.equals(playerDatabase[i].getPassword()))
				{
					System.out.println("Valid username and Password, logging in now");
					loginPlayer[0] = playerDatabase[i]; 
					break;
				}
				else
				{
					System.out.println("Invalid username and Password, logging in now");
					break;
				}
			}
			else
			{
				System.out.println("Invalid ID input");
				break;
			}
		}
  	return;
	}
	public static void loginPlayer2() 
	{
		System.out.println("Enter a valid player Username:");
		String searchedUser= sc.next(); 
		
		int i;
		int j = playerDatabase.length;
		System.out.println("----------------------------------------------");
		for(i=0; i < j; i++)
		{
			if (playerDatabase[i] == null)
			{
				continue;
			}
			else if(searchedUser.equals(playerDatabase[i].getUsername()))
			{
				System.out.println("Enter this User's Password:");	
				String password= sc.next(); // searches for input id then prints
				if(password.equals(playerDatabase[i].getPassword()))
				{
					System.out.println("Valid username and Password, logging in now");
					loginPlayer[1] = playerDatabase[i]; // set player 1 to login player
					break;
				}
				else
				{
					System.out.println("Invalid username and Password, logging in now");
					break;
				}
			}
			else
			{
				System.out.println("Invalid ID input");
				break;
			}
		}
  	return;
	}
	public static void exitProgram()
	{
		exit(0);
	}
}
