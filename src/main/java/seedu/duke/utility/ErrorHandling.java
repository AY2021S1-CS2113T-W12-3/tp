package seedu.duke.utility;

/**
 * Handles the various exceptions which may be encountered during the program's lifetime.
 * Some are slightly unnecessary but were included for the 'personality' of the Duke Bot
 */
public class ErrorHandling extends Exception {

    public enum ExceptionResponse {
        EXCEPTION_NO_DESCRIPTION("\tNo description"),
        EXCEPTION_NO_TIME_DATA("\tNo time"),
        EXCEPTION_UNIDENTIFIED_INPUT("\tPlease input something"),
        EXCEPTION_IO_EXCEPTION("\tIO Error"),
        EXCEPTION_INVALID_SEARCH_DATE("\tWhen is that???!!! Please put in a proper date in the format : 'yyyy-mm-dd'"),
        EXCEPTION_NOT_FOUND_EXCEPTION("\tHey buddy, it seems like we don't have what you're looking for!"),
        EXCEPTION_INVALID_INPUT(
                "\tI don't know what you just said. Please input a valid number/name. Try " + "'example'"
                + " for help with the command format."),
        EXCEPTION_INVALID_FORMAT("\tIt seems like the format of the command is wrong, Try " + "'help'"
                + " for an explanation of the commands,\n\tor 'example' for assistance with command format."),
        EXCEPTION_CREATE_FILE_ERROR("\tError creating file."),
        EXCEPTION_INVALID_EPISODES_INPUT_EXCEPTION("\tThe number of episodes input doesn't match "
                + "the number of seasons. The show was not added"),
        EXCEPTION_INVALID_ADDING_NAME_FORMAT_EXCEPTION("\tIf the name of your show contains more "
                + "than one word you will need to input the name with no spaces.\n\tExample: For show name "
                + "'Running Man' try `RunningMan` or `Running_Man`."),
        EXCEPTION_INVALID_RATING_INPUT("\tSorry! This is an invalid rating! Try again!"),
        EXCEPTION_INPUT_LARGER_THAN_EXPECTED("\tSorry! It seems like you have entered the wrong number! Try again!"),
        EXCEPTION_INVALID_TIME_INPUT("\tSorry! It seems like you have entered the wrong time format."),
        EXCEPTION_EXTRA_WHITE_SPACE("\tA extra white space is tapped in, please check your input command."),
        EXCEPTION_EMPTY_REVIEW("\tThere is no review for this show!");



        private String exception;

        ExceptionResponse(String exceptionMessage) {
            this.exception = exceptionMessage;
        }

        @Override
        public String toString() {
            return exception;
        }
    }

    public ErrorHandling(ExceptionResponse exception) {
        super(exception.toString());
    }
}
