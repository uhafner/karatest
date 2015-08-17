Testing GreenfootKara Programs
==============================

[GreenfootKara](http://code.makery.ch/library/greenfoot-kara/) programs are only runnable using the integrated 
development environment [Greenfoot](www.greenfoot.org/) with manual interaction. **KaraTest** adds a unit test feature 
for GreenfootKara programs. Using this extension, you can create simple [JUnit](http://junit.org/) tests to validate
existing GreenfootKara programs. You can start these unit tests either in an arbitrary development environment 
(e.g., IntelliJ, Eclipse, ...) or in a terminal using the build management tool [Maven](http://maven.apache.org/). 
Greenfoot is **not** required to start and evaluate these tests: all dependencies to Greenfoot are replaced with a mock 
that is intercepting the calls to Greenfoot.

Additionally, static code analysis has been configured so that the code could be checked for common bug patterns 
(FindBugs), for coding style violations (CheckStyle) and conformance to best practices (PMD). The configuration of these 
tools is derived from [my Java coding style](https://github.com/uhafner/codingstyle).

This project has been used in my lecture *Software development with Java* to automatically evaluate the solutions of 
weekly assignments. Because of this I applied several naming conventions to simplify the processing. These naming 
conventions are not required to use **KaraTest** as a library, so feel free to change these values if required.

This project requires installation of [JDK 8](http://www.java.com) und [Maven 3.x](http://maven.apache.org/).

## Configuring the scenarios

**KaraTest** basically uses the same input files as Greenfoot, i.e. it is based on scenarios. Rather then always using 
the class `MyKara` to develop the solution for a scenario the classes `Assignment1`, `Assignment2`, etc. are used.  
In order to test a scenario you need a corresponding GreenfootKara scenario with such an assignment class. These 
scenarios must be located in the folder `scenarios`. They follow the naming convention assignment1, assignment2, etc.
Scenarios are independent of each other, i.e. you can copy these folders to or from any place you
like in order to prepare the installation.

## Creating the tests 

The tests of a scenario use the typical [JUnit](http://junit.org/) naming conventions and are named 
Assignment1Test.java, Assignment2Test.java, etc. For each assignment multiple tests could be specified
using a `public void` method with an `@Test` annotation. In order to get these tests automatically evaluated, they 
must follow the Maven conventions and must be copied to the folder [src/test/java](../master/src/test/java). No 
package is needed for these tests. The tests are not part of a scenario folder.
 
## Example scenario
 
This project already contains an example: assignment0. Here you basically see how to structure the scenarios and unit
tests. In this assignment, a world containing a diamond needs to be created. The provided unit test checks the program
by inspecting the created world after the program. Note that the unit tests will fail after a given timeout has been
exceeded. So the evaluation will not hang due to broken solutions. 
 
## Running the tests 

You can start the tests for all scenarios in a terminal using the following command:

```
  mvn clean test
```

## Running the static analysis

You can generate various project reports in a terminal using the following command:
 
```
  mvn clean test -Dmaven.test.failure.ignore=true site
```

The [generated reports](target/site/index.html) are visible in the browser afterwards. 


### Technical details

In order to validate only the classes of the actual assignments, the files Assignment1.java, 
Assignment2.java, etc. are copied from the folder `scenarios` to the folder `assignments` during the execution of Maven. 
I.e. in folder `assignments` only the actual assignment classes are visible, the dependencies are not available here. 

**Note**: If you open in Greenfoot a scenario in the folder `scenarios` then the containing files are automatically 
updated by Greenfoot, i.e. these files might be not in sync anymore with the files in folder im `assignments`!