# Performance

In diesem Repository befinden sich Projekte rund um das Thema Performanz.

## measurement

Eine Reihe von Utilities zum Messen und Auswerten von Messungen.

## test-beans

Dieses Projekt stellt einige Testdatenstrukturen zur Nutzung bei den Peformanztests bereit.

## bean-mapper-test

In diesem Projekt werden einige Java Bean Mapper getestet.

### Zugehörige Artikel

[Wer ist der optimale Java Bean Mapper?](https://www.frank-rahn.de/java-bean-mapper/?utm_source=github&utm_medium=readme&utm_campaign=performance&utm_content=top)

## Build mit Maven

Anwendung bauen: `$ mvn clean install`

### Durchführen der Messungen

Auf der Konsole in das Root-Verzeichnis des Projektes wechseln und die folgenden Befehle ausführen.

    $ mvn clean install
    $ cd bean-mapper-test/
    $ mvn -Dtest=PerformanceTestWithCompleteFixtures test
    $ mvn -Dtest=PerformanceTestWithIncompleteFixtures test

# Homepage des Autors

[Frank W. Rahn](https://www.frank-rahn.de/?utm_source=github&utm_medium=readme&utm_campaign=performance&utm_content=top)