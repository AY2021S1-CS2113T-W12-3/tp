package seedu.duke.commands;

import seedu.duke.classes.Show;
import seedu.duke.utility.ShowList;

public class DeleteRatingCommand {
    String showName;

    public DeleteRatingCommand(String showName) {
        this.showName = showName;
    }

    public void delete(String showToDelete) {
        ShowList.getShowList().remove(showToDelete);
    }

}
