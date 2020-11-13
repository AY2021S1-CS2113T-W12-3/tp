package seedu.duke.commands;

import seedu.duke.classes.Show;
import seedu.duke.utility.ShowList;
import seedu.duke.utility.Ui;

import java.util.ArrayList;

public class UpdateShowEpisodeProgressCommand extends Command {
    ArrayList<String> inputs;

    public UpdateShowEpisodeProgressCommand(String description, ArrayList<String> inputs) throws NullPointerException {
        super(description);
        this.inputs = inputs;
        if (inputs.size() != 3) {
            throw new NullPointerException();
        }
    }

    //INPUT : episode "show" "episode"
    public void processCommand() {
        String showName = inputs.get(1);
        int episode = Integer.parseInt(inputs.get(2));
        try {
            Show show = ShowList.getShow(showName);
            int currentSeason = show.getCurrentSeason();
            int[] episodesForSeasons = show.getNumEpisodesForSeasons();
            if (episode > episodesForSeasons[currentSeason]) {
                throw new RuntimeException();
            }
            show.setEpisodeWatched(episode);
            ShowList.setShow(showName, show);
            Ui.printChangeEpisode(showName);
        } catch (NullPointerException e) {
            Ui.printNotFoundException();
        } catch (RuntimeException e) {
            Ui.printInputLargerThanExpected();
        }
    }


}
