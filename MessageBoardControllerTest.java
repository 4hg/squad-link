import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MessageBoardControllerTest {
    @Test
    void messageBoardController_testcase_1() {
        assertEquals(MessageBoardController.createBoard("New Board", "A brand new board."),
                "New Board:A brand new board.");
    }
    
    @Test
    void messageBoardController_testcase_2() {
        assertEquals(MessageBoardController.createBoard("Empty Board Description", ""),
                "Error creating board.");
    }

    @Test
    void messageBoardController_testcase_3() {
        assertEquals(MessageBoardController.createBoard("", "Empty board name"),
                "Error creating board.");
    }

    @Test
    void messageBoardController_testcase_4() {
        assertEquals(MessageBoardController.createBoard("General Board", "General board copy"),
                "Message board exists");
    }
}