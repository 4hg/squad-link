import java.util.ArrayList;

public class accountInfo
{
    private String username;
    private String password;
    private ArrayList<String> friendsList;

    public accountInfo(String username, String password)
    {
        this.username = username;
        this.password = password;
        friendsList = new ArrayList<String>();
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

	public ArrayList<String> getFriendsList()
	{
		return friendsList;
	}

    public void printFriendsList()
    {
        System.out.println("Friends List: ");

        for(int i = 0; i < friendsList.size(); i++)
        {
            System.out.println(friendsList.get(i));
        }
    }

    public boolean addFriend(String friend)
    {
        for(int i = 0; i < friendsList.size(); i++)
        {
            if(friendsList.get(i).equals(friend))
            {
                System.out.println("That user is already on your friends list.");
                return false;
            }
        }
        friendsList.add(friend);
        return true;
    }
}