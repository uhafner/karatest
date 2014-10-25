/**
 * Verifies that the solution for homework assignment 2 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment2Test extends Assignment1Test {
    // Same expected results as in assignment 1

    @Override
    protected Kara createProgram() {
        return new Assignment2();
    }
}

