package javakara;

import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * Base class for kara tests.
 *
 * @author Ulli Hafner
 */
public class AbstractKaraTest {
    /** Fails a test if the source code contains an infinite loop. */
    @Rule
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("URF")
    public final Timeout TIME_OUT = new Timeout(10_000); // NOCHECKSTYLE
}

