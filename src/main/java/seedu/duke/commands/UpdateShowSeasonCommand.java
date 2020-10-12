package seedu.duke.commands;

import seedu.duke.classes.Show;
import seedu.duke.utility.ShowList;
import seedu.duke.utility.Ui;

public class UpdateShowSeasonCommand extends Command {

    java.util.ArrayList<String> inputs;

    public UpdateShowSeasonCommand(String description, java.util.ArrayList<String> inputs) throws NullPointerException {
        super(description);
        this.inputs = inputs;
        if (inputs.size() < 3) {
            throw new NullPointerException();   //insufficient input elements
        }
    }

    //INPUT : season "show" "season" "episode (optional)"
    public void processCommand() {
        if (inputs.size() == 3) {
            updateSeasonOnly();
        } else {
            updateSeasonAndEpisode();
        }
    }

    public void updateSeasonAndEpisode() {
        String showName = inputs.get(1);
        int season = Integer.parseInt(inputs.get(2));
        int episode = Integer.parseInt(inputs.get(3));
        Show show = ShowList.getShow(showName);
        show.setCurrentSeason(season, episode);
        ShowList.setShow(showName, show);
        Ui.printChangeSeason(showName);
    }

    public void updateSeasonOnly() {
        String showName = inputs.get(1);
        int season = Integer.parseInt(inputs.get(2));
        Show show = ShowList.getShow(showName);
        show.setCurrentSeason(season);
        ShowList.setShow(showName, show);
    }
}
