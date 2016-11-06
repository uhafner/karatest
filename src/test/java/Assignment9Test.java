import org.junit.Test;

/**
 * Verifies that the solution for homework assignment 9 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment9Test extends AbstractTimeoutKaraTest {
    /**
     * Verifies that nothing is done if the height is three.
     */
    @Test
    public void shouldDoNothing() {
        verifyWorld(
                new String[]{
                        "##",
                        "..",
                        "$$",
                        }, 1, 0,
                new String[]{
                        "##",
                        "..",
                        "$$",
                }, 1, 0
                );
    }

    /**
     * Verifies that the half circle is correctly repeated.
     */
    @Test
    public void shouldDrawCircle() {
        verifyWorld(
                new String[]{
                        "  ####  ",
                        " #    # ",
                        "#      #",
                        "........",
                        "$$$$$$$$",
                        "        ",
                        "        "}, 3, 0,
                new String[]{
                        "  ####  ",
                        " #    # ",
                        "#      #",
                        "........",
                        "$      $",
                        " $    $ ",
                        "  $$$$  "}, 3, 0

                );
    }

    /**
     * Verifies that the cross is correctly repeated.
     */
    @Test
    public void shouldDrawCross() {
        verifyWorld(
                new String[]{
                        "#     #",
                        " #   # ",
                        "  # #  ",
                        "   #   ",
                        ".......",
                        "$$$$$$$",
                        "       ",
                        "       ",
                        "       ",
                        }, 4, 0,
                new String[]{
                        "#     #",
                        " #   # ",
                        "  # #  ",
                        "   #   ",
                        ".......",
                        "   $   ",
                        "  $ $  ",
                        " $   $ ",
                        "$     $",
                        }, 4, 0

                );
    }

    @Override
    protected Kara createProgram() {
        return new Assignment9();
    }
}

