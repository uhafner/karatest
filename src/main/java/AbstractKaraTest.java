import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;

import static org.mockito.Mockito.*;

/**
 * Base class for Kara tests.
 *
 * @author Ullrich Hafner
 */
public abstract class AbstractKaraTest {
    /**
     * Creates the Kara program under test.
     *
     * @return the program to test
     */
    protected abstract Kara createProgram();

    /**
     * Runs the program. The program must be defined in a method called 'myProgram'. The method is called using
     * reflection so implementers do not need to add an override annotation at their implementation.
     *
     * @param karaRunner
     *            the runner with the initial world to run the program with
     * @return the tools instance to check for message outputs
     * @throws IllegalArgumentException
     *             if the program method could not be started
     */
    protected Tools runProgram(final JunitKaraRunner karaRunner) {
        return runProgram(karaRunner, mock(Tools.class));
    }

    /**
     * Runs the program. The program must be defined in a method called 'myProgram'. The method is called using
     * reflection so implementers do not need to add an override annotation at their implementation.
     *
     * @param karaRunner
     *            the runner with the initial world to run the program with
     * @param tools
     *            the tools instance to read input data from
     * @return the tools instance to check for message outputs
     * @throws IllegalArgumentException
     *             if the program method could not be started
     */
    protected Tools runProgram(final JunitKaraRunner karaRunner, final Tools tools) {
        Kara program = createProgram();
        program.setRunner(karaRunner);
        program.setTools(tools);

        Method run;
        try {
            run = program.getClass().getDeclaredMethod("act", new Class[0]);
            run.invoke(program);
            return tools;
        }
        catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException exception) {
            throw new AssertionError("Can't invoke act()", exception);
        }
    }

    /**
     * Verifies that the program under test creates the expected world. The world is empty and Kara is set to 0, 0 with
     * orientation to the right. Kara must be at the same position after the program finished.
     *
     * @param width
     *            the width of the empty world
     * @param height
     *            the height of the empty world
     * @param expected
     *            the expected result
     */
    protected void verifyWorld(final int height, final int width, final String[] expected) {
        JunitKaraRunner karaRunner = new JunitKaraRunner(0, 0, Orientation.RIGHT, height, width);
        runProgram(karaRunner);

        assertEquals(expected, karaRunner);
    }

    /**
     * Verifies that the program under test creates the expected world. The world is empty and Kara is set to 0, 0 with
     * orientation to the right. Kara must be at the same position after the program finished.
     *
     * @param expected
     *            the expected result
     * @param actual
     *            the actual result represented by the runner
     *
     */
    protected void assertEquals(final String[] expected, final JunitKaraRunner actual) {
        Assert.assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(0, 0, Orientation.RIGHT, expected), actual);
    }

    /**
     * Verifies that the program under test creates the expected world. The world is initialized with the start values
     * and Kara is set to 0, 0 with orientation to the right. Kara must be at the same position after the program
     * finished.
     *
     * @param start
     *            the start world
     * @param expected
     *            the expected result
     */
    protected void verifyWorld(final String[] start, final String[] expected) {
        verifyWorld(start, 0, 0, Orientation.RIGHT, expected, 0, 0, Orientation.RIGHT);
    }

    /**
     * Verifies that the program under test creates the expected world and Kara is set to the expected position. The
     * world is initialized with the start values and Kara is set to 0, 0 with orientation to the right.
     *
     * @param start
     *            the start world
     * @param expected
     *            the expected result
     * @param expectedKaraRow
     *            the expected row of Kara
     * @param expectedKaraColumn
     *            the expected column of Kara
     */
    protected void verifyWorld(final String[] start, final String[] expected, final int expectedKaraRow,
            final int expectedKaraColumn) {
        verifyWorld(start, expectedKaraRow, expectedKaraColumn, Orientation.RIGHT, expected, 0, 0, Orientation.RIGHT);
    }

    /**
     * Verifies that the program under test does not change the world and Kara is set to the expected position. The
     * world is initialized with the start values and Kara is put at the specified position.
     *
     * @param start
     *            the start world
     * @param startKaraRow
     *            the start row of Kara
     * @param startKaraColumn
     *            the start column of Kara
     * @param startKaraOrientation
     *            the start orientation of Kara
     * @param expectedKaraRow
     *            the expected row of Kara
     * @param expectedKaraColumn
     *            the expected column of Kara
     * @param expectedKaraOrientation
     *            the start orientation of Kara
     */
    // CHECKSTYLE:OFF
    protected void verifyWorld(final String[] start, final int startKaraRow, final int startKaraColumn,
                               final Orientation startKaraOrientation, final int expectedKaraRow,
                               final int expectedKaraColumn, final Orientation expectedKaraOrientation) {
        verifyWorld(start, startKaraRow, startKaraColumn, startKaraOrientation,
                start, expectedKaraRow, expectedKaraColumn, expectedKaraOrientation);
    }

    /**
     * Verifies that the program under test does not change the world and Kara is set to the expected position. The
     * world is initialized with the start values and Kara is put at the specified position facing to the right.
     *
     * @param start
     *            the start world
     * @param startKaraRow
     *            the start row of Kara
     * @param startKaraColumn
     *            the start column of Kara
     * @param expectedKaraRow
     *            the expected row of Kara
     * @param expectedKaraColumn
     *            the expected column of Kara
     */
    // CHECKSTYLE:OFF
    protected void verifyWorld(final String[] start, final int startKaraRow, final int startKaraColumn,
                               final int expectedKaraRow, final int expectedKaraColumn) {
        verifyWorld(start, startKaraRow, startKaraColumn, Orientation.RIGHT,
                start, expectedKaraRow, expectedKaraColumn, Orientation.RIGHT);
    }

    /**
     * Verifies that the program under test creates the expected world and Kara is set to the expected position. The
     * world is initialized with the start values and Kara is put at the specified position.
     * Kara orientation is #{@link Orientation#RIGHT}.
     *
     * @param start
     *            the start world
     * @param startKaraRow
     *            the start row of Kara
     * @param startKaraColumn
     *            the start column of Kara
     * @param expected
     *            the expected result
     * @param expectedKaraRow
     *            the expected row of Kara
     * @param expectedKaraColumn
     *            the expected column of Kara
     */
    // CHECKSTYLE:OFF
    protected void verifyWorld(
            final String[] start, final int startKaraRow, final int startKaraColumn,
            final String[] expected, final int expectedKaraRow, final int expectedKaraColumn) {
        verifyWorld(start, startKaraRow, startKaraColumn, Orientation.RIGHT,
                expected, expectedKaraRow, expectedKaraColumn, Orientation.RIGHT);
    }

    // CHECKSTYLE:ON
    /**
     * Verifies that the program under test creates the expected world and Kara is set to the expected position. The
     * world is initialized with the start values and Kara is put at the specified position.
     *
     * @param start
     *            the start world
     * @param startKaraRow
     *            the start row of Kara
     * @param startKaraColumn
     *            the start column of Kara
     * @param startKaraOrientation
     *            the start orientation of Kara
     * @param expected
     *            the expected result
     * @param expectedKaraRow
     *            the expected row of Kara
     * @param expectedKaraColumn
     *            the expected column of Kara
     * @param expectedKaraOrientation
     *            the start orientation of Kara
     */
    // CHECKSTYLE:OFF
    protected void verifyWorld(final String[] start, final int startKaraRow, final int startKaraColumn,
            final Orientation startKaraOrientation, final String[] expected, final int expectedKaraRow,
            final int expectedKaraColumn, final Orientation expectedKaraOrientation) {
        JunitKaraRunner karaRunner = new JunitKaraRunner(startKaraRow, startKaraColumn, startKaraOrientation, start);
        runProgram(karaRunner);

        Assert.assertEquals("Die Welten sind nicht korrekt: Getestete Welt: "
                + new JunitKaraRunner(startKaraRow, startKaraColumn, startKaraOrientation, start)
                + "Ergebnis: ",
                new JunitKaraRunner(expectedKaraRow, expectedKaraColumn,
                expectedKaraOrientation, expected), karaRunner);
    }
    // CHECKSTYLE:ON

    /**
     * Verifies that the program under test moves to the expected position. The
     * world is initialized with the start values and Kara is put at the specified position.
     *
     * @param start
     *            the start world
     * @param startKaraRow
     *            the start row of Kara
     * @param startKaraColumn
     *            the start column of Kara
     * @param startKaraOrientation
     *            the start orientation of Kara
     * @param expectedKaraRow
     *            the expected row of Kara
     * @param expectedKaraColumn
     *            the expected column of Kara
     * @param expectedKaraOrientation
     *            the start orientation of Kara
     */
    // CHECKSTYLE:OFF
    protected void verifyKara(final String[] start, final int startKaraRow, final int startKaraColumn,
            final Orientation startKaraOrientation, final int expectedKaraRow,
            final int expectedKaraColumn, final Orientation expectedKaraOrientation) {
        JunitKaraRunner karaRunner = new JunitKaraRunner(startKaraRow, startKaraColumn, startKaraOrientation, start);
        runProgram(karaRunner);

        Assert.assertEquals("Kara ist an der falschen Stelle: ", new JunitKaraRunner(expectedKaraRow, expectedKaraColumn,
                expectedKaraOrientation, karaRunner.getHeight(), karaRunner.getWidth()).showKara(), karaRunner.showKara());
    }
    // CHECKSTYLE:ON}
}
