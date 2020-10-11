package seedu.duke.commands;

import seedu.duke.classes.Show;
import seedu.duke.utility.ShowList;

public class ChangeRatingCommand {
    String showName;

    public ChangeRatingCommand(String showName) {
        this.showName = showName;
    }

    public void changeRating(int targetRating) {
        Show show = ShowList.getShow(showName);
        show.setRating(targetRating);
        ShowList.setShow(showName, show);
        /**
         * Process :
         * get the Show object that you want to change
         * edit the object (referenced by copy not by pointer)
         * put the edited version back into the showlist
         */
    }
}
