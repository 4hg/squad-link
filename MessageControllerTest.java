import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MessageControllerTest {

	@Test
	void messageController_testcase_1() {
		assertEquals(MessageController.sendMessage("Hey!"), "Hey!");
	}
	
	@Test
	void messageController_testcase_2() {
		assertEquals(MessageController.sendMessage("whwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwhwh"), "This is over the 256-character limit!");
	}
	
	@Test
	void messageController_testcase_3() {
		assertEquals(MessageController.sendMessage(""), "Please enter a message!");
	}

}
