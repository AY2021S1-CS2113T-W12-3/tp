package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandTest {

    Command command = new Command("test command");

    @Test
    void getDescription() {
        assertEquals("test command", command.getDescription());
    }

    @Test
    void setDescription() {
        command.setDescription("set description");
        assertEquals("set description", command.getDescription());
    }

}
