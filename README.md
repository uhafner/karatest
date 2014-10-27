Analyse von GreenfootKara Programmen
====================================

GreenfootKara lässt sich nur über die Entwicklungsumgebung Greenfoot bedienen. Um die eigenen 
Programme dennoch automatisiert testen zu können, wurde das Projekt **KaraTest** geschaffen. 
Mit Hilfe dieses Projekts lassen sich Unit Tests vorgeben, die bestehende GreenfootKara
Programme validieren. Zusätzlich wurden auch die wichtigsten statischen Codeanalyse Tools 
konfiguriert, so dass auch die Code-Qualität automatisiert ausgewertet werden kann.

Benötigt werden [JDK 8](http://www.java.com) und [Maven](http://maven.apache.org/).

## Bearbeiten der Szenarien

Die Szenarien befinden sich im Ordner `scenarios`. Sie tragen die Namen assignment1, assignment2, etc.
In den einzelnen Szenarien befinden sich die jeweiligen Aufgaben in den entsprechenden Dateien Assignment1.java,
Assignment2.java, etc. Jedes Szenario ist unabhängig, d.h. der Ordner kann auch an einer anderen Stelle im Dateisystem
abgelegt und bearbeitet werden.

## Ausführen der Test 

Für jedes Szenario sind Testfälle vorgegeben, die sich in den Dateien Assignment1Test.java, Assignment2Test.java, etc.
befinden. Die Testfälle liegen im Ordner [Formatierung](../master/src/test/java). 
 
Ein Szenario lässt sich dann automatisiert testen, indem in der Eingabeaufforderung der Befehl `test` ausgeführt wird.

## Überprüfung der Kodierungsrichtlinien 

Die Kodierungsrichtlinien sind ebenso hinterlegt und können mit dem Kommando `site` überprüft werden. 
Der [generierte Report](target/site/index.html) lässt sich dann im Browser analysieren. 

## Technische Details

Die oben aufgeführte Automatisierung basiert auf dem Build Management Tool [Maven](http://maven.apache.org/). 
Die angegebenen Befehle sind letztlich nur kleine Wrapper-Scripts, die die folgenden Maven Befehle aufrufen.

### Übersetzen der Quellen und Start der Tests:

```
  mvn clean test
```

### Ausführen und Darstellen der statischen Analyse

```
  mvn clean test -Dmaven.test.failure.ignore=true site
```
