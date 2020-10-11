package seedu.duke.classes;


import java.time.LocalDateTime;

public class Show {
    protected String name;
    protected int numSeasons;
    protected int[] numEpisodesForSeasons;
    protected int rating;
    protected String review;
    protected LocalDateTime showTime;   //The time of the show, maybe include date
    protected int currentSeason;    //to keep track of watch progress
    protected int currentEpisode;

    public Show() {

    }

    public Show(String name, int numSeasons, int[] numEpisodesForSeasons) {
        this.name = name;
        this.numSeasons = numSeasons;
        this.numEpisodesForSeasons = numEpisodesForSeasons;
        this.rating = -1;
        this.review = "null";
        this.currentEpisode = 1;
        this.currentSeason = 1;
    }


    public String getName() {
        return name;
    }

    public int getNumSeasons() {
        return numSeasons;
    }

    public int[] getNumEpisodesForSeasons() {
        return numEpisodesForSeasons;
    }

    public int getRating() {
        return rating;
    }

    public int getEpisodesForSeason(int season) {
        //TODO : Add the exception for bounds checking
        return numEpisodesForSeasons[season - 1];
    }

    public int getCurrentSeason() {
        return currentSeason;
    }

    public int getCurrentEpisode() {
        return currentEpisode;

    }

    public String getReview() {
        return review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setNumSeasons(int numSeasons) {
        this.numSeasons = numSeasons;
    }

    public void setNumEpisodesForSeasons(int[] numEpisodesForSeasons) {
        this.numEpisodesForSeasons = numEpisodesForSeasons;
    }

    public void setEpisodeWatched(int watchedEpisode) {
        this.currentEpisode = watchedEpisode;
    }

    public void setCurrentSeason(int season) {
        this.currentSeason = season;
        this.currentEpisode = 1;
    }

    /**
     * Overload/overwrite? the previous setCurrentSeason method signature.
     * Should check with user if they want to input an episode else default it to 1
     * as in the previous declaration of setCurrentSeason
     *
     * @param season season num
     * @param episode episode num
     */
    public void setCurrentSeason(int season, int episode) {
        this.currentEpisode = episode;
        this.currentSeason = season;
    }
}
