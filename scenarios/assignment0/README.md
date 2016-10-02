Example scenario
================
 
This example scenario shows the basic concepts of this project. It could be safely deleted if 
you are deploying your own assignment scenarios.

A scenario contains the whole source code of GreenfootKara 2.1.1 from [Marco Jakob](http://code.makery.ch)
as well as an empty assignment class [Assignment0](../master/src/main/java/Assignment0.java) and
its associated unit test class
[Assignment0Test](../master/src/test/java/Assignment0Test.java). 

Goal of this example assignment is to create a program that draws a diamond 
into an empty arbitrary sized world. (This example starts with an empty world. Have a look at the various
verifyWorld methods in [AbstractKaraTest](../master/src/main/java/AbstractKaraTest.java) to see on how to start with 
an existing world). 

------------------------------------------------------------------------
-- Kara Rules (ENGLISH) --
------------------------------------------------------------------------

-   Kara always moves in the direction he faces.
-   If Kara moves over a border he shows up on the opposite side again.
-   Kara can't move through trees.
-   Kara can push mushrooms if there is not another mushroom or a tree
    behind the mushroom to push.
-   Kara can put and remove leafs.
