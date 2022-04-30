import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FriendManagementTest {

	accountInfo	james = new accountInfo("james", "111");
	accountInfo josh = new accountInfo("josh", "333");
	
	
	@Test
	void friendManagement_testcase_1() {
		assertEquals(FriendManagement.addFriend(james, "coolGuy22"), "Friend Request sent to: coolGuy22");
	}
	
	@Test
	void friendManagement_testcase_2() {
		assertEquals(FriendManagement.addFriend(james, "REALLYcoolGUY22withLONGusername"), "Error: Username is not valid in our system.");
	}
	
	
	@Test
	void friendManagement_testcase_3() {
		assertEquals(FriendManagement.addFriend(james, "james"), "Error: You are already friends with this user.");
	}

}