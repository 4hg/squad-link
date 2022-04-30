/***********************************************************************************
 * FriendManagement.java
 * Author: Matthew Bedford
 * Explanation: This is my implementation of friend management critical systems in java.
 * First the system starts with 0 users in the database, and then users are created by using the sign up prompts.
 * Once users are created, they can log in and add their friends list. This can be checked by viewing their friends list as well.
 * Only existing users who are not on the users friends list can be added so there must be other users signed up within the database as well in order
 * to test this implementation of adding friends. Testing logging in and signing up can be done without making multiple though.
 **********************************************************************************/

import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FriendManagement
{
	public static final int MIN_USERNAME_LENGTH = 1;
	public static final int MAX_USERNAME_LENGTH = 14;
	public static final String SUCCESS_MESSAGE = "Friend Request sent to: ";
	public static final String ERROR_MESSAGE = "Error: Username is not valid in our system.";
	public static final String INVALID_MESSAGE = "Error: You are already friends with this user.";
	public static ArrayList<accountInfo> userDatabase = new ArrayList<accountInfo>();
    public static boolean loggedIn;
    public static accountInfo loggedInAccount;
		
	public static boolean isValid(String usr) 
	{
		int length = usr.length();
		if(length > 0 && length <= 14)
		{
			return true;
		}
		return false;
	}
	
	public static boolean onFriendsList(accountInfo account, String friend)
	{
		ArrayList<String> friendsList = account.getFriendsList(); 
		for(int i = 0; i < friendsList.size(); i++)
		{
			if(friendsList.get(i) == friend)
				return true;
		}
		return false;
	}

	public static String addFriend(accountInfo account, String usr)
	{
		if(isValid(usr) && !onFriendsList(account, usr))
		{
			account.addFriend(usr);
			return(SUCCESS_MESSAGE + usr);
		}
		else if(isValid(usr) && onFriendsList(account, usr))
			return(INVALID_MESSAGE);
		else
			return(ERROR_MESSAGE);
	}	

	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
        int intInput;
        String stringInput;
        String newUsername;
        String newPassword;
		String output;
        accountInfo tempAccount;
        boolean available;
        boolean temp = false;
        int tempIndex = 0;
        while(true)
        {
            if(loggedIn)
            {
                System.out.println("Press 1 to view your friends list.");
                System.out.println("Press 2 to add a friend.");
                System.out.println("Press 3 to sign out.");
                intInput = input.nextInt();
                if(intInput == 1)
                {
                    for(int i = 0; i < userDatabase.size(); i++)
                    {
                        if(userDatabase.get(i).getUsername().equals(loggedInAccount.getUsername()))
                        {
                            userDatabase.get(i).printFriendsList();
                        }
                    }
                }
                else if(intInput == 2)
                {
                    System.out.println("Enter the friend you would like to add: ");
                    stringInput = input.next();
					output = addFriend(loggedInAccount, stringInput);
					System.out.println(output);
                }
                else if(intInput == 3)
                {
                    loggedIn = false;
                }
                else
                {
                    System.out.println("Not a valid input.");
                }
            }
            else
            {
                System.out.println("Press 1 to login.");
                System.out.println("Press 2 to sign up.");
                intInput = input.nextInt();

                if(intInput == 1)
                {
                    while(intInput == 1)
                    {
                        System.out.println("Enter your username: ");
                        stringInput = input.next();

                        available = false;
                        for(int i = 0; i < userDatabase.size(); i++)
                        {
                            if(userDatabase.get(i).getUsername().equals(stringInput))
                            {
                                available = true;
                                tempIndex = i;
                            }
                        }

                        if(available)
                        {
                            while(intInput == 1)
                            {
                                System.out.println("Enter your password: ");
                                stringInput = input.next();
                                if(userDatabase.get(tempIndex).getPassword().equals(stringInput))
                                {
                                    loggedIn = true;
                                    loggedInAccount = userDatabase.get(tempIndex);
                                    intInput = 2;
                                }
                                else
                                {
                                    System.out.println("Incorrect password, try again?");
                                    System.out.println("Press 1 to try again.");
                                    System.out.println("Press 2 to restart.");
                                    intInput = input.nextInt();
                                }
                            }
                        }
                        else
                        {
                            System.out.println(stringInput + " does not exist as a username.");
                            System.out.println("Press 1 to try again.");
                            System.out.println("Press 2 to go back to sign up page.");
                            intInput = input.nextInt();
                        }
                    }
                }
                else if(intInput == 2)
                {
                    System.out.println("Please enter a username you would like to have: ");
                    stringInput = input.next();
                    available = true;
                    for(int i = 0; i < userDatabase.size(); i++)
                    {
                        if(userDatabase.get(i).getUsername().equals(stringInput))
                            available = false;
                    }
                    if(available)
                    {
                        newUsername = stringInput;
                        System.out.println("Please enter the password you would like to have: ");
                        stringInput = input.next();
                        newPassword = stringInput;
                        System.out.println("Your account has been created and you are now signed in.");
                        tempAccount = new accountInfo(newUsername, newPassword);
                        userDatabase.add(tempAccount);
                        loggedIn = true;
                        loggedInAccount = tempAccount;
                    }
                }
                else
                    System.out.println("That is not an available option. Please try again.");
            }
        }
    }
}