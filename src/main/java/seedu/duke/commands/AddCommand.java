package seedu.duke.commands;

import seedu.duke.classes.Show;
import seedu.duke.utility.ShowList;
import seedu.duke.utility.TimeParser;
import seedu.duke.utility.Ui;

import java.util.Scanner;

public class AddCommand extends Command {
    static String[] input;

    public AddCommand(String[] input) {
        this.input = input;
    }

    /**
     * Adds a new show.
     * @throws NullPointerException when the input does no match expected length
     * @throws IndexOutOfBoundsException when the user input has too few or too many arguments
     * @throws RuntimeException when input is empty string
     */
    public static void processCommand() throws NullPointerException, IndexOutOfBoundsException, RuntimeException {
        //check that the user inputs are in the right format
        if (input.length < 5 || input.length > 6) {
            throw new IndexOutOfBoundsException();
        }
        int numSeasons = Integer.parseInt(input[2]);
        String[] tokenizedSeasons = input[3].split(",");
        int[] seasonEpisodes = new int[numSeasons];
        int i = 0;
        if (tokenizedSeasons.length != numSeasons) {
            throw new NullPointerException();
        }
        for (String s : tokenizedSeasons) {
            seasonEpisodes[i] = Integer.parseInt(s);
            i++;
        }
        String name = input[1];
        if (name.contentEquals("")) {
            throw new RuntimeException();
        }
        int duration;
        if (input.length == 6) {
            duration = TimeParser.parseTime(input[4].concat(input[5]));
        } else {
            duration = TimeParser.parseTime(input[4]);
        }
        Show show = new Show(name, numSeasons, seasonEpisodes, duration);
        boolean isGoingToBeAdded = false;
        try {
            isGoingToBeAdded = checkExisting(name);
        } catch (NullPointerException e) {
            isGoingToBeAdded = true;
        }
        if (isGoingToBeAdded) {
            ShowList.setShow(name, show);
            Ui.printShowAdded(name);
        } else {
            Ui.printTerminated();
        }
    }

    /**
     * Check for conflict with existing shows.
     * @param name Show Name
     * @return true if we overwrite, false if we keep existing show
     * @throws NullPointerException when there is no existing show with the same name
     */
    private static boolean checkExisting(String name) throws NullPointerException {
        boolean exists = ShowList.doesShowExist(name);
        if (!exists) {
            return true;
        }
        Ui.promptOverwrite();
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        if (answer.equals("y") || answer.equals("yes")) {
            DeleteCommand.delete(name);
            return true;
        }
        return false;
    }
}
