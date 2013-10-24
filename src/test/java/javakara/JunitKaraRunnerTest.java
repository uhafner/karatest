package javakara;

import static org.junit.Assert.*;
import javakara.JunitKaraRunner.Orientation;

import org.junit.Test;

/**
 * Tests the class {@link JunitKaraRunner}.
 *
 * @author Ulli Hafner
 */
public class JunitKaraRunnerTest {
    /**
     * Verifies that each checking method returns {@code false} in an empty world.
     */
    @Test
    public void testEverythingEmptyIn2x2() {
        for (Orientation orientation : Orientation.values()) {
            for (int row = 0; row < 2; row++) {
                for (int column = 0; column < 2; column++) {
                    JunitKaraRunner kara = new JunitKaraRunner(row, column, orientation, 2, 2);

                    assertFalse("Kara is on leaf", kara.onLeaf());
                    assertFalse("No tree in front", kara.treeFront());
                    assertFalse("No tree on the left", kara.treeLeft());
                    assertFalse("No tree on the right", kara.treeRight());
                    assertFalse("No mushroom in front", kara.mushroomFront());
                }
            }
        }
    }

    /**
     * Verifies that each tree checking method returns {@code true} if the world contains only trees.
     */
    @Test
    public void onlyTreesIn2x2() {
        for (Orientation orientation : Orientation.values()) {
            for (int row = 0; row < 2; row++) {
                for (int column = 0; column < 2; column++) {
                    JunitKaraRunner kara = new JunitKaraRunner(row, column, orientation, getTreeWorld(row, column));
                    assertTrue("Kara is not on leaf", kara.onLeaf());
                    assertTrue("Tree in front", kara.treeFront());
                    assertTrue("Tree on the left", kara.treeLeft());
                    assertTrue("Tree on the right", kara.treeRight());

                    assertFalse("No mushroom in front", kara.mushroomFront());
                }
            }
        }
    }

    /**
     * Verifies that the mushroom checking method returns {@code true} if the world contains only mushrooms.
     */
    @Test
    public void onlyMushroomsIn2x2() {
        for (Orientation orientation : Orientation.values()) {
            for (int row = 0; row < 2; row++) {
                for (int column = 0; column < 2; column++) {
                    JunitKaraRunner kara = new JunitKaraRunner(row, column, orientation, getMushroomWorld(row, column));
                    assertTrue("Kara is not on leaf", kara.onLeaf());
                    assertFalse("Tree in front", kara.treeFront());
                    assertFalse("Tree on the left", kara.treeLeft());
                    assertFalse("Tree on the right", kara.treeRight());

                    assertTrue("No mushroom in front", kara.mushroomFront());
                }
            }
        }
    }

    /**
     * Verifies that mushroom moving works if there is no obstacle.
     */
    @Test
    public void moveMushroomVertically() {
        JunitKaraRunner kara = new JunitKaraRunner(0, 0, Orientation.RIGHT,
                new String[] {
                    "OOO",
                    "OMO",
                    "OOO",
                });
        kara.move();
        kara.turnRight();

        assertTrue("There is no mushroom in front of Kara", kara.mushroomFront());

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(1, 1, Orientation.DOWN,
                        new String[] {
                            "OOO",
                            "OOO",
                            "OMO",
                        }), kara);

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(2, 1, Orientation.DOWN,
                        new String[] {
                            "OMO",
                            "OOO",
                            "OOO",
                        }), kara);

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(0, 1, Orientation.DOWN,
                        new String[] {
                            "OOO",
                            "OMO",
                            "OOO",
                        }), kara);

        kara.turnLeft();
        kara.turnLeft();
        kara.move();

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(1, 1, Orientation.UP,
                        new String[] {
                            "OMO",
                            "OOO",
                            "OOO",
                        }), kara);

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(0, 1, Orientation.UP,
                        new String[] {
                            "OOO",
                            "OOO",
                            "OMO",
                        }), kara);

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(2, 1, Orientation.UP,
                        new String[] {
                            "OOO",
                            "OMO",
                            "OOO",
                        }), kara);
    }

    /**
     * Verifies that mushroom moving works if there is no obstacle.
     */
    @Test
    public void moveMushroomHoorizontally() {
        JunitKaraRunner kara = new JunitKaraRunner(1, 0, Orientation.RIGHT,
                new String[] {
                    "OOO",
                    "OMO",
                    "OOO",
                });
        assertTrue("There is no mushroom in front of Kara", kara.mushroomFront());

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(1, 1, Orientation.RIGHT,
                        new String[] {
                            "OOO",
                            "OOM",
                            "OOO",
                        }), kara);

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(1, 2, Orientation.RIGHT,
                        new String[] {
                            "OOO",
                            "MOO",
                            "OOO",
                        }), kara);

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(1, 0, Orientation.RIGHT,
                        new String[] {
                            "OOO",
                            "OMO",
                            "OOO",
                        }), kara);

        kara.turnLeft();
        kara.turnLeft();
        kara.move();

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(1, 1, Orientation.LEFT,
                        new String[] {
                            "OOO",
                            "MOO",
                            "OOO",
                        }), kara);

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(1, 0, Orientation.LEFT,
                        new String[] {
                            "OOO",
                            "OOM",
                            "OOO",
                        }), kara);

        kara.move();
        assertEquals("Die Welten sind nicht korrekt",
                new JunitKaraRunner(1, 2, Orientation.LEFT,
                        new String[] {
                            "OOO",
                            "OMO",
                            "OOO",
                        }), kara);
    }

    private String[] getTreeWorld(final int row, final int column) {
        if (row == 0 && column == 0) {
            return new String[] {
                "LT",
                "TT"
            };
        }
        else  if (row == 0 && column == 1) {
            return new String[] {
                "TL",
                "TT"
            };
        }
        else if (row == 1 && column == 0) {
            return new String[] {
                "TT",
                "LT"
            };
        }
        else {
            return new String[] {
                "TT",
                "TL"
            };
        }
    }

    private String[] getMushroomWorld(final int row, final int column) {
        if (row == 0 && column == 0) {
            return new String[] {
                "LM",
                "MM"
            };
        }
        else  if (row == 0 && column == 1) {
            return new String[] {
                "ML",
                "MM"
            };
        }
        else if (row == 1 && column == 0) {
            return new String[] {
                "MM",
                "LM"
            };
        }
        else {
            return new String[] {
                "MM",
                "ML"
            };
        }
    }

}