package seedu.duke.utility;

import java.util.Scanner;

/**
 * Represents a Ui class that is responsible for Input/Output operations.
 */
public class Ui {

    public static final String ANSI_GREEN = "\u001B[92m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_REVERSE = "\u001b[7m";
    public static final String ANSI_BOLD = "\u001b[1m";
    public static final String SAVE_DIRECTORY = "data/showList.txt";

    private Scanner scan;

    public Ui() {
        scan = new Scanner(System.in);
    }

    public static void printLogo() {
        String logo = " __          __  _______ _____ _    _ _   _ ________   _________ \n"
                + " \\ \\        / /\\|__   __/ ____| |  | | \\ | |  ____\\ \\ / /__   __|\n"
                + "  \\ \\  /\\  / /  \\  | | | |    | |__| |  \\| | |__   \\ V /   | |   \n"
                + "   \\ \\/  \\/ / /\\ \\ | | | |    |  __  | . ` |  __|   > <    | |   \n"
                + "    \\  /\\  / ____ \\| | | |____| |  | | |\\  | |____ / . \\   | |   \n"
                + "     \\/  \\/_/    \\_\\_|  \\_____|_|  |_|_| \\_|______/_/ \\_\\  |_|   \n";

        System.out.println(ANSI_GREEN + logo + ANSI_RESET);
    }

    public void hello() {
        printLine();
        printLogo();
        printLine();
        System.out.println("Welcome to WatchNext");
        System.out.println("Type " + toReverse("help") + " to get started!\n");
    }

    public static void printLine() {
        System.out.println("________________________________________________________________________________");
    }

    public static void printByeMessage() {
        printLine();
        System.out.println(" Bye. Thank you for using WatchNext <3");
        printLine();
    }

    public static void printHelp() {
        printLine();
        // TODO load from txt file if possible instead of writing out one whole chunk in the future
        String helpIcon =
                " __    __   _______  __      .______   \n"
                + "|  |  |  | |   ____||  |     |   _  \\  \n"
                + "|  |__|  | |  |__   |  |     |  |_)  | \n"
                + "|   __   | |   __|  |  |     |   ___/  \n"
                + "|  |  |  | |  |____ |  `----.|  |      \n"
                + "|__|  |__| |_______||_______|| _|      \n";

        System.out.println(ANSI_GREEN + helpIcon + ANSI_RESET);
        System.out.println("The following options are available:");
        System.out.println("`help` - Views help\n"
                + " \n"
                + "'add` - Adds a show\n"
                + " \n"
                + "`edit` - Edits your show details\n"
                + " \n"
                + "`rating` - Set rating of your show\n"
                + "\n"
                + "`list` - Displays all your shows in list\n"
                + "\n"
                + "`delete` - Deletes your show\n"
                + " \n"
                + "`deleterating` - Deletes rating of your show\n"
                + "\n"
                + "`changerating` - Changes rating of your show\n"
                + "\n"
                + "`save` - Saves your shows\n"
                + "\n"
                + "`bye` - Exits the program\n");
        printLine();
    }
    
    public String getUserCommand() {
        String userInput = scan.nextLine();

        //Take out all empty/whitespace lines
        while (isInputEmpty(userInput)) {
            userInput = scan.nextLine();
        }

        return userInput;
    }

    private boolean isInputEmpty(String rawInput) {
        return rawInput.trim().isEmpty();
    }

    public static String toReverse(String input) {
        return ANSI_REVERSE + input + ANSI_RESET;
    }

    public static String toBold(String input) {
        return ANSI_BOLD + input + ANSI_RESET;
    }

    public static void printLineIcon() {
        System.out.println("Enter a command: ");
    }

    public static void printShowList(ShowList showList) {
        printLine();
        System.out.println("Your watchlist:");
    }

    public static void printShowRating(String showName, String rating) {
        printLine();
        System.out.println("The rating for " + toBold(showName) + " has been updated to " + toBold(rating));
    }

    public static void printChangeRating(String showName, String rating) {
        printLine();
        System.out.println("The rating for " + toBold(showName) + " has been updated to " + toBold(rating));
    }

    public static void printDeleteRating(String showName) {
        printLine();
        System.out.println("The rating for " + toBold(showName) + " has been deleted.");
    }

    public static void printDeleteShow(String showName) {
        printLine();
        System.out.println(toBold(showName) + " has been deleted.");
    }

    public static void printShowAdded(String showName) {
        printLine();
        System.out.println(toBold(showName) + " was added to your watchlist.");
    }

    public static void queryEditShow(String showName) {
        printLine();
        System.out.println("What details would you like to edit for " + toBold(showName) + "?");
    }

    public static void printSavedList() {
        printLine();
        System.out.println("Your watchlist has been saved in the file with path <filepath>.");
    }

    public static void printIoException() {
        System.out.println(ErrorHandling.ExceptionResponse.EXCEPTION_IO_EXCEPTION);
    }

    public static void printNoDescriptionException() {
        System.out.println(ErrorHandling.ExceptionResponse.EXCEPTION_NO_DESCRIPTION);
    }

    public static void printNoTimeException() {
        System.out.println(ErrorHandling.ExceptionResponse.EXCEPTION_NO_TIME_DATA);
    }

    public static void printNoInputException() {
        System.out.println(ErrorHandling.ExceptionResponse.EXCEPTION_UNIDENTIFIED_INPUT);
    }

    public static void printInvalidDateException() {
        System.out.println(ErrorHandling.ExceptionResponse.EXCEPTION_INVALID_SEARCH_DATE);
    }

    public static void printNotFoundException() {
        System.out.println(ErrorHandling.ExceptionResponse.EXCEPTION_NOT_FOUND_EXCEPTION);
    }

    public static void printBadInputException() {
        System.out.println(ErrorHandling.ExceptionResponse.EXCEPTION_INVALID_INPUT);
    }

    public static void showCreateFileError() {
        System.out.println(ErrorHandling.ExceptionResponse.EXCEPTION_CREATE_FILE_ERROR);
    }

}

