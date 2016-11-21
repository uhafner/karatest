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
    public boolean isTreeFront() {
        return karaRunner.isTreeFront();
    }

    @Override
    public boolean isTreeLeft() {
        return karaRunner.isTreeLeft();
    }

    @Override
    public boolean isTreeRight() {
        return karaRunner.isTreeRight();
    }

    @Override
    public boolean isOnLeaf() {
        return karaRunner.isOnLeaf();
    }

    @Override
    public boolean isMushroomFront() {
        return karaRunner.isMushroomFront();
    }

    @Override
    public void stop() {
        // do nothing
    }

    @Override
    public void showMessage(final String format, final Object... arguments) {
        tools.showMessage(format, arguments);
    }

    @Override
    public long readLong(final String format, final Object... arguments) {
        return tools.readLong(format, arguments);
    }

    @Override
    public int readInt(final String format, final Object... arguments) {
        return tools.readInt(format, arguments);
    }

    void setTools(final Tools tools) {
        this.tools = tools;
    }

    @Override
    public void clear() {
        karaRunner.clear();
    }
}
