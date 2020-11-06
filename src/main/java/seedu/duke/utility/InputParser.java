package seedu.duke.utility;

import seedu.duke.commands.AddCommand;
import seedu.duke.commands.AddReviewCommand;
import seedu.duke.commands.ChangeRatingCommand;
import seedu.duke.commands.ChangeReviewCommand;
import seedu.duke.commands.DeleteCommand;
import seedu.duke.commands.DeleteRatingCommand;
import seedu.duke.commands.DeleteReviewCommand;
import seedu.duke.commands.EditCommand;
import seedu.duke.commands.SearchCommand;
import seedu.duke.commands.UpdateShowEpisodeProgressCommand;
import seedu.duke.commands.UpdateShowSeasonCommand;
import seedu.duke.commands.UpdateTimeLimitCommand;
import seedu.duke.commands.WatchCommand;

import java.util.ArrayList;
import java.util.Arrays;

import static seedu.duke.utility.StringOperations.removeFirstWord;
import static seedu.duke.utility.StringOperations.tokenizeStringArray;

//@@author BenardoTang

/**
 * Represents a parser to process the commands inputted by the user.
 */
public class InputParser {
    private boolean isBye;

    public InputParser() {
        this.isBye = false;
    }

    public boolean isByeTime() {
        return isBye;
    }

    /**
     * Parses the input given by user and calls specific Commands
     * while checking the validity of the input.
     *
     * @param input Command entered by user.
     * @return Command based on the user input.
     */
    public String parseInput(String input) {

        String[] singleWordInputs = new String[]{"bye", "list", "help", "watchtime", "example"};
        String command = StringOperations.getFirstWord(input).toLowerCase();

        String[] splitInput = input.toLowerCase().split(" ");
        boolean commandFormatIsSingleInput = Arrays.asList(singleWordInputs).contains(splitInput[0]);
        if (splitInput.length < 2) {
            if (!commandFormatIsSingleInput) {
                Ui.printInvalidFormatException();
                return command;
            }
        } else {
            if (commandFormatIsSingleInput) {
                Ui.printInvalidFormatException();
                return command;
            }
        }
        switch (command) {

        case "bye":
            Ui.printByeMessage();
            this.isBye = true;
            return command;

        case "help":
            Ui.printHelp();
            return command;

        case "example":
            Ui.printExample();
            return command;

        case "episode":
            parseEpisodeUpdateCommand(input, command);
            return command;

        case "season":
            parseSeasonUpdateCommand(input, command);
            return command;

        case "deleterating":
            parseDeleteRatingCommand(input);
            return command;

        case "list":
            Ui.printShowList();
            return command;

        case "changerating":
            parseChangeRatingCommand(input);
            return command;

        case "add":
            parseAddCommand(input);
            return command;

        case "delete":
            parseDeleteCommand(input);
            return command;

        case "edit":
            parseEditCommand(input);
            return command;

        case "watch":
            parseWatchCommand(input, command);
            return command;

        case "updatetimelimit":
            parseUpdateTimeLimitCommand(input, command);
            return command;

        case "watchtime":
            parseWatchTimeCommand();
            return command;

        case "addreview":
            parseAddReviewCommand(input);
            return command;

        case "changereview":
            parseChangeReviewCommand(input);
            return command;

        case "deletereview":
            parseDeleteReviewCommand(input);
            return command;

        case "search":
            parseSearchCommand(command,input);
            return command;

        case "":
            Ui.printNoInputException();
            return command;


        default:
            Ui.printBadInputException();
            return command;
        }
    }

    /**
     * Parses command for editing the details of a show in the watch list.
     *
     * @param input full input of user in string format.
     * @throws IndexOutOfBoundsException if input is invalid or show is not specified by the user.
     * @throws NullPointerException      if the number of episodes input by the user is invalid.
     */
    private static void parseEditCommand(String input) {
        ArrayList<String> tokenizedString = tokenizeStringArray(input);
        try {
            if (tokenizedString.size() > 2) {
                throw new IllegalArgumentException();
            }
            new EditCommand(tokenizedString.get(1));
            EditCommand.processCommand();
        } catch (IndexOutOfBoundsException e) {
            Ui.printSpecifyShowName();
            return;
        } catch (NullPointerException e) {
            Ui.printInvalidEpisodesInputException();
            return;
        } catch (IllegalArgumentException e) {
            Ui.printBadInputException();
        }
    }

