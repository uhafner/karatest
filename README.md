Analyse von GreenfootKara Programmen
====================================

GreenfootKara lässt sich nur über die Entwicklungsumgebung Greenfoot bedienen. Um die eigenen 
Programme dennoch automatisiert testen zu können, wurde das Projekt **KaraTest** geschaffen. 
Mit Hilfe dieses Projekts lassen sich Unit Tests vorgeben, die bestehende GreenfootKara
Programme validieren. Zusätzlich wurden auch die wichtigsten statischen Codeanalyse Tools 
konfiguriert, so dass auch die Code-Qualität automatisiert ausgewertet werden kann.

Benötigt werden [JDK 8](http://www.java.com) und [Maven](http://maven.apache.org/).

Das Projekt lässt sich damit automatisiert mit folgendem Maven Kommando bauen 
(Übersetzen der Quellen und Start der Tests):

```
  mvn clean test
```

Für die statische Codeanalyse lässt sich ein HTML Report erstellen, dazu ist das folgende Kommando 
auszuführen: 

```
  mvn clean test -Dmaven.test.failure.ignore=true site
```

Der [generierte Report](target/site/index.html) lässt sich dann im Browser analysieren. 