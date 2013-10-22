Testadapter für JavaKara
========================

Spezieller JUnit Adapter für JavaKara Programme, mit dem die Auswertung von
Aufgaben ohne manuelle Interaktion erfolgen kann.

Alle Klassen liegen in einem Eclipse Projekt, in dem die wichtigsten
statischen Codeanalyse Tools konfiguriert wurden. Das Projekt ist gleichzeitig 
auch als Maven Projekt konfiguriert, so dass sich die Konfiguration sowohl unter 
Eclipse als auch unter Maven 1:1 nutzen lässt.

Folgende wichtigen Punkte sind enthalten:
* Maven Build: Das Projekt lässt sich automatisiert mit folgendem Maven Kommando bauen:
  mvn clean install checkstyle:checkstyle pmd:pmd pmd:cpd findbugs:findbugs cobertura:cobertura
* Eclipse Build: Das Projekt lässt sich über das m2e Eclipse Plug-in importieren und
  analysiert die Code mit Checkstyle, PMD und FindBugs. Die Code Coverage der Unittests
  lässt sich mit dem EclEmma Plug-in auswerten.
* In den Eclipse Einstellungen (.settings Verzeichnis) wurde eine sinnvolle Konfiguration
  für Compiler Warnungen, Code Formatter und Cleanup Wizards vorgegeben

Das Projekt lässt sich nur in Eclipse 3.8/4.2 oder neuer importieren.
Folgenden Eclipse Plug-ins werden mindestens benötigt:
- m2e
- checkstyle
- findbugs
- pmd
- eclemma

Eine sinnvolle Sammlung von Plug-ins ist in der Datei eclipse-plugins.p2f enthalten.
