package seedu.duke.commands;

import seedu.duke.classes.Show;
import seedu.duke.utility.ShowList;

public class UpdateShowSeasonCommand extends Command {

    java.util.ArrayList<String> inputs;
    boolean hasEpisodeData;

    public UpdateShowSeasonCommand(String description, java.util.ArrayList<String> inputs) {
        super(description);
        this.inputs = inputs;
        hasEpisodeData = inputs.size() >= 3;
    }

    //INPUT : season "show" "season" "episode (optional)z"
    public void processCommand() {
        if (hasEpisodeData) {
            updateSeasonAndEpisode();
        } else {
            updateSeasonOnly();
        }
    }

    public void updateSeasonAndEpisode() {
        String showName = inputs.get(0);
        int season = Integer.parseInt(inputs.get(1));
        int episode = Integer.parseInt(inputs.get(2));
        Show show = ShowList.getShow(showName);
        show.setCurrentSeason(season, episode);
        ShowList.setShow(showName, show);
    }

    public void updateSeasonOnly() {
        String showName = inputs.get(0);
        int season = Integer.parseInt(inputs.get(1));
        Show show = ShowList.getShow(showName);
        show.setCurrentSeason(season);
        ShowList.setShow(showName, show);
    }
}
