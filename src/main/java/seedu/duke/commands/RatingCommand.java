package seedu.duke.commands;

import seedu.duke.classes.Show;
import seedu.duke.utility.ShowList;

public class RatingCommand {
    String showName;

    public RatingCommand(String showName) {
        this.showName = showName;
    }

    public void rateShow(String showToBeRated, int rating) {
        Show show = ShowList.getShow(showToBeRated);
        show.setRating(rating);
        ShowList.setShow(showName,show);
    }
}
