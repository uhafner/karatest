package javakara;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        JavaKaraProgram program = createProgram();
        program.setRunner(karaRunner);

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
}

