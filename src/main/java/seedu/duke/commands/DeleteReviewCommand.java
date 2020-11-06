package seedu.duke.commands;

import seedu.duke.classes.Show;
import seedu.duke.utility.ShowList;
import seedu.duke.utility.Ui;

public class DeleteReviewCommand extends Command {
    String showName;

    public DeleteReviewCommand(String showName) {
        this.showName = showName;
    }

    public void deleteReview(String showName) throws NullPointerException,IndexOutOfBoundsException {
        if (ShowList.getShowList().containsKey(showName)) {
            Show show = ShowList.getShow(showName);
            if (show.getReview().equals("null")) {
                throw new IndexOutOfBoundsException();
            } else {
                show.setReview("null");
                ShowList.setShow(showName,show);
            }
        }
    }
}
