package seedu.duke.classes;

import seedu.duke.utility.SaveState;
import seedu.duke.utility.ShowList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Storage implements SaveState {

    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void saveState() throws IOException {
        FileWriter fw = new FileWriter(filePath);
        int index = 1;
        for (Map.Entry<String, Show> entry : ShowList.getShowList().entrySet()) {
            fw.write(index + ". " + entry.getValue().getName() + System.lineSeparator());
            fw.write("      Season: " + entry.getValue().getNumSeasons() + System.lineSeparator());
            String episodes = "";
            for (int i = 1; i <= entry.getValue().getNumSeasons(); i++) {
                episodes = episodes + entry.getValue().getEpisodesForSeason(i) + " ";
            }
            fw.write("      Episodes: " + episodes + System.lineSeparator());
            fw.write("      Rating: " + entry.getValue().getRating() + System.lineSeparator());
            fw.write("      Current Season: " + entry.getValue().getCurrentSeason() + System.lineSeparator());
            fw.write("      Current Episode: " + entry.getValue().getCurrentEpisode() + System.lineSeparator());
            index++;

            //this is another save format
            /*
            String textToAdd=index+". "+entry.getValue().getName()+" | Season: "+entry.getValue().getNumSeasons()
                    +" | Episodes: " +entry.getValue().getEpisodesForSeason(entry.getValue().getNumSeasons())+" |
                    Rating: "+entry.getValue().getRating();
            fw.write(textToAdd);
             */
        }
        fw.close();
    }

    @Override
    public ShowList loadState() throws FileNotFoundException {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdir();
        }
        File f = new File(filePath);
        try {
            f.createNewFile();
        } catch (IOException ex) {
            seedu.duke.utility.Ui.showCreateFileError();
        }
        Scanner s = new Scanner(f);
        ShowList shows = new ShowList();
        //HashMap<String, Show> showList = new java.util.HashMap<>();
        // we just assume that users will not change the contain in the file then the format will be fixed
        while (s.hasNext()) {
            String name = s.nextLine().substring(3);

            String[] splitDuration = s.nextLine().split("Duration: ");
            int duration = Integer.parseInt(splitDuration[1]);
            String[] splitSeason = s.nextLine().split("Season: ");
            int season = Integer.parseInt(splitSeason[1]);
            String[] splitEpisodes = s.nextLine().split("Episodes: ");
            String[] episodeString = splitEpisodes[1].split(" ");
            int[] episodes = new int[season];

            for (int i = 0; i < season; i++) {
                episodes[i] = Integer.parseInt(episodeString[i]);
            }

            String[] splitRating = s.nextLine().split("Rating: ");
            int rating = Integer.parseInt(splitRating[1]);

            shows.setShow(name, new Show(name, duration, season, episodes));
            //shows(name, new Show(name, season, episodes));
            shows.getShow(name).setRating(rating);

            String[] splitCurrentSeason = s.nextLine().split("Current Season: ");
            int currentSeason = Integer.parseInt(splitCurrentSeason[1]);
            shows.getShow(name).setCurrentSeason(currentSeason);

            String[] splitCurrentEpisode = s.nextLine().split("Current Episode: ");
            int currentEpisode = Integer.parseInt(splitCurrentEpisode[1]);
            shows.getShow(name).setEpisodeWatched(currentEpisode);
            //showList.get(name).setRating(rating);


            //another load format which corresponding to the backup save format
            /*
            String contain=s.nextLine();
            String[] splitName=contain.split(" | Season: ");
            String name=splitName[0].substring(3);
            String[] splitSeason=splitName[1].split(" | Episodes: ");
            int season =Integer.parseInt(splitSeason[0]);
            String[] splitEpisodes=splitName[1].split(" | Rating: ");
            int episodes =Integer.parseInt(splitEpisodes[0]);
            int Rating = Integer.parseInt(splitEpisodes[1]);
            showList.put(name,Show())
             */

        }
        return shows;
    }
}