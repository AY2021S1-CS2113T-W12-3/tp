package seedu.duke.utility;

import seedu.duke.commands.AddCommand;
import seedu.duke.commands.ChangeRatingCommand;
import seedu.duke.commands.DeleteRatingCommand;
import seedu.duke.commands.RatingCommand;
import seedu.duke.commands.UpdateShowEpisodeProgressCommand;
import seedu.duke.commands.UpdateShowSeasonCommand;

import java.util.ArrayList;

//TODO include more parser classes (storage.parser, command.parser etc in the future)


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

    private static ArrayList<String> tokenizeStringArray(String input) {
        ArrayList<String> inputArray = new java.util.ArrayList<>();
        for (String token : input.split(" ")) {
            inputArray.add(token);
        }
        int size = 0;
        try {
            size = inputArray.size();
        } catch (NullPointerException e) {
            Ui.printBadInputException();
        }
        if (size > 0) {
            return inputArray;
        } else {
            return null;
        }
    }

    private static String getFirstWord(String input) {
        int index = input.indexOf(' ');
        if (index == -1) { // Input only contains a single word
            return input;
        } else {
            return input.substring(0, index).trim(); // Extracts first word.
        }
    }

    private static String removeFirstWord(String input) {
        int index = input.indexOf(' ');
        if (index == -1) { // Input only contains a single word
            return "";
        } else {
            return input.substring(index + 1).trim(); // Extracts after space.
        }
    }

    public void parseInput(String input) {

        String command = getFirstWord(input);
        switch (command.toLowerCase()) {
        case "bye":
            Ui.printByeMessage();
            this.isBye = true;
            return;

        case "help":
            Ui.printHelp();
            return;

        case "episode":
            parseEpisodeUpdateCommand(input, command);

            return;
        case "season":
            parseSeasonUpdateCommand(input, command);
            return;

        case "rating":
            parseAddRatingCommand(input);
            return;

        case "deleterating":
            parseDeleteRatingCommand(input);
            return;

        case "list":
            Ui.printShowList();
            //parseListCommand(ShowList.getShowList());
            return;

        case "changerating":
            parseChangeRatingCommand(input);
            return;

        case "add":
            parseAddCommand(input);
            return;
        /*
        case "edit":

            return parseEditCommand();

        case "delete":

            return parseDeleteCommand();*/

        case "":
            Ui.printNoInputException();
            return;

        default:
            Ui.printBadInputException();
        }
    }


    //todo: differentiate between show and movie soon
    //todo fix error handling for parsing - follow episode and season

    private static void parseEpisodeUpdateCommand(String input, String command) {
        ArrayList<String> updateInputs = tokenizeStringArray(input);
        UpdateShowEpisodeProgressCommand updateShowProgress;
        try {
            updateShowProgress = new UpdateShowEpisodeProgressCommand(command, updateInputs);
        } catch (NullPointerException e) {
            Ui.printBadInputException();
            return;
        }
        updateShowProgress.processCommand();

    }

    private static void parseSeasonUpdateCommand(String input, String command) {
        ArrayList<String> seasonInputs = tokenizeStringArray(input);
        UpdateShowSeasonCommand updateShowSeason;
        try {
            updateShowSeason = new UpdateShowSeasonCommand(command, seasonInputs);
        } catch (NullPointerException e) {
            Ui.printBadInputException();
            return;
        }
        updateShowSeason.processCommand();
    }

    private static void parseAddRatingCommand(String input) {
        input = removeFirstWord(input);
        String[] tokenizedInput = input.split(" ");
        int showRating = Integer.parseInt(tokenizedInput[1]);
        RatingCommand newShowRating = new RatingCommand(tokenizedInput[0]);
        newShowRating.rateShow(tokenizedInput[0], showRating);
        Ui.printShowRating(tokenizedInput[0], tokenizedInput[1]);
    }
//todo fix deleterating, currently deletes the show rather than its rating
    private static void parseDeleteRatingCommand(String input) {
        input = removeFirstWord(input);
        DeleteRatingCommand deleteShowRating = new DeleteRatingCommand(input);
        deleteShowRating.delete(input);
        Ui.printDeleteRating(input);
    }

    private static void parseChangeRatingCommand(String input) {
        // catch exceptions for 1)not enough inputs, 2)invalid args, 3)invalid rating
        // split input using tokenizer
        String[] tokenizedInput = input.split(" ");
        int showRating = Integer.parseInt(tokenizedInput[1]);
        ChangeRatingCommand changeShowRating = new ChangeRatingCommand(tokenizedInput[0]);
        changeShowRating.changeRating(showRating);
        Ui.printChangeRating(tokenizedInput[0], tokenizedInput[1]);
    }

    private static void parseAddCommand(String input) {
        //catch for 1)too many/not enough inputs , 2)invalid input, 3)show alr added
        //maybe last arg is optional? idk cos user might not wanna put rating yet
        String[] tokenizedInput = input.split(" ");
        new AddCommand(tokenizedInput);
        //add show detail into appropriate class
        Ui.printShowAdded(tokenizedInput[1]);
    }
    /*
    private static seedu.duke.commands.Command parseEditCommand(String input) {
        //this one might need check agn, the current i/o is a yikes imo
        seedu.duke.utility.Ui.queryEditShow(input);
        java.util.Scanner scan = null;
        boolean isEditFinished = false;
        while (!isEditFinished)){
            System.out.println("Name: (Press enter to skip)");
            //edit name
            System.out.println("Episodes: (Press enter to skip or done to exit)");
            //edit episode
            System.out.println("Seasons: (Press enter to skip or done to exit)");
            //edit seasons
        }

    }

    private static void parseListCommand(HashMap<String, Show> showList) {
        // idk how to do this btw
        int index = 1;
        String rating = null;
        for (Entry<String, Show> entry : showList.entrySet()) {
            if(entry.getValue().getRating()!=-1){
                rating = String.valueOf(entry.getValue().getRating());
            }
            else{
                rating = "Not added.";
            }
            System.out.println(index + ". " + entry.getValue().getName() + " | " + "Season " + entry.getValue().getNumSeasons()
                    + " | " + "Episode " + entry.getValue().getEpisodesForSeason(index) + " | " + "Rating: " + rating);
            index++;
        }
    }


    private static void parseDeleteCommand(String input) {
        //catch for 1)show not found , 2) invalid no. of args
        Ui.printDeleteShow(input);
    }*/

}

