package seedu.duke.utility;

import seedu.duke.classes.Show;

import java.util.HashMap;

public class ShowList {
    public static HashMap<String, Show> showList;

    public ShowList() {
    }

    public ShowList(HashMap<String, Show> showList) {
        this.showList = showList;
    }

    public static Show getShow(String showName) {
        Show show = showList.get(showName);
        /* Do changes to show */
        return show;
    }

    public static void setShow(String showName, Show show) {
        showList.put(showName, show);
    }

    public static HashMap<String, Show> getShowList() {
        return showList;
    }


}
