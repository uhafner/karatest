package javakara;

/**
 * Tools to read input data and write results.
 *
 * @author Ulli Hafner
 */
public interface Tools {
    /**
     * Reads an integer value.
     *
     * @param title
     *            the title of the message to display
     * @return the parsed integer value or {@link Integer#MIN_VALUE} if the value could not be read s
     */
    int intInput(String title);

    /**
     * Writes the specified message.
     *
     * @param message
     *            the message to write
     */
    void showMessage(String message);

}
