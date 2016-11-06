/**
 * Controls Kara the ladybug. Moves Kara through the worlds of a given scenario. Entry point is method
 * @{@link #act}, here all Kara actions need to be called (directly or via a method call).
 *
 * Kara can use the following five actions:
 * <ul>
 *      <li>move(): Kara moves one step forward</li>
 *      <li>turnRight(): Kara turns right by 90 degrees</li>
 *      <li>turnLeft(): Kara turns left by 90 degrees</li>
 *      <li>putLeaf(): Kara puts down a leaf</li>
 *      <li>removeLeaf(): Kara removes a leaf</li>
 * </ul>
 * Kara has five sensors to inspect the current world:
 * <ul>
 *      <li>isOnLeaf(): Is a Kara on a leaf?</li>
 *      <li>isTreeFront(): Is a tree in front of Kara?</li>
 *      <li>isTreeLeft(): Is a tree on the left of Kara?</li>
 *      <li>isTreeRight(): Is a tree on the right of Kara?</li>
 *      <li>isMushroomFront(): Is a mushroom in front of Kara?</li>
 * </ul>
 * isOnLeaf(), isTreeFront(), isTreeLeft(), isTreeRight(), isMushroomFront()
 */
public class Assignment8 extends Kara {
    /**
     * Entrypoint for Kara. This method is called once if you press the 'act' button in Greenfoot.
     */
    public void act() {
    }
}
