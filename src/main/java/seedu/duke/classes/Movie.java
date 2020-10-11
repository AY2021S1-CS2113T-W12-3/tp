package seedu.duke.classes;

import java.time.LocalDateTime;

public class Movie extends Show {
    String name;
    String genre;


    public Movie(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}
