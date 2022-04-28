// Author: Luke De La Cruz

import java.util.*;
public class MessageBoardController {
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 256;
    public static final String ERROR_MESSAGE = "Error creating board.";
    public static final String EXCEPTION_MESSAGE = "Message board exists";
    private static final ArrayList<String> DB_BOARDS = new ArrayList<>(
            Arrays.asList("General Board", "Competitive Puzzle Games", "FPS"));


    public static boolean validDesc(String desc) {
        for (int i = 0; i < desc.length(); ++i) {
            int charCode = desc.charAt(i);

            if (charCode < 32 || charCode == 127)
                return false;
        }
        return true;
    }

    public static boolean isValid(String name, String desc) {
        int nameLength = name.length();
        int descLength = desc.length();

        boolean nLengthCheck = nameLength >= MIN_LENGTH && nameLength <= MAX_LENGTH;
        boolean dLengthCheck = descLength >= MIN_LENGTH && descLength <= MAX_LENGTH;
        return nLengthCheck && dLengthCheck && validDesc(desc);
    }

    public static boolean boardExists(String name) {
        for (String board : DB_BOARDS) {
            if (board.equals(name))
                return true;
        }
        return false;
    }

    public static String createBoard(String name, String desc) {
        if (isValid(name, desc) && !boardExists(name)) {
            DB_BOARDS.add(name);
            return name + ":" + desc;
        } else if (boardExists(name))
            return EXCEPTION_MESSAGE;
        else
            return ERROR_MESSAGE;
    }

    public static void listBoards() {
        System.out.println("BOARD LIST:");
        for (String board : DB_BOARDS)
            System.out.println(board);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int bFlag = 0;

        System.out.println("Board Creation Interface");
        System.out.println("Options:\n  c - create\n  l - list\n  e - exit");
        System.out.println();

        while (bFlag == 0) {
            System.out.print("> ");
            char choice = kb.next().charAt(0);
            kb.nextLine();
            switch(choice) {
                case 'c':
                    System.out.println("Enter board name: ");
                    String name = kb.nextLine();
                    System.out.println("Enter description: ");
                    String desc = kb.nextLine();
                    String creation = createBoard(name, desc);
                    if (creation.equals(name + ":" + desc))
                        System.out.println("Board Creation Succeeded");
                    else
                        System.out.println(creation);
                    break;
                case 'l':
                    listBoards();
                    break;
                case 'e':
                    bFlag++;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
            System.out.println();
        }
        System.out.println("Exiting.");
    }
}
