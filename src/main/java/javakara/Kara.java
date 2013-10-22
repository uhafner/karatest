package javakara;

/**
 * Stub for Kara the ladybug.
 *
 * @author Ulli Hafner
 */
public class Kara implements KaraOperations {
    private final KaraRunner karaRunner;

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
}
