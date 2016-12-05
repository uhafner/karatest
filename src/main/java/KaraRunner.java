/**
 * Null object pattern: this runner does nothing.
 *
 * @author Ullrich Hafner
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
    public boolean isTreeFront() {
        return false;
    }

    @Override
    public boolean isTreeLeft() {
        return false;
    }

    @Override
    public boolean isTreeRight() {
        return false;
    }

    @Override
    public boolean isOnLeaf() {
        return false;
    }

    @Override
    public boolean isMushroomFront() {
        return false;
    }

    @Override
    public void stop() {
        // do nothing
    }

    @Override
    public void showMessage(final String format, final Object... arguments) {
        // do nothing
    }

    @Override
    public long readLong(final String format, final Object... arguments) {
        return 0;
    }

    @Override
    public int readInt(final String format, final Object... arguments) {
        return 0;
    }
}
