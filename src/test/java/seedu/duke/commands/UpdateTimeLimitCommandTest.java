package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.classes.WatchTime;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdateTimeLimitCommandTest {

    public static UpdateTimeLimitCommand updateObject;


    @org.junit.jupiter.api.BeforeAll
    public static void main() {
        WatchTime limitation = new WatchTime(java.time.LocalDate.of(2020,10,19),60,120);
        assertEquals(WatchTime.getDailyWatchLimit(), 120);
        ArrayList<String> inputExample = new ArrayList<>(Arrays.asList("updatetimelimit", "420"));
        updateObject = new UpdateTimeLimitCommand("updatetimelimit", inputExample);
    }


    @Test
    void processCommand() {
        updateObject.processCommand();
        assertEquals(WatchTime.getDailyWatchLimit(), 420);
    }
}