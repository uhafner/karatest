import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.Timeout;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Base class for tests that fail if a timeout of 10 seconds is exceeded.
 *
 * @author Ulli Hafner
 */
public class AbstractTimeoutTest {
    /** Fails a test if the source code contains an infinite loop. */
    @Rule @SuppressFBWarnings("URF")
    public final Timeout TIME_OUT = new Timeout(10, TimeUnit.SECONDS); // NOCHECKSTYLE
}
