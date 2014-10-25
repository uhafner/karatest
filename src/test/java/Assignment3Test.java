import org.junit.Test;

/**
 * Verifies that the solution for homework assignment 3 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment3Test extends AbstractTimeoutKaraTest {
    /**
     * Verifies that the checkerboard is correctly drawn.
     */
    @Test
    public void shouldDrawCheckerBoard() {
        verifyWorld(8, 8,
                new String[] {
                        ". . . . ",
                        " . . . .",
                        ". . . . ",
                        " . . . .",
                        ". . . . ",
                        " . . . .",
                        ". . . . ",
                        " . . . .",
                 });
    }

    @Override
    protected Kara createProgram() {
        return new Assignment3();
    }
}

