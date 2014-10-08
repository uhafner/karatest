import org.junit.Test;

/**
 * Verifies that the solution for homework assignment 1 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment1Test extends AbstractTimeoutKaraTest {
    /**
     * Checks that Kara draws the acronym 'IB' into an empty world.
     */
    @Test
    public void shouldDrawIBIntoEmptyWorld() {
        verifyWorld(9, 8, createExpectedWorld());
    }

    protected String[] createExpectedWorld() {
        return new String[] {
                "OOOOOOOO",
                "OLOLLLOO",
                "OLOLOOLO",
                "OLOLOOLO",
                "OLOLLLOO",
                "OLOLOOLO",
                "OLOLOOLO",
                "OLOLLLOO",
                "OOOOOOOO",
        };
    }

    @Override
    protected Kara createProgram() {
        return new Assignment1();
    }
}
