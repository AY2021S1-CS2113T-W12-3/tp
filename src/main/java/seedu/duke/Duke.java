package seedu.duke;

import seedu.duke.classes.Storage;
import seedu.duke.utility.InputParser;
import seedu.duke.utility.ShowList;
import seedu.duke.utility.Ui;


import static seedu.duke.utility.Ui.SAVE_DIRECTORY;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    private Storage storage;
    private ShowList shows;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            this.shows = new ShowList(storage.loadState());
        } catch (Exception e) {
            this.shows =  new ShowList();
        }
    }

    public void run() {

        ui.hello();
        InputParser parseManager = new InputParser();
        while (!parseManager.isByeTime()) {
            Ui.printLineIcon();
            try {
                storage.saveState(ShowList.getShowList());
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            String input = ui.getUserCommand();
            parseManager.parseInput(input);
        }
    }

    public static void main(String[] args) {
        new Duke(SAVE_DIRECTORY).run();
    }
}

