package javakara;

import static org.mockito.Mockito.*;


/**
 * Stub to ensure that each {@link JavaKaraProgram} will compile.
 *
 * @author Ulli Hafner
 */
public class JavaKaraProgram {
    /**
     * Defines the runner to run this program with.
     *
     * @param karaRunner the runner
     */
    public void setRunner(final KaraRunner karaRunner) {
        kara = new Kara(karaRunner);
    }

    /**
     * Sets the tools to the specified value.
     *
     * @param tools the value to set
     */
    public void setTools(final Tools tools) {
        this.tools = tools;
    }

    /** Kara the ladybug. */
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("")
    protected Kara kara = new Kara(); // NOCHECKSTYLE

    /** Kara the ladybug. */
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("")
    protected Tools tools = mock(Tools.class); // NOCHECKSTYLE
}

