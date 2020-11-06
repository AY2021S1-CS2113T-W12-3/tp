package seedu.duke.utility;

import seedu.duke.classes.Show;
import seedu.duke.classes.WatchTime;
import seedu.duke.commands.SearchCommand;
import seedu.duke.utility.ErrorHandling.ExceptionResponse;

import java.time.LocalDate;
import java.util.Scanner;


//@@author BenardoTang

/**
 * Represents a Ui class that is responsible for Output operations.
 */
public class Ui {

    public static final String SAVE_DIRECTORY = "data/userData.txt";

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

        System.out.println(logo);
    }

    /**
     * Prints a greeting message to the user.
     */
    public void hello() {
        printLine();
        printLogo();
        printLine();
        System.out.println("Welcome to WatchNext\n");
        printDailyWatchTracking();
        System.out.println("Type " + ("help") + " to get started!\n");
    }

    /**
     * Prints a line in the terminal and line break to enhance readability.
     */
    public static void printLine() {
        System.out.println("________________________________________________________________________________");
    }

    /**
     * Prints a farewell message to the user.
     */
    public static void printByeMessage() {
        printSavedList();
        System.out.println(" Bye. Thank you for using WatchNext <3");
        printLine();
    }

    /**
     * Prints a help list of available commands and description to the user.
     */
    public static void printHelp() {
        printLine();
        String helpIcon =
                " __    __   _______  __      .______   \n"
                    + "|  |  |  | |   ____||  |     |   _  \\  \n"
                    + "|  |__|  | |  |__   |  |     |  |_)  | \n"
                    + "|   __   | |   __|  |  |     |   ___/  \n"
                    + "|  |  |  | |  |____ |  `----.|  |      \n"
                    + "|__|  |__| |_______||_______|| _|      \n";

        System.out.println(helpIcon);
        System.out.println("Enter the 'example' command for help on the command format.");
        System.out.println(("help") + " - Views help\n"
                + " \n"
                + ("example") + " - Outlines command format\n"
                + " \n"
                + ("add") + " - Adds a show\n"
                + " \n"
                + ("edit") + " - Edits your show details\n"
                + " \n"
                + ("list") + " - Displays all your shows in the watchlist\n"
                + "\n"
                + ("delete") + " - Deletes your show\n"
                + " \n"
                + ("addreview") + " - Adds a review to your show\n"
                + "\n"
                + ("changereview") + " - Changes review of your show\n"
                + "\n"
                + ("deletereview") + " - Deletes review of your show\n"
                + "\n"
                + ("deleterating") + " - Deletes rating of your show\n"
                + "\n"
                + ("changerating") + " - Changes rating of your show\n"
                + "\n"
                + ("episode") + " - Update your current episode progress\n"
                + "\n"
                + ("season") + " - Update your current season progress\n"
                + "\n"
                + ("search") + " - Look for your show in the watchlist\n"
                + "\n"
                + ("updatetimelimit") + " - Update your watch time limit\n"
                + "\n"
                + ("watch") + " - Update your watch progress\n"
                + "\n"
                + ("bye") + " - Exits the program\n");
        System.out.println("Refer to our user guide for more help!");
        printLine();
    }

    /**
     * Prints a help list of the correct command format to the user.
     */
    public static void printExample() {
        printLine();
        String exampleIcon =
                "  ________   __          __  __ _____  _      ______ \n"
                + " |  ____\\ \\ / /    /\\   |  \\/  |  __ \\| |    |  ____|\n"
                + " | |__   \\ V /    /  \\  | \\  / | |__) | |    | |__   \n"
                + " |  __|   > <    / /\\ \\ | |\\/| |  ___/| |    |  __|  \n"
                + " | |____ / . \\  / ____ \\| |  | | |    | |____| |____ \n"
                + " |______/_/ \\_\\/_/    \\_\\_|  |_|_|    |______|______|\n"
                + "                                                     \n";

        System.out.println(exampleIcon);
        System.out.println("Example of commands for our available features:");
        System.out.println(("help") + " -> help\n"
                + " \n"
                + ("add") + " -> add <SHOWNAME> <SEASON> <NUMBER OF EPISODES PER SEASON SEPARATED BY COMMAS> "
                + "<DURATION OF EPISODE>\n"
                + " \n"
                + ("edit") + " -> edit <SHOWNAME>\n"
                + " \n"
                + ("list") + " -> list\n"
                + "\n"
                + ("delete") + " -> delete <SHOWNAME>\n"
                + " \n"
                + ("addreview") + " -> addreview <SHOWNAME> <RATING> / <REVIEW>\n"
                + "\n"
                + ("changereview") + " -> changereview <SHOWNAME> / <REVIEW>\n"
                + "\n"
                + ("deletereview") + " -> deletereview <SHOWNAME>\n"
                + "\n"
                + ("deleterating") + " -> deleterating <SHOWNAME>\n"
                + "\n"
                + ("changerating") + " -> changerating <SHOWNAME> / <NEWRATING>\n"
                + "\n"
                + ("episode") + " -> episode <SHOWNAME> <EPISODE>\n"
                + "\n"
                + ("season") + " -> season <SHOWNAME> <SEASON>\n"
                + "\n"
                + ("search") + " -> search <SHOWNAME>\n"
                + "\n"
                + ("updatetimelimit") + " -> updatetimelimit <DURATION LIMIT>\n"
                + "\n"
                + ("watch") + " -> watch <SHOWNAME>\n"
                + "\n"
                + ("bye") + " -> bye\n");
        System.out.println("Refer to our user guide for more explanation on the format!");
        printLine();
    }

    /**
     * Removes empty/whitespace lines when user copy-pastes input that may result in unknown errors.
     * @return valid input by user.
     */
    public String getUserCommand() {
        String userInput = scan.nextLine();

        while (isInputEmpty(userInput)) {
            userInput = scan.nextLine();
        }

        return userInput;
    }

    private boolean isInputEmpty(String rawInput) {
        return rawInput.trim().isEmpty();
    }

    /**
     * Adds a marker to alert the user that the application is ready to process his input.
     */
    public static void promptUser() {
        System.out.println("Enter a command: ");
    }

    /**
     * Prints the watch list of the user.
     */
    public static void printShowList() {
        printLine();
        System.out.println("Your watchlist:");
        for (Show show : ShowList.showList.values()) {
            System.out.println("\t" + show.toString());
        }
        printLine();
    }

    /**
     * Prints out the current watch tracking progress of the user, on application startup.
     */
    public static void printDailyWatchTracking() {
        //Print when user starts program
        LocalDate date = WatchTime.getRecordedDate();
        System.out.println("It is " + date + ".");
        boolean isWatchLimitSet = WatchTime.getDailyWatchLimit() != 0;
        if (isWatchLimitSet) {
            System.out.println("Time spent on shows today: " + WatchTime.getDurationWatchedToday() + " minutes.");
            System.out.println("Watch limit is set at " + WatchTime.getDailyWatchLimit() + " minutes.");
            System.out.println("Watch time remaining: " + WatchTime.getTimeLeftToday() + " minutes.");
        } else if (!isWatchLimitSet) {
            System.out.println("Daily time limit for watching shows has not been set.");
            System.out.println("To update the time allocated to watching shows, use the 'updatetimelimit' command.");
            System.out.println("Time spent on shows today: " + WatchTime.getDurationWatchedToday() + " minutes.");
        } else {
            System.out.println("Unable to locate user watch time details. Please try running the program again.");
        }

    }

    /**
     * Prints an acknowledgement message when the episode of the user's show has been updated.
     * @param showName the name of the show that the user has requested.
     */
    public static void printChangeEpisode(String showName) {
        printLine();
        System.out.println("Updated current episode : " + ShowList.getShow(showName).toString());

    }

    /**
     * Prints an acknowledgement message when the review of the user's requested show has been added.
     * @param showName the name of the show that the user has requested.
     */
    public static void printReviewAdded(String showName) {
        printLine();
        System.out.println("Your review for " + (showName) + " has been added.");

    }

    public static void printEditPrompt() {
        printLine();
        System.out.println("Input the detail of the show you want to change {name,season,episode,"
                + "duration} ");
        System.out.println("To finish editing, type 'done'.");
    }

    /**
     * Prints an acknowledgement message when the details of the user's requested show has been edited.
     * @param showName the name of the show that the user has requested.
     */
    public static void printEditShow(String showName) {
        printLine();
        System.out.println("Updated show details for " + showName + ".");

    }

    /**
     * Prints an acknowledgement message when the season of the user's requested show has been updated.
     * @param showName the name of the show that the user has requested.
     */
    public static void printChangeSeason(String showName) {
        printLine();
        System.out.println("Updated current season : " + ShowList.getShow(showName).toString());

    }

    /**
     * Prints an acknowledgement message when the rating of the user's requested show has been updated.
     * @param showName the name of the show that the user has requested.
     */
    public static void printChangeRating(String showName, String rating) {
        printLine();
        System.out.println("The rating for " + (showName) + " has been updated to " + (rating));
    }

    /**
     * Prints an acknowledgement message when the review of the user's requested show has been updated.
     * @param showName the name of the show that the user has requested.
     */
    public static void printChangeReview(String showName) {
        printLine();
        System.out.println("The review for " + (showName) + " has been changed.");
    }

    /**
     * Prints an acknowledgement message when the rating of the user's requested show has been removed successfully.
     * @param showName the name of the show that the user has requested.
     */
    public static void printDeleteRating(String showName) {
        printLine();
        System.out.println("The rating for " + (showName) + " has been deleted.");
    }

    /**
     * Prints an acknowledgement message when the review of the user's requested show has been deleted successfully.
     * @param showName the name of the show that the user has requested.
     */
    public static void printDeleteReview(String showName) {
        printLine();
        System.out.println("The review for " + (showName) + " has been deleted.");
    }

    /**
     * Prints an acknowledgement message when the user's requested show has been deleted from the watch list.
     * @param showName the name of the show that the user has requested.
     */
    public static void printDeleteShow(String showName) {
        printLine();
        System.out.println((showName) + " has been deleted.");
    }

    /**
     * Prints an acknowledgement message when the user's requested show has been added into the watch list.
     * @param showName the name of the show that the user has requested.
     */
    public static void printShowAdded(String showName) {
        printLine();
        System.out.println((showName) + " was added to your watchlist.");
    }

    /**
     * Prints an acknowledgement message when the user's watch list is saved successfully.
     */
    public static void printSavedList() {
        printLine();
        System.out.println("Your watchlist has been saved.");
    }

    /**
     * Prints a prompt to the user if he/she has finished all seasons of a show after using the "watch" command.
     * @param showName the name of the show that the user has requested.
     */
    public static void printFinishedAllSeasons(String showName) {
        printLine();
        System.out.println("You have finished all seasons of " + (showName) + " !");
        System.out.println("If there is a new season, please add it using the 'edit' command and input the 'watch' "
                + "command again.");
    }

    /**
     * Prints a prompt to the user if he/she has finished the current seasons of a show after using the "watch" command.
     * @param showName the name of the show that the user has requested.
     */
    public static void printWatchingNewSeason(String showName, int newSeason) {
        printLine();
        System.out.println("You are now at season " +  newSeason + " of " + (showName) + " !");
    }

    public static void printIoException() {
        System.out.println(ExceptionResponse.EXCEPTION_IO_EXCEPTION);
    }

    public static void printSpecifyShowName() {
        System.out.println("Please specify show name");
    }

    public static void printShowNotInList() {
        System.out.println("The show that you have specified is not in the list.");
    }

    /**
     * Prints a prompt to the user if he/she has exceeded the watch time limit after using the "watch" command.
     */
    public static void printExceededWatchTimeLimit() {
        System.out.println("You have exceeded your allocated watch time today!");
        System.out.println("Your watch time deficit will be highlighted below :(");
    }

    /**
     * Prints a prompt to the user if he/she has used up the watch time limit.
     */
    public static void printUsedUpWatchTimeLimit() {
        System.out.println("You have used up your allocated watch time today!");
    }

    /**
     * Prints a prompt when the user has updated the daily watch time limit through the "updatetimelimit" command.
     * @param newTime the updated daily time limit that the user has requested.
     */
    public static void printUpdatedTimeLimit(Integer newTime) {
        printLine();
        System.out.println("Your watch time limit has been updated to " + newTime + " minutes."
            + "\n" + WatchTime.userReportString());
    }

    /**
     * Prints search results of shows that contain the keyword requested by the user.
     * @param name the name of the keyword that the user has requested for a search.
     * @param searchResults the watch progress for each show that contains the keyword.
     */
    public static void printSearchSuccessful(String name, String searchResults) {
        printLine();
        System.out.println("Your shows containing the keyword: " + name + " is found, "
                + "here is the detailed information: ");
        System.out.println("\t" + searchResults);
    }

    public static void promptOverwrite() {
        System.out.println("This action will overwrite your existing data. Continue? (y/n)");
    }

    public static void printTerminated() {
        System.out.println("The process is terminated. Your existing data is kept");
    }

    public static void printInvalidEpisodesInputException() {
        System.out.println(ExceptionResponse.EXCEPTION_INVALID_EPISODES_INPUT_EXCEPTION);
    }

    public static void printNoDescriptionException() {
        System.out.println(ExceptionResponse.EXCEPTION_NO_DESCRIPTION);
    }

    public static void printNoTimeException() {
        System.out.println(ExceptionResponse.EXCEPTION_NO_TIME_DATA);
    }

    public static void printAddNameFormatException() {
        System.out.println(ExceptionResponse.EXCEPTION_INVALID_ADDING_NAME_FORMAT_EXCEPTION);
    }

    public static void printNoInputException() {
        System.out.println(ExceptionResponse.EXCEPTION_UNIDENTIFIED_INPUT);
    }

    public static void printNoReview() {
        System.out.println(ExceptionResponse.EXCEPTION_EMPTY_REVIEW);
    }

    public static void printInvalidDateException() {
        System.out.println(ExceptionResponse.EXCEPTION_INVALID_SEARCH_DATE);
    }

    public static void printInvalidTimeInput() {
        System.out.println(ExceptionResponse.EXCEPTION_INVALID_TIME_INPUT);
    }

    public static void printInvalidFormatException() {
        System.out.println(ExceptionResponse.EXCEPTION_INVALID_FORMAT);
    }

    public static void printNotFoundException() {
        System.out.println(ExceptionResponse.EXCEPTION_NOT_FOUND_EXCEPTION);
    }

    public static void printBadInputException() {
        System.out.println(ExceptionResponse.EXCEPTION_INVALID_INPUT);
    }

    public static void showCreateFileError() {
        System.out.println(ExceptionResponse.EXCEPTION_CREATE_FILE_ERROR);
    }

    public static void printInvalidRatingInput() {
        System.out.println(ExceptionResponse.EXCEPTION_INVALID_RATING_INPUT);
    }

    public static void printDailyWatchTimeLeft() {
        printLine();
        System.out.println(WatchTime.userReportString());
    }

    public static void printInputLargerThanExpected() {
        System.out.println(ExceptionResponse.EXCEPTION_INPUT_LARGER_THAN_EXPECTED);
    }

    public static void printExtraWhiteSpace() {
        System.out.println(ExceptionResponse.EXCEPTION_EXTRA_WHITE_SPACE);
    }



}

