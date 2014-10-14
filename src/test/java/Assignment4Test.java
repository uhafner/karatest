import org.junit.Test;

/**
 * Verifies that the solution for homework assignment 4 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment4Test extends Assignment1Test {
    /**
     * Checks that Kara does not change a world already containing 'IB'.
     */
    @Test
    public void shouldNotChangeAnything() {
        verifyWorld(createExpectedWorld(), createExpectedWorld());
    }

    /**
     * Checks that Kara draws the acronym 'IB' into an world containing the inverted picture of 'IB'.
     */
    @Test
    public void shouldToggleInvertedWorld() {
        verifyWorld(new String[]{
                "........",
                ". .   ..",
                ". . .. .",
                ". . .. .",
                ". .   ..",
                ". . .. .",
                ". . .. .",
                ". .   ..",
                "........",
        }, createExpectedWorld());
    }

    /**
     * Checks that Kara draws the acronym 'IB' into a world containing only leaves.
     */
    @Test
    public void shouldDrawIBIntoFilledWorld() {
        verifyWorld(new String[]{
                "........",
                "........",
                "........",
                "........",
                "........",
                "........",
                "........",
                "........",
                "........",
        }, createExpectedWorld());
    }

    @Override
    protected Kara createProgram() {
        return new Assignment4();
    }
}

