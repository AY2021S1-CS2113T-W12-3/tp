package seedu.duke.commands;

import seedu.duke.classes.Show;
import seedu.duke.classes.WatchTime;
import seedu.duke.utility.ShowList;
import seedu.duke.utility.Ui;

import java.util.ArrayList;

/**
 * Represents a Command to update the watch progress of the user after watching a show.
 */
public class WatchCommand extends Command {
    ArrayList<String> inputs;

    public WatchCommand(String description, ArrayList<String> inputs) throws NullPointerException {
        super(description);
        this.inputs = inputs;
        if (inputs.size() != 2) {
            throw new NullPointerException();
        }
    }

    /**
     * Notifies the application that user has finished his current episode of a show
     * in which the current episode will be incremented by 1, and watch time will be updated.
     * The watchlist updates the show to a new season if required.
     */
    public void processCommand() {

        String showName = inputs.get(1);
        Show show = ShowList.getShow(showName);

        int showEpisode = show.getCurrentEpisode();
        int currentSeason = show.getCurrentSeason();
        int showSeason = show.getNumSeasons();
        int episodesInSeason = show.getEpisodesForSeason(currentSeason);
        boolean hasFinishedSeason = (showEpisode == episodesInSeason);
        boolean isLastSeason = (currentSeason == showSeason);
        boolean hasFinishedSeries = (isLastSeason && hasFinishedSeason);

        if (hasFinishedSeries) {
            Ui.printFinishedAllSeasons(showName);
            return;
        } else if (hasFinishedSeason) {
            int updatedSeason = currentSeason + 1;
            show.setCurrentSeason(updatedSeason);
            show.setEpisodeWatched(1);
            ShowList.setShow(showName, show);
            Ui.printWatchingNewSeason(showName, updatedSeason);
            Ui.printChangeEpisode(showName);
        } else {
            show.setEpisodeWatched(showEpisode + 1);
            ShowList.setShow(showName, show);
            Ui.printChangeEpisode(showName);
        }
        int showDuration = show.getEpisodeDuration();
        WatchTime.watchDurationUpdate(showDuration);

    }
}
