/***********************************************************************************
 * signUpLogIn.java
 * Author: Matthew Bedford
 * Explanation: This is my implementation of sign up/login critical systems in java.
 * First the system starts with 0 users in the database, and then users are created by using the sign up prompts.
 * Once users are created, they can log in.
 **********************************************************************************/

import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class AccountCreation {
	public static final String VALID_INPUT = "Account Created.";
	public static final String INVALID_INPUT = "Invalid Format.";
	public static final String EXCEPTION_INPUT = "Account Exists.";
	public static final int MAX_USER_LENGTH = 15;
	public static ArrayList<accountInfo> userDatabase = new ArrayList<accountInfo>();
	public static boolean loggedIn;
    public static String loggedInUsername;
	
	public static boolean valid(String user, String pass) {
		int userLength = user.length();
		int passLength = pass.length();
		boolean upper, lower, num, max;
		upper = false;
		lower = false;
		num = false;
		max = false;
		
		if(userLength < MAX_USER_LENGTH) 
			max = true;
		
		for(int i = 0; i < passLength; i++) {
			if(Character.isUpperCase(pass.charAt(i))) 
				upper = true;
			if(Character.isLowerCase(pass.charAt(i)))
				lower = true;
			if(Character.isDigit(pass.charAt(i)))
				num = true;
		}
		
		if(max && upper && lower && num)
			return true;
		else
			return false;
	}
	
	public static boolean accntExists(String user) {
		// Imported from DB Manager 
		int DBSize = userDatabase.size();
		for(int i = 0; i < DBSize; i++) {
			if(userDatabase.get(i).getUsername().equals(user))
				return false;
		}
		return true;
	}
	
	public static String createAccount(accountInfo account) {
		if(!valid(account.getUsername(), account.getPassword()))
			return INVALID_INPUT;
		else if(!accntExists(account.getUsername()))
			return EXCEPTION_INPUT;
		else
		{
			userDatabase.add(account);
			return VALID_INPUT;
		}
	}

	public static void main(String args[])
	{
        Scanner input = new Scanner(System.in);
        int intInput;
        String stringInput;
		String stringInput2;
		String output;
        accountInfo tempAccount;
        boolean available;
        int tempIndex = 0;
        while(true)
        {
            if(loggedIn)
            {
                System.out.println("Logged in as: " + loggedInUsername);
                System.out.println("Press 1 to sign out.");
                intInput = input.nextInt();
                if(intInput == 1)
                {
                    System.out.println("You have been signed out.");
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
                System.out.println("Press 3 to end program.");
                intInput = input.nextInt();

                if(intInput == 1)
                {
                    while(intInput == 1)
                    {
                        System.out.println("Enter your username: ");
                        stringInput = input.next();

                        available = !accntExists(stringInput);

                        if(available)
                        {
                            while(intInput == 1)
                            {
                                System.out.println("Enter your password: ");
                                stringInput = input.next();
                                if(userDatabase.get(tempIndex).getPassword().equals(stringInput))
                                {
                                    loggedIn = true;
                                    loggedInUsername = userDatabase.get(tempIndex).getUsername();
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
                    if(!accntExists(stringInput))
                    {
                        System.out.println(EXCEPTION_INPUT);
                    }
                    else
                    {
                        System.out.println("Please enter the password you would like to have: ");
                        stringInput2 = input.next();
                        tempAccount = new accountInfo(stringInput, stringInput2);
                        output = createAccount(tempAccount);
                        System.out.println(output);
                        if(output == VALID_INPUT)
                        {
                            System.out.println("Your account has been created and you are now signed in.");
                            loggedIn = true;
                            loggedInUsername = tempAccount.getUsername();
                        }
                    }
                }
                else if(intInput == 3)
                {
                    return;
                }
                else
                    System.out.println("That is not an available option. Please try again.");
            }
        }
	}
}
