Testadapter für GreenfootKara
=============================

Spezieller JUnit Adapter für GreenfootKara Programme, mit dem die Auswertung von
Aufgaben ohne manuelle Interaktion erfolgen kann.

Alle Klassen liegen in einem Maven Projekt, in dem die wichtigsten
statischen Codeanalyse Tools konfiguriert wurden. Das Projekt lässt sich damit
automatisiert mit folgendem Maven Kommando bauen:

```
  mvn clean install checkstyle:checkstyle pmd:pmd pmd:cpd findbugs:findbugs cobertura:cobertura
``