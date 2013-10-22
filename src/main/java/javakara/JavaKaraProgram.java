package javakara;


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

    /** Kara the ladybug. */
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("")
    protected Kara kara = new Kara(); // NOCHECKSTYLE
}

