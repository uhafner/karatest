import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * Base class for Kara tests that fail if a timeout of 10 seconds is exceeded.
 *
 * @author Ullrich Hafner
 */
public abstract class AbstractTimeoutKaraTest extends AbstractKaraTest { // NOPMD
    /** Fails a test if the source code contains an infinite loop. */
    @Rule
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("URF")
    public final Timeout TIME_OUT = new Timeout(10_000); // NOCHECKSTYLE
}