    /**
     * Parses command for updating the user's watch time limit.
     *
     * @param input full input of user in string format.
     * @param command command input by user in string format.
     * @throws IndexOutOfBoundsException if input is invalid or unable to be processed.
     * @throws NullPointerException      if the command format input by the user is invalid.
     * @throws NumberFormatException     if the time limit input by the user is not a number.
     */
    private static void parseUpdateTimeLimitCommand(String input, String command) {
        ArrayList<String> tokenizedString = tokenizeStringArray(input);
        try {
            UpdateTimeLimitCommand newTimeLimitCommand = new UpdateTimeLimitCommand(command, tokenizedString);
            newTimeLimitCommand.processCommand();
        } catch (IndexOutOfBoundsException e) {
            Ui.printBadInputException();
        } catch (NullPointerException e) {
            Ui.printInvalidFormatException();
        } catch (NumberFormatException e) {
            Ui.printInvalidFormatException();
        }
    }

    /**
     * Parses command when user has watched an episode of a show in the watch list.
     *
     * @param input full input of user in string format.
     * @param command command input by user in string format.
     * @throws NullPointerException      if the show specified is invalid or could not be found.
     */
    private static void parseWatchCommand(String input, String command) {
        ArrayList<String> tokenizedString = tokenizeStringArray(input);
        try {
            WatchCommand showWatched = new WatchCommand(command, tokenizedString);
            showWatched.processCommand();
        } catch (NullPointerException e) {
            Ui.printNotFoundException();
        }
    }

    private static void parseSearchCommand(String command,String input) {
        ArrayList<String> tokenizedString = tokenizeStringArray(input);
        try {
            SearchCommand searchCommand = new SearchCommand(command,tokenizedString);
            searchCommand.processCommand();
        } catch (IndexOutOfBoundsException e) {
            Ui.printSpecifyShowName();
        } catch (NullPointerException e) {
            Ui.printNotFoundException();
        }
    }

    private static void parseEpisodeUpdateCommand(String input, String command) {
        ArrayList<String> updateInputs = tokenizeStringArray(input);
        UpdateShowEpisodeProgressCommand updateShowProgress;
        try {
            updateShowProgress = new UpdateShowEpisodeProgressCommand(command, updateInputs);
            updateShowProgress.processCommand();
        } catch (NullPointerException e) {
            Ui.printBadInputException();
        } catch (NumberFormatException e) {
            Ui.printInvalidFormatException();
        }


    }

    private static void parseSeasonUpdateCommand(String input, String command) {
        ArrayList<String> seasonInputs = tokenizeStringArray(input);
        UpdateShowSeasonCommand updateShowSeason;
        try {
            updateShowSeason = new UpdateShowSeasonCommand(command, seasonInputs);
        } catch (NullPointerException e) {
            Ui.printBadInputException();
            return;
        } catch (NumberFormatException e) {
            Ui.printInvalidFormatException();
            return;
        }
        updateShowSeason.processCommand();
    }

    /**
     * Parses command for deleting a rating in an existing show in the watch list.
     *
     * @param input Command inputted by user in string format.
     * @throws IndexOutOfBoundsException if input is empty or invalid.
     * @throws NullPointerException      if the existing rating is invalid or show could not be found.
     */
    private static void parseDeleteRatingCommand(String input) {
        input = removeFirstWord(input);
        DeleteRatingCommand deleteShowRating = new DeleteRatingCommand(input);
        try {
            deleteShowRating.deleteRating(input);
            Ui.printDeleteRating(input);
        } catch (NullPointerException e) {
            Ui.printBadInputException();
        } catch (IndexOutOfBoundsException e) {
            Ui.printNotFoundException();
        }
    }

