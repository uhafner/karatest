/**
 * The orientation of Kara.
 *
 * @author Ullrich Hafner
 */
public enum Orientation {
    /** Kara is looking to the left. */
    LEFT {
        @Override
        public Orientation left() {
            return DOWN;
        }

        @Override
        public Orientation right() {
            return UP;
        }

        @Override
        public Offset front() {
            return new Offset(-1, 0);
        }
    },
    /** Kara is looking to the right. */
    RIGHT {
        @Override
        public Orientation left() {
            return UP;
        }

        @Override
        public Orientation right() {
            return DOWN;
        }

        @Override
        public Offset front() {
            return new Offset(1, 0);
        }
    },
    /** Kara is looking up. */
    UP {
        @Override
        public Orientation left() {
            return LEFT;
        }

        @Override
        public Orientation right() {
            return RIGHT;
        }

        @Override
        public Offset front() {
            return new Offset(0, -1);
        }
    },
    /** Kara is looking down. */
    DOWN {
        @Override
        public Orientation left() {
            return RIGHT;
        }

        @Override
        public Orientation right() {
            return LEFT;
        }

        @Override
        public Offset front() {
            return new Offset(0, 1);
        }
    };

    /**
     * Turns left through 90 degrees.
     *
     * @return the new orientation
     */
    public abstract Orientation left();

    /**
     * Turns right through 90 degrees.
     *
     * @return the new orientation
     */
    public abstract Orientation right();

    /**
     * Returns the offset of the element in front of
     *
     * @return the offset
     */
    public abstract Offset front();
}
