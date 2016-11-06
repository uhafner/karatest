import org.junit.Test;

/**
 * Verifies that the solution for homework assignment 8 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment8Test extends AbstractTimeoutKaraTest {
    /**
     * Verifies that the cross is correctly drawn.
     */
    @Test
    public void shouldDrawCrossIn3x3() {
        verifyWorld(3, 3,
                new String[] {
                        " . ",
                        "...",
                        " . ",
                });
    }

    /**
     * Verifies that the cross is correctly drawn.
     */
    @Test
    public void shouldDrawCrossIn4x4() {
        verifyWorld(4, 4,
                new String[] {
                        " .. ",
                        "....",
                        "....",
                        " .. ",
                });
    }

    /**
     * Verifies that the cross is correctly drawn.
     */
    @Test
    public void shouldDrawCrossIn5x5() {
        verifyWorld(5, 5,
                new String[] {
                        "  .  ",
                        "  .  ",
                        ".....",
                        "  .  ",
                        "  .  ",
                 });
    }

    /**
     * Verifies that the cross is correctly drawn.
     */
    @Test
    public void shouldDrawCrossIn6x6() {
        verifyWorld(6, 6,
                new String[] {
                        "  ..  ",
                        "  ..  ",
                        "......",
                        "......",
                        "  ..  ",
                        "  ..  ",
                 });
    }

    /**
     * Verifies that the diamond is correctly drawn.
     */
    @Test
    public void shouldDrawCrossIn7x7() {
        verifyWorld(7, 7,
                new String[] {
                        "   .   ",
                        "   .   ",
                        "   .   ",
                        ".......",
                        "   .   ",
                        "   .   ",
                        "   .   ",
                 });
    }

    @Override
    protected Kara createProgram() {
        return new Assignment8();
    }
}

