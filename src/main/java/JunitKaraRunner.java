import edu.hm.hafner.util.Ensure;

import java.util.Arrays;

/**
 * JUnit driver to run Kara through a given world.
 *
 * @author Ullrich Hafner
 */
public class JunitKaraRunner extends KaraRunner {
    private static final String NEWLINE = "\n";

    private Element[][] world = new Element[0][0];

    private Orientation karaOrientation;
    private int karaColumn;
    private int karaRow;

    private int height;
    private int width;

    /**
     * Creates a new instance of {@link JunitKaraRunner}.
     *
     * @param row
     *            Kara's row
     * @param column
     *            Kara's column
     * @param orientation
     *            Kara's orientation
     */
    private JunitKaraRunner(final int row, final int column, final Orientation orientation) {
        super();

        Ensure.that(orientation).isNotNull();

        karaRow = row;
        karaColumn = column;
        karaOrientation = orientation;
    }

    /**
     * Creates a new instance of {@link JunitKaraRunner}.
     *
     * @param row
     *            Kara's row
     * @param column
     *            Kara's column
     * @param orientation
     *            Kara's orientation
     * @param height
     *            Number of empty height
     * @param width
     *            Number of empty width
     */
    public JunitKaraRunner(final int row, final int column, final Orientation orientation, final int height,
            final int width) {
        this(row, column, orientation);

        createWorld(height, width);
        verifyKarasInitialPosition();
    }

    private boolean canEnter() {
        return kara() == Element.L || kara() == Element.O;
    }

    /**
     * Creates a new instance of {@link JunitKaraRunner}.
     *
     * @param row
     *            Kara's row
     * @param column
     *            Kara's column
     * @param orientation
     *            Kara's orientation
     * @param content
     *            the content of this world
     */
    public JunitKaraRunner(final int row, final int column, final Orientation orientation, final String[] content) {
        this(row, column, orientation);
        Ensure.that(content).isNotEmpty("The content of the world must be not empty");

        createWorld(content);
        verifyKarasInitialPosition();
    }

    /**
     * Returns the width of the world.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the world.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    private void verifyKarasInitialPosition() {
        Ensure.that(canEnter()).isTrue("Kara is not starting on an empty cell.");
    }

    private void allocateWorld(final int rows, final int columns) {
        Ensure.that(rows > 0).isTrue("Height %d must be positive.", rows);
        Ensure.that(columns > 0).isTrue("Width %d must be positive.", columns);

        height = rows;
        width = columns;

        world = new Element[height][width];
    }

    private void createWorld(final int rows, final int columns) {
        allocateWorld(rows, columns);

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                world[row][column] = Element.O;
            }
        }
    }

    private void createWorld(final String[] content) {
        allocateWorld(content.length, content[0].length());

        for (int row = 0; row < height; row++) {
            String currentRow = content[row];
            Ensure.that(currentRow.length() == width).isTrue("Each row must have the same width");
            for (int column = 0; column < width; column++) {
                world[row][column] = Element.valueOf(currentRow.charAt(column));
            }
        }
    }

    @Override
    public void move() {
        Offset offset = karaOrientation.front();
        karaRow = actualRow(karaRow + offset.y);
        karaColumn = actualColumn(karaColumn + offset.x);

        if (kara() == Element.T) {
            fail("Can't enter a cell that contains a tree.");
        }
        else if (containsMushroom(kara())) {
            int mushroomRow = actualRow(karaRow + offset.y);
            int mushroomColumn = actualColumn(karaColumn + offset.x);
            Element newCell = world(mushroomRow, mushroomColumn);
            if (newCell == Element.T || containsMushroom(newCell)) {
                fail("Can't move mushroom if cell behind contains a tree or mushroom.");
            }

            Element karaCell;
            if (kara() == Element.M) {
                karaCell = Element.O;
            }
            else {
                karaCell = Element.L;
            }
            if (newCell == Element.O) {
                newCell = Element.M;
            }
            else {
                newCell = Element.A;
            }
            world[karaRow][karaColumn] = karaCell;
            world[mushroomRow][mushroomColumn] = newCell;
        }
    }

    private String fail(final String message) {
        throw new AssertionFailedException(message + NEWLINE + toString());
    }

    private boolean containsMushroom(final Element newCell) {
        return newCell == Element.M || newCell == Element.A;
    }

    @Override
    public void turnLeft() {
        karaOrientation = karaOrientation.left();
    }

    @Override
    public void turnRight() {
        karaOrientation = karaOrientation.right();
    }

    @Override
    public void putLeaf() {
        if (kara() == Element.O) {
            kara(Element.L);
        }
        else {
            fail("The current cell already contains a leaf.");
        }
    }

    @Override
    public void removeLeaf() {
        if (isOnLeaf()) {
            kara(Element.O);
        }
        else {
            fail("The current cell contains no leaf.");
        }
    }

    private void kara(final Element newElement) {
        world[karaRow][karaColumn] = newElement;
    }

    private Element kara() {
        return world(karaRow, karaColumn);
    }

    private Element world(final int row, final int column) {
        return world[actualRow(row)][actualColumn(column)];
    }

    private int actualRow(final int row) {
        int actualRow;
        if (row >= height) {
            actualRow = 0;
        }
        else if (row == -1) {
            actualRow = height - 1;
        }
        else {
            actualRow = row;
        }
        return actualRow;
    }

    private int actualColumn(final int column) {
        int actualColumn;
        if (column >= width) {
            actualColumn = 0;
        }
        else if (column == -1) {
            actualColumn = width - 1;
        }
        else {
            actualColumn = column;
        }
        return actualColumn;
    }

    @Override
    public boolean isOnLeaf() {
        return kara() == Element.L;
    }

    private Element offset(final Offset offset) {
        return world(karaRow + offset.y, karaColumn + offset.x);
    }

    @Override
    public boolean isTreeFront() {
        return offset(karaOrientation.front()) == Element.T;
    }

    @Override
    public boolean isTreeLeft() {
        return offset(karaOrientation.left().front()) == Element.T;
    }

    @Override
    public boolean isTreeRight() {
        return offset(karaOrientation.right().front()) == Element.T;
    }

    @Override
    public boolean isMushroomFront() {
        return containsMushroom(offset(karaOrientation.front()));
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder();
        content.append(NEWLINE);
        content.append(showKara());
        content.append(NEWLINE);
        for (Element[] currentRow : world) {
            for (Element element : currentRow) {
                content.append(element);
            }
            content.append(NEWLINE);
        }
        return content.toString();
    }

    /**
     * Shows the position of
     *
     * @return a String representing the position of Kara
     */
    public String showKara() {
        return String.format("Kara: [%d, %d, %s]", karaRow, karaColumn, karaOrientation);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + karaColumn;
        result = prime * result + ((karaOrientation == null) ? 0 : karaOrientation.hashCode());
        result = prime * result + karaRow;
        result = prime * result + Arrays.hashCode(world);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        JunitKaraRunner other = (JunitKaraRunner)obj;
        if (karaColumn != other.karaColumn) {
            return false;
        }
        if (karaOrientation != other.karaOrientation) {
            return false;
        }
        if (karaRow != other.karaRow) {
            return false;
        }
        return Arrays.deepEquals(world, other.world);
    }

    /**
     * Returns the leaves of the world.
     *
     * @return a two-dimensional array showing the leaves of the world
     */
    public boolean[][] getLeaves() {
        boolean[][] containsLeaf = new boolean[height][width];
        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world[y].length; x++) {
                containsLeaf[y][x] = world[y][x] == Element.L;
            }
        }
        return containsLeaf;
    }

    /**
     * The valid elements in Kara's world. [T]ree, [L]eaf, [M]ushroom, Leaf [A]nd Mushroom, and N[O]thing.
     */
    private enum Element {
        T("#"), L("."), M("$"), O(" "), A("*");
        private final String symbol;

        private Element(final String symbol) {
            this.symbol = symbol;
        }

        public static Element valueOf(final char value) {
            switch (value) {
                case 'T':
                case '#':
                    return T;
                case 'L':
                case '.':
                    return L;
                case 'M':
                case '$':
                    return M;
                case 'O':
                case ' ':
                    return O;
                case 'A':
                case '*':
                    return A;
            }
            throw new IllegalArgumentException(String.format("Can't convert character %c to world element.", value));
        }

        @Override
        public String toString() {
            return symbol;
        }
    }
}
