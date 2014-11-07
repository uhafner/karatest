/**
 * Stub for Kara the ladybug.
 *
 * @author Ullrich Hafner
 */
public class Kara implements KaraOperations {
    private KaraRunner karaRunner;
    private Tools tools;

    /**
     * Creates a new instance of {@link Kara}.
     *
     * @param karaRunner
     *            the runner to use
     */
    public Kara(final KaraRunner karaRunner) {
        this.karaRunner = karaRunner;
    }

    /**
     * Creates a new instance of {@link Kara}.
     */
    public Kara() {
        this(new KaraRunner());
    }

    public void setRunner(final KaraRunner karaRunner) {
        this.karaRunner = karaRunner;
    }

    @Override
    public void move() {
        karaRunner.move();
    }

    @Override
    public void turnLeft() {
        karaRunner.turnLeft();
    }

    @Override
    public void turnRight() {
        karaRunner.turnRight();
    }

    @Override
    public void putLeaf() {
        karaRunner.putLeaf();
    }

    @Override
    public void removeLeaf() {
        karaRunner.removeLeaf();
    }

    @Override
    public boolean treeFront() {
        return karaRunner.treeFront();
    }

    @Override
    public boolean treeLeft() {
        return karaRunner.treeLeft();
    }

    @Override
    public boolean treeRight() {
        return karaRunner.treeRight();
    }

    @Override
    public boolean onLeaf() {
        return karaRunner.onLeaf();
    }

    @Override
    public boolean mushroomFront() {
        return karaRunner.mushroomFront();
    }

    @Override
    public void stop() {
        // do nothing
    }

    @Override
    public void showMessage(final String format, final Object... arguments) {
        tools.showMessage(format, arguments);
    }

    void setTools(final Tools tools) {
        this.tools = tools;
    }
}
