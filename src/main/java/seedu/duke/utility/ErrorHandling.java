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
        EXCEPTION_INVALID_INPUT("\tI don't know what you just said.Try " + Ui.toReverse("help")
                + " for a list of commands."),
        EXCEPTION_CREATE_FILE_ERROR("\tError creating file.");

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