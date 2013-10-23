package javakara;

import java.util.Arrays;

/**
 * JUnit driver to run Kara through a given world.
 *
 * @author Ulli Hafner
 */
public class JunitKaraRunner extends KaraRunner {
    private static final String NEWLINE = "\n";

    /**
     * The valid elements in Kara's world. [T]ree, [L]eaf, [M]ushroom and N[O]thing.
     */
    private enum Element {
        T, L, M, O;
    }

    /**
     * The orientation of Kara.
     */
    public enum Orientation {
        /** Kara is looking to the left. */
        LEFT {
            @Override
            public Orientation left() {
                return DOWN;
            }

            @Override
            public Orientation right() {
                return UP;
            }
        },
        /** Kara is looking to the right. */
        RIGHT {
            @Override
            public Orientation left() {
                return UP;
            }

            @Override
            public Orientation right() {
                return DOWN;
            }
        },
        /** Kara is looking up. */
        UP {
            @Override
            public Orientation left() {
                return LEFT;
            }

            @Override
            public Orientation right() {
                return RIGHT;
            }
        },
        /** Kara is looking down. */
        DOWN {
            @Override
            public Orientation left() {
                return RIGHT;
            }

            @Override
            public Orientation right() {
                return LEFT;
            }
        };

        /**
         * Turns left through 90 degrees.
         *
         * @return the new orientation
         */
        public abstract Orientation left();

        /**
         * Turns right through 90 degrees.
         *
         * @return the new orientation
         */
        public abstract Orientation right();
    }

    private Element[][] world = new Element[0][0];

    private Orientation karaOrientation;
    private int karaColumn;
    private int karaRow;

    private int worldRows;
    private int worldColumns;

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
     * @param rows
     *            Number of empty rows
     * @param columns
     *            Number of empty columns
     */
    public JunitKaraRunner(final int row, final int column, final Orientation orientation, final int rows,
            final int columns) {
        this(row, column, orientation);

        createWorld(rows, columns);
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
    }

    private void allocateWorld(final int rows, final int columns) {
        Ensure.that(columns > 0).isTrue("Number of columns must be positive.");
        Ensure.that(rows > 0).isTrue("Number of rows must be positive.");

        worldRows = rows;
        worldColumns = columns;
        world = new Element[rows][columns];
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

        for (int row = 0; row < worldRows; row++) {
            String currentRow = content[row];
            Ensure.that(currentRow.length() == worldColumns).isTrue("All rows must have the same number of columns");
            for (int column = 0; column < worldColumns; column++) {
                world[row][column] = Element.valueOf(String.valueOf(currentRow.charAt(column)));
            }
        }
    }

    @Override
    public void move() {
        if (karaOrientation == Orientation.RIGHT) {
            karaColumn++;
            if (karaColumn == worldColumns) {
                karaColumn = 0;
            }
        }
        else if (karaOrientation == Orientation.LEFT) {
            karaColumn--;
            if (karaColumn == -1) {
                karaColumn = worldColumns - 1;
            }
        }
        else if (karaOrientation == Orientation.DOWN) {
            karaRow++;
            if (karaRow == worldRows) {
                karaRow = 0;
            }
        }
        else if (karaOrientation == Orientation.UP) {
            karaRow--;
            if (karaRow == -1) {
                karaRow = worldRows - 1;
            }
        }
        if (kara() == Element.T) {
            throw new AssertionFailedException("Can't enter a cell that contains a tree.");
        }
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
            throw new AssertionFailedException("The current cell already contains a leaf.");
        }
    }

    @Override
    public void removeLeaf() {
        if (onLeaf()) {
            kara(Element.O);
        }
        else {
            throw new AssertionFailedException("The current cell contains no leaf.");
        }
    }

    private void kara(final Element newElement) {
        world[karaRow][karaColumn] = newElement;
    }

    private Element kara() {
        return world[karaRow][karaColumn];
    }

    @Override
    public boolean onLeaf() {
        return kara() == Element.L;
    }

    @Override
    public boolean treeFront() {
        return false; // FIXME: implement feature
    }

    @Override
    public boolean treeLeft() {
        return false; // FIXME: implement feature
    }

    @Override
    public boolean treeRight() {
        return false; // FIXME: implement feature
    }

    @Override
    public boolean mushroomFront() {
        return false; // FIXME: implement feature
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder();
        content.append(NEWLINE);
        content.append(String.format("Kara: [%d, %d, %s]", karaRow, karaColumn, karaOrientation));
        content.append(NEWLINE);
        for (int row = 0; row < world.length; row++) {
            Element[] currentRow = world[row];
            for (int column = 0; column < currentRow.length; column++) {
                content.append(currentRow[column]);
            }
            content.append(NEWLINE);
        }
        return content.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
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
        if (!Arrays.deepEquals(world, other.world)) {
            return false;
        }
        return true;
    }
}
