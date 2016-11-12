import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Verifies that the solution for homework assignment 10 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment10Test extends AbstractTimeoutKaraTest {
    /**
     * Verifies that the algorithm can decode 0.
     */
    @Test
    public void shouldCompute0() {
        verifyProgram(new String[]{
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                }, 0);
    }

    /**
     * Verifies that the algorithm can decode 42.
     */
    @Test
    public void shouldCompute42() {
        verifyProgram(new String[]{
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        " .  ",
                        "  . ",
                }, 42);
    }

    /**
     * Verifies that the algorithm can decode 111.
     */
    @Test
    public void shouldCompute111() {
        verifyProgram(new String[]{
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "    ",
                        "   .",
                        "   .",
                        "   .",
                }, 111);
    }

    /**
     * Verifies that the algorithm can decode 1234567890.
     */
    @Test
    public void shouldCompute1234567890() {
        verifyProgram(new String[]{
                        "    ",
                        "    ",
                        "   .",
                        "  . ",
                        "  ..",
                        " .  ",
                        " . .",
                        " .. ",
                        " ...",
                        ".   ",
                        ".  .",
                        "    ",
                }, 1234567890);
    }

    /**
     * Verifies that the algorithm can decode 999999999999.
     */
    @Test
    public void shouldCompute999999999999() {
        verifyProgram(new String[]{
                        ".  .",
                        ".  .",
                        ".  .",
                        ".  .",
                        ".  .",
                        ".  .",
                        ".  .",
                        ".  .",
                        ".  .",
                        ".  .",
                        ".  .",
                        ".  .",
                }, 999999999999L);
    }

    private void verifyProgram(final String[] world, final long expectedValue) {
        JunitKaraRunner karaRunner = new JunitKaraRunner(0, 0, Orientation.RIGHT, world);
        Tools tools = runProgram(karaRunner);

        verify(tools).showMessage(matches("(.*\\D)?" + expectedValue + "(\\D.*)?"));
    }

    @Override
    protected Kara createProgram() {
        return new Assignment10();
    }
}

