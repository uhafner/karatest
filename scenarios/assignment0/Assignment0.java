/**
 * Example for an assignment with Greenfoot Kara.
 *
 * @author Ullrich Hafner
 */
public class Assignment0 extends Kara {
    /**
     * Draws a diamond into a square world of size 2n + 1 x 2n +1.
     */
    public void act() {
        int width = computeWidth();
        int half = width / 2;

        for (int line = 0; line < width; line++) {
            int limit = computeLimit(width, line);

            for (int column = 0; column < width; column++) {
                if (column >= half - limit + 1
                        && column < half + limit) {
                    putLeaf();
                }
                move();
            }

            moveDown();
        }
    }

    private int computeLimit(final int width, final int line) {
        if (line > width / 2) {
            return width - line;
        }
        else {
            return line + 1;
        }
    }

    private int computeWidth() {
        int width = 0;

        putLeaf();
        do {
            move();
            width++;
        } while (!onLeaf());
        removeLeaf();

        return width;
    }

    private void moveDown() {
        turnRight();
        move();
        turnLeft();
    }
}