    /**
     * Parses command for changing a rating in an existing show in the watch list.
     *
     * @param input Command inputted by user in string format.
     * @throws IndexOutOfBoundsException if input is empty or the rating is invalid.
     * @throws NullPointerException      if the input is invalid or show could not be found.
     * @throws NumberFormatException     if the input given does not have a rating.
     */
    private static void parseChangeRatingCommand(String input) {
        input = removeFirstWord(input);
        try {
            String[] tokenizedInput = input.split(" ");
            int showRating = Integer.parseInt(tokenizedInput[1]);
            ChangeRatingCommand changeShowRating = new ChangeRatingCommand(tokenizedInput[0]);
            changeShowRating.changeRating(tokenizedInput[0], showRating);
            Ui.printChangeRating(tokenizedInput[0], tokenizedInput[1]);
        } catch (NullPointerException e) {
            Ui.printBadInputException();
            return;
        } catch (IndexOutOfBoundsException e) {
            Ui.printInvalidRatingInput();
        } catch (NumberFormatException e) {
            Ui.printInvalidRatingInput();
        }
    }

    /**
     * Parses command for adding a show into the watch list.
     *
     * @param input Command inputted by user in string format.
     *      catches IndexOutOfBoundsException  if input is empty or the format is invalid.
     *      catches  NullPointerException      if the format of episodes added is invalid.
     *      catches  NumberFormatException     if the format of show name added is invalid.
     */
    private static void parseAddCommand(String input) {
        String[] tokenizedInput = input.split(" ");
        try {
            new AddCommand(tokenizedInput);
            AddCommand.processCommand();
        } catch (NullPointerException e) {
            Ui.printInvalidEpisodesInputException();
            return;
        } catch (IndexOutOfBoundsException e) {
            Ui.printInvalidFormatException();
            return;
        } catch (NumberFormatException e) {
            Ui.printInvalidFormatException();
            return;
        } catch (RuntimeException e) {
            Ui.printBadInputException();
        }
    }

    /**
     * Parses command for deleting a show in the watch list.
     *
     * @param input Command inputted by user in string format.
     * @throws IndexOutOfBoundsException if input is empty or the command format is invalid.
     * @throws NullPointerException      if the show could not be found.
     */
    private static void parseDeleteCommand(String input) {
        input = removeFirstWord(input);
        DeleteCommand deletingShow = new DeleteCommand(input);
        try {
            deletingShow.delete(input);
            Ui.printDeleteShow(input);
        } catch (NullPointerException e) {
            Ui.printNotFoundException();
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printInvalidFormatException();
        }
    }

    /**
     * Parses command to outline the user's current watch time details.
     * These include the recorded date,duration watched today, and time limit set by the user
     */
    private static void parseWatchTimeCommand() {
        Ui.printDailyWatchTracking();
    }

    /**
     * Adds a review.
     * @param input user input
     */
    private  static void parseAddReviewCommand(String input) {
        if (!input.contains("/")) {
            Ui.printInvalidFormatException();
            return;
        }
        try {
            new AddReviewCommand(input);
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printInvalidFormatException();
        } catch (NullPointerException e) {
            Ui.printNotFoundException();
        } catch (IndexOutOfBoundsException e) {
            Ui.printInvalidRatingInput();
        } catch (NumberFormatException e) {
            Ui.printInvalidFormatException();
        }
    }

    private static void parseChangeReviewCommand(String input) {
        input = removeFirstWord(input);
        if (!input.contains("/")) {
            Ui.printInvalidFormatException();
            return;
        }
        try {
            String[] tokenizedInput = input.split(" ");
            String showName = tokenizedInput[0];
            int indexOfSlash = input.indexOf("/");
            String review = input.substring(indexOfSlash + 1);
            ChangeReviewCommand changingReview = new ChangeReviewCommand(showName);
            changingReview.changeReview(showName,review);
            Ui.printChangeReview(showName);
        } catch (NullPointerException e) {
            Ui.printNotFoundException();
        } catch (NumberFormatException e) {
            Ui.printInvalidFormatException();
        }
    }
    
    private static void parseDeleteReviewCommand(String input) {
        input = removeFirstWord(input);
        DeleteReviewCommand deletingReview = new DeleteReviewCommand(input);
        try {
            deletingReview.deleteReview(input);
            Ui.printDeleteReview(input);
        } catch (NullPointerException e) {
            Ui.printNotFoundException();
        } catch (IndexOutOfBoundsException e) {
            Ui.printNoReview();
        }
    }
}

