package javakara;

/**
 * Null object pattern: this runner does nothing.
 *
 * @author Ulli Hafner
 */
public class KaraRunner implements KaraOperations {
    @Override
    public void move() {
        // do nothing
    }

    @Override
    public void turnLeft() {
        // do nothing
    }

    @Override
    public void turnRight() {
        // do nothing
    }

    @Override
    public void putLeaf() {
        // do nothing
    }

    @Override
    public void removeLeaf() {
        // do nothing
    }

    @Override
    public boolean treeFront() {
        return false;
    }

    @Override
    public boolean treeLeft() {
        return false;
    }

    @Override
    public boolean treeRight() {
        return false;
    }

    @Override
    public boolean onLeaf() {
        return false;
    }

    @Override
    public boolean mushroomFront() {
        return false;
    }
}
