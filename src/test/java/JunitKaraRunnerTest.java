import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

                    assertThat(kara.isOnLeaf()).as("Kara is on leaf").isFalse();
                    assertThat(kara.isTreeFront()).as("No tree in front").isFalse();
                    assertThat(kara.isTreeLeft()).as("No tree on the left").isFalse();
                    assertThat(kara.isTreeRight()).as("No tree on the right").isFalse();
                    assertThat(kara.isMushroomFront()).as("No mushroom in front").isFalse();
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
                    assertThat(kara.isOnLeaf()).as("Kara is not on leaf").isTrue();
                    assertThat(kara.isTreeFront()).as("Tree in front").isTrue();
                    assertThat(kara.isTreeLeft()).as("Tree on the left").isTrue();
                    assertThat(kara.isTreeRight()).as("Tree on the right").isTrue();

                    assertThat(kara.isMushroomFront()).as("No mushroom in front").isFalse();
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
                    verifyMushrooms(orientation, row, column, getMushroomWorld(row, column));
                    verifyMushrooms(orientation, row, column, getMushroomAndLeafWorld(row, column));
                }
            }
        }
    }

    private void verifyMushrooms(final Orientation orientation, final int row, final int column, final String[] world) {
        JunitKaraRunner kara = new JunitKaraRunner(row, column, orientation, world);
        assertThat(kara.isOnLeaf()).as("Kara is not on leaf").isTrue();
        assertThat(kara.isTreeFront()).as("Tree in front").isFalse();
        assertThat(kara.isTreeLeft()).as("Tree on the left").isFalse();
        assertThat(kara.isTreeRight()).as("Tree on the right").isFalse();

        assertThat(kara.isMushroomFront()).as("No mushroom in front").isTrue();
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

        assertThat(kara.isMushroomFront()).as("There is no mushroom in front of Kara").isTrue();

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt").isEqualTo(new JunitKaraRunner(1, 1, Orientation.DOWN,
                        new String[] {
                                "OOO",
                                "OOO",
                                "OMO",
                        }));

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt").isEqualTo(new JunitKaraRunner(2, 1, Orientation.DOWN,
                        new String[] {
                                "OMO",
                                "OOO",
                                "OOO",
                        }));

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt").isEqualTo(new JunitKaraRunner(0, 1, Orientation.DOWN,
                        new String[] {
                                "OOO",
                                "OMO",
                                "OOO",
                        }));

        kara.turnLeft();
        kara.turnLeft();
        kara.move();

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt").isEqualTo(new JunitKaraRunner(1, 1, Orientation.UP,
                        new String[] {
                                "OMO",
                                "OOO",
                                "OOO",
                        }));

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt").isEqualTo(new JunitKaraRunner(0, 1, Orientation.UP,
                        new String[] {
                                "OOO",
                                "OOO",
                                "OMO",
                        }));

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt").isEqualTo(new JunitKaraRunner(2, 1, Orientation.UP,
                        new String[] {
                                "OOO",
                                "OMO",
                                "OOO",
                        }));
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
        assertThat(kara.isMushroomFront()).as("There is no mushroom in front of Kara").isTrue();

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt")
                .isEqualTo(new JunitKaraRunner(1, 1, Orientation.RIGHT,
                        new String[] {
                                "OOO",
                                "OOM",
                                "OOO",
                        }));

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt")
                .isEqualTo(new JunitKaraRunner(1, 2, Orientation.RIGHT,
                        new String[] {
                                "OOO",
                                "MOO",
                                "OOO",
                        }));

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt")
                .isEqualTo(new JunitKaraRunner(1, 0, Orientation.RIGHT,
                        new String[] {
                                "OOO",
                                "OMO",
                                "OOO",
                        }));

        kara.turnLeft();
        kara.turnLeft();
        kara.move();

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt")
                .isEqualTo(new JunitKaraRunner(1, 1, Orientation.LEFT,
                        new String[] {
                                "OOO",
                                "MOO",
                                "OOO",
                        }));

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt")
                .isEqualTo(new JunitKaraRunner(1, 0, Orientation.LEFT,
                        new String[] {
                                "OOO",
                                "OOM",
                                "OOO",
                        }));

        kara.move();
        assertThat(kara).as("Die Welten sind nicht korrekt")
                .isEqualTo(new JunitKaraRunner(1, 2, Orientation.LEFT,
                        new String[] {
                                "OOO",
                                "OMO",
                                "OOO",
                        }));
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

    private String[] getMushroomAndLeafWorld(final int row, final int column) {
        if (row == 0 && column == 0) {
            return new String[] {
                    "LA",
                    "AA"
            };
        }
        else  if (row == 0 && column == 1) {
            return new String[] {
                    "AL",
                    "AA"
            };
        }
        else if (row == 1 && column == 0) {
            return new String[] {
                    "AA",
                    "LA"
            };
        }
        else {
            return new String[] {
                    "AA",
                    "AL"
            };
        }
    }

    /**
     * Verifies that we can't move a mushroom if there is an obstacle behind.
     */
    @Test
    public void moveMushroomTreeInFront() {
        moveOverTree("OMT");
        moveOverTree("TOM");
        moveOverTree("MTO");

        moveOverTree("OAT");
        moveOverTree("TOA");
        moveOverTree("ATO");

        moveOverTree("OMM");
        moveOverTree("MOM");
        moveOverTree("MMO");

        moveOverTree("OAM");
        moveOverTree("MOA");
        moveOverTree("AMO");

        moveOverTree("OMA");
        moveOverTree("AOM");
        moveOverTree("MAO");

        moveOverTree("OAA");
        moveOverTree("AOA");
        moveOverTree("AAO");
    }

    private void moveOverTree(final String world) {
        try {
            JunitKaraRunner kara = new JunitKaraRunner(0,
                    world.indexOf('O'), Orientation.RIGHT,
                    new String[] {
                            world,
                    });
            kara.move();
            fail("Mushroom is moved over obstacle");
        }
        catch (AssertionError exception) {
            // ignore and return
        }
    }

    /**
     * Verifies that we can move a mushroom onto a leaf.
     */
    @Test
    public void moveMushroomOverLeaf() {
        JunitKaraRunner kara = new JunitKaraRunner(0,
                0, Orientation.RIGHT,
                new String[] {
                        "OLM",
                });

        kara.move();
        verifyMushroomOverLeaf(kara, "OLM", 1);

        kara.move();
        verifyMushroomOverLeaf(kara, "MLO", 2);

        kara.move();
        verifyMushroomOverLeaf(kara, "OAO", 0);

        kara.move();
        verifyMushroomOverLeaf(kara, "OLM", 1);
    }

    private void verifyMushroomOverLeaf(final JunitKaraRunner kara, final String expectedWorld, final int expectedColumn) {
        assertThat(kara).as("Die Welten sind nicht korrekt")
                .isEqualTo(new JunitKaraRunner(0, expectedColumn, Orientation.RIGHT,
                        new String[] {
                                expectedWorld,
                        }));
    }
}
