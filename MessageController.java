/***********************************************************************************
 * MessageController.java
 * Author: Thomas Minchew
 * Procedures:
 * main     	-	Implementation of MessageController class. Allows user to select a friend
 * 			   		to message from the FRIENDS_ARRAY (a substitute for friends Database)
 *             		selecting a friend by entering their username will send the user to the
 *             		Direct Message conversation between the two. It simulates a conversation by
 *             		printing messages left and right adjacent like a SMS Conversation.
 * 
 * isValid		-  takes a String as input and checks if it is within the minimum and maximum length.
 * sendMessage  -  calls isValid to check validity of a message before sending (printing to console)
 **********************************************************************************/
import java.util.*;
public class MessageController 
{
	public static final int MIN_MESSAGE_LENGTH = 1;
	public static final int MAX_MESSAGE_LENGTH = 256;
	public static final String ERROR_MESSAGE_1 = "This is over the 256-character limit!";
	public static final String ERROR_MESSAGE_2 = "Please enter a message!";
	public static final String[] FRIENDS_ARRAY = {"Jimmy132", "james", "hackerman"};
	public static int isValid(String m) 
	{
		int length = m.length();
		if(length > 0 && length <= 256)
		{
			return 0;
		}
		else if(length == 0)
			return 2;
		else
			return 1;
	}
	
	public static String sendMessage(String m)
	{
		int validity = isValid(m);
		if(validity == 0)
			return(m);
		else if(validity == 2)
			return(ERROR_MESSAGE_2);
		else
			return(ERROR_MESSAGE_1);
	}	
	
	public static void clearScreen() {  
	    System.out.flush();  
	}  
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int printSide = 0; // 0 print left, 1 print right
		int exitFlag = 0;
		while(true) 
		{
			System.out.println("Select a friend to message, or enter exit to leave this page");
			for(int i = 0; i < FRIENDS_ARRAY.length; i++)
			{
				System.out.println(FRIENDS_ARRAY[i]);
			}
			String entered = scan.next();
			for(int i = 0; i < FRIENDS_ARRAY.length; i++)
			{
				if(entered.equals(FRIENDS_ARRAY[i]))
				{
					clearScreen();
					
					System.out.println("Conversation with "+FRIENDS_ARRAY[i]);
					while(true) 
					{
						
						entered = sendMessage(scan.nextLine());
						if(entered.equals("exit")) 
						{
							exitFlag = 1;
							break;
						}
							
						if(printSide == 1) 
						{
							System.out.print("\t\t\t\t\t");
							System.out.println(entered);
							printSide = 0;
						} 
						else if(printSide == 0) 
						{
							System.out.println(entered);
							printSide = 1;
						}
						
					}
					
				}
				else if(entered.equals("exit")) {
					System.out.println("Leaving Messaging Page");
					System.exit(0);
				}
					
			}
			if(exitFlag == 0)
				System.out.println("No such friend exists!");
			exitFlag = 0;
		}
	}
}
