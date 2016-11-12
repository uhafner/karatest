import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Verifies that the solution for homework assignment 11 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment11Test extends AbstractTimeoutKaraTest {
    /**
     * Verifies that the algorithm can decode 0.
     */
    @Test
    public void shouldCompute0() {
        verifyProgram(0, new String[]{
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
        });
    }

    /**
     * Verifies that the algorithm can decode 42.
     */
    @Test
    public void shouldCompute42() {
        verifyProgram(42, new String[]{
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
        });
    }

    /**
     * Verifies that the algorithm can decode 111.
     */
    @Test
    public void shouldCompute111() {
        verifyProgram(111, new String[]{
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
        });
    }

    /**
     * Verifies that the algorithm can decode 1234567890.
     */
    @Test
    public void shouldCompute1234567890() {
        verifyProgram(1234567890, new String[]{
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
        });
    }

    /**
     * Verifies that the algorithm can decode 999999999999.
     */
    @Test
    public void shouldCompute999999999999() {
        verifyProgram(999999999999L, new String[]{
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
        });
    }

    private void verifyProgram(final long inputNumber, final String[] expectedWorld) {
        JunitKaraRunner karaRunner = new JunitKaraRunner(0, 0, Orientation.RIGHT, 12, 4);

        Tools tools = mock(Tools.class);
        when(tools.readLong(anyString(), anyVararg())).thenReturn(inputNumber);

        runProgram(karaRunner, tools);

        assertEquals(expectedWorld, karaRunner);
    }

    @Override
    protected Kara createProgram() {
        return new Assignment11();
    }
}
