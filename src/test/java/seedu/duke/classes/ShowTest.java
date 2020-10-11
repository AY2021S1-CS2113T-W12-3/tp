package seedu.duke.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShowTest {
    int[] episodes = new int[]{21, 10, 12};
    Show show = new Show("friends", 3, episodes);

    @Test
    void getName() {
        assertEquals("friends", show.getName());
    }

    @Test
    void getNumSeasons() {
        assertEquals(3, show.getNumSeasons());
    }

    @Test
    void getNumEpisodesForSeasons() {
        assertEquals(episodes, show.getNumEpisodesForSeasons());
    }

    @Test
    void getEpisodesForSeason() {
        assertEquals(21, show.getEpisodesForSeason(1));
    }

    @Test
    void getRating() {
        show.setRating(5);
        assertEquals(5, show.getRating());
    }

    @Test
    void getReview() {
        show.setReview("Best show ever :)");
        assertEquals("Best show ever :)", show.getReview());
    }


}