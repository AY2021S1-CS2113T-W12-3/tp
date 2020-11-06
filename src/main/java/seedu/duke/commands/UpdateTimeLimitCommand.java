package seedu.duke.commands;

import seedu.duke.classes.WatchTime;
import seedu.duke.utility.TimeParser;

import java.util.ArrayList;

import static seedu.duke.utility.Ui.printBadInputException;

/**
 * Represents a Command to update the watch time limit duration for the user.
 */
public class UpdateTimeLimitCommand extends Command {
    ArrayList<String> inputs;

    public UpdateTimeLimitCommand(String description, ArrayList<String> inputs) throws NullPointerException {
        super(description);
        this.inputs = inputs;
        if (inputs.size() != 2) {
            throw new NullPointerException();
        }
    }

    /**
     * Notifies the application that user has updated his daily watch limit to a new duration.
     * @throws IllegalArgumentException when the time input is negative and invalid
     * @throws NullPointerException when the user input has too few or too many arguments
     */
    public void processCommand() {
        try {
            int newTimeLimit = TimeParser.parseTime(inputs.get(1));
            if (newTimeLimit == -1) {
                throw new IllegalArgumentException();
            }
            WatchTime.watchLimitUpdate(newTimeLimit);
        } catch (NullPointerException e) {
            printBadInputException();
        } catch (IllegalArgumentException e) {
            return;
        }
    }


}
