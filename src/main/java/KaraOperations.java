/**
 * All operations of Kara the ladybug.
 *
 * @author Ullrich Hafner
 */
public interface KaraOperations {
    /**
     * Move one step forward.
     *
     * @throws AssertionFailedException if the next cell contains a tree, mushroom, or Kara
     */
    void move();

    /**
     * Turn left through 90 degrees.
     */
    void turnLeft();

    /**
     * Turn right through 90 degrees.
     */
    void turnRight();

    /**
     * Put a leaf on the current cell.
     *
     * @throws AssertionFailedException if the current cell does not contain a leaf
     */
    void putLeaf();

    /**
     * Removes a leaf from the current cell.
     *
     * @throws AssertionFailedException if the current cell does already contain a leaf
     */
    void removeLeaf();

    /**
     * Returns whether a tree is in front of Kara.
     *
     * @return {@code true} if there is a tree is in front of Kara, {@code false} otherwise
     */
    boolean isTreeFront();

    /**
     * Returns whether a tree is left of Kara.
     *
     * @return {@code true} if there is a tree is left of Kara, {@code false} otherwise
     */
    boolean isTreeLeft();

    /**
     * Returns whether a tree is right of Kara.
     *
     * @return {@code true} if there is a tree is right of Kara, {@code false} otherwise
     */
    boolean isTreeRight();

    /**
     * Returns Kara is on a leaf.
     *
     * @return {@code true} if Kara is on a leaf, {@code false} otherwise
     */
    boolean isOnLeaf();

    /**
     * Returns whether a mushroom is in front of Kara.
     *
     * @return {@code true} if there is a mushroom is in front of Kara, {@code false} otherwise
     */
    boolean isMushroomFront();

    /**
     * Not supported yet. Greenfoot programs could be stopped using this method.
     */
    void stop();

    /**
     * Shows the specified message in a popup window.
     *
     * @param format    a <a href="../util/Formatter.html#syntax">format string</a>
     * @param arguments arguments referenced by the format specifiers in the format string
     */
    void showMessage(String format, Object... arguments);

    /**
     * Shows the specified message in a popup window and reads a long value.
     *
     * @param format    a <a href="../util/Formatter.html#syntax">format string</a>
     * @param arguments arguments referenced by the format specifiers in the format string
     */
    long readLong(String format, Object... arguments);

    /**
     * Shows the specified message in a popup window and reads an int value.
     *
     * @param format    a <a href="../util/Formatter.html#syntax">format string</a>
     * @param arguments arguments referenced by the format specifiers in the format string
     */
    int readInt(String format, Object... arguments);
}
