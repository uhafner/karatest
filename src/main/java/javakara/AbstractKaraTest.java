package javakara;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javakara.JunitKaraRunner.Orientation;

import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * Base class for Kara tests.
 *
 * @author Ulli Hafner
 */
public abstract class AbstractKaraTest {
    /** Fails a test if the source code contains an infinite loop. */
    @Rule
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("URF")
    public final Timeout TIME_OUT = new Timeout(10_000); // NOCHECKSTYLE

    /**
     * Creates the Kara program under test.
     *
     * @return the program to test
     */
    protected abstract JavaKaraProgram createProgram();

    /**
     * Runs the program. The program must be defined in a method called 'myProgram'. The method is called using
     * reflection so implementors do not need to add an override annotation at their implementation.
     *
     * @param karaRunner
     *            the runner with the initial world to run the program with
     * @throws IllegalArgumentException
     *             if the program method could not be started
     */
    protected void runProgram(final JunitKaraRunner karaRunner) {
        runProgram(karaRunner, mock(Tools.class));
    }

    /**
     * Runs the program. The program must be defined in a method called 'myProgram'. The method is called using
     * reflection so implementors do not need to add an override annotation at their implementation.
     *
     * @param karaRunner
     *            the runner with the initial world to run the program with
     * @param tools
     *            the tools stub or mock to run the program with
     * @throws IllegalArgumentException
     *             if the program method could not be started
     */
    protected void runProgram(final JunitKaraRunner karaRunner, final Tools tools) {
        JavaKaraProgram program = createProgram();
        program.setRunner(karaRunner);
        program.setTools(tools);

        Method run;
        try {
            run = program.getClass().getDeclaredMethod("myProgram", new Class[0]);
            run.invoke(program, new Object[0]);
        }
        catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    /**
     * Verifies that the program under test creates the expected world and Kara is set to the expected position.
     * The world is initialized with the start values and Kara is set to 0, 0 with orientation to the right.
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
    protected void verifyWorld(final String[] start, final String[] expected, final int expectedKaraRow, final int expectedKaraColumn) {
        verifyWorld(start, expectedKaraColumn, expectedKaraColumn, Orientation.RIGHT, expected, 0, 0, Orientation.RIGHT);
    }

    /**
     * Verifies that the program under test creates the expected world and Kara is set to the expected position.
     * The world is initialized with the start values and Kara is set to 0, 0 with orientation to the right.
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
    protected void verifyWorld(final String[] start, final int startKaraRow, final int startKaraColumn, final Orientation startKaraOrientation,
            final String[] expected, final int expectedKaraRow, final int expectedKaraColumn, final Orientation expectedKaraOrientation) {
        JunitKaraRunner karaRunner = new JunitKaraRunner(startKaraRow, startKaraColumn, startKaraOrientation, start);
        runProgram(karaRunner);

        assertEquals("Die Welten sind nicht korrekt", new JunitKaraRunner(expectedKaraRow, expectedKaraColumn, expectedKaraOrientation,
                expected), karaRunner);
    }
    // CHECKSTYLE:ON
}
