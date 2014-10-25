/**
 * Assignment3 is a subclass of Kara. Therefore, it inherits all methods of Kara:
 * <p>
 * 
 * <i>Assignment3 ist eine Unterklasse von Kara. Sie erbt damit alle Methoden der
 * Klasse Kara:</i>
 * <p>
 * 
 * Actions: move(), turnLeft(), turnRight(), putLeaf(), removeLeaf() <b>
 * Sensors: onLeaf(), treeFront(), treeLeft(), treeRight(), mushroomFront()
 */
public class Assignment3 extends Kara {
    /**
     * In the 'act()' method you can write your program for Kara.<br>
     * <i>In der Methode 'act()' koennen die Befehle fuer Kara programmiert werden</i>
     */
    public void act() {
        // TODO: remove example code
        move();
        turnThrough90();
        turnThrough90();
        turnThrough90();
        turnThrough90();
    }

    // TODO: remove example method if not used
    /**
     * Turns Kara through 90 degrees.
     */
    void turnThrough90() {
        move();
        turnRight();
        move();
    }
}
