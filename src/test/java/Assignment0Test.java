import org.junit.Test;

/**
 * Verifies that the solution for the example assignment works as expected. I.e., the program
 * draws diamonds in different worlds.
 *
 * @author Ullrich Hafner
 */
public class Assignment0Test extends AbstractTimeoutKaraTest {
    /**
     * Verifies that the diamond is correctly drawn.
     */
    @Test
    public void shouldDrawDiamondIn5x5() {
        verifyWorld(5, 5,
                new String[] {
                        "  .  ",
                        " ... ",
                        ".....",
                        " ... ",
                        "  .  ",
                 });
    }

    /**
     * Verifies that the diamond is correctly drawn.
     */
    @Test
    public void shouldDrawDiamondIn3x3() {
        verifyWorld(3, 3,
                new String[] {
                        " . ",
                        "...",
                        " . ",
                 });
    }

    /**
     * Verifies that the diamond is correctly drawn.
     */
    @Test
    public void shouldDrawDiamondIn9x9() {
        verifyWorld(9, 9,
                new String[] {
                        "    .    ",
                        "   ...   ",
                        "  .....  ",
                        " ....... ",
                        ".........",
                        " ....... ",
                        "  .....  ",
                        "   ...   ",
                        "    .    ",
                 });
    }

    @Override
    protected Kara createProgram() {
        return new Assignment0();
    }
}

