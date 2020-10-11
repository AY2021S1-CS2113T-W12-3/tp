package seedu.duke.utility;


import seedu.duke.classes.Show;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public interface SaveState {
    void saveState(HashMap<String, Show> showList) throws IOException;
    
    HashMap<String, Show> loadState() throws FileNotFoundException;

}
