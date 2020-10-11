package seedu.duke.commands;

import seedu.duke.classes.Show;
import seedu.duke.utility.ShowList;

import java.util.Scanner;

public class UpdateShowEpisodeProgressCommand extends Command {
    java.util.ArrayList<String> inputs;

    public UpdateShowEpisodeProgressCommand(String description, java.util.ArrayList<String> inputs) {
        super(description);
        this.inputs = inputs;
    }

    //INPUT : episode "show" "episode"
    public void processCommand() {
        String showName = inputs.get(0);
        int episode = Integer.parseInt(inputs.get(1));
        Show show = ShowList.getShow(showName);
        show.setEpisodeWatched(episode);
        ShowList.setShow(showName, show);
    }


}
