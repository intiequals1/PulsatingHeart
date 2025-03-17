# PulsatingHeart
Eine Java-Anwendung mit einem pulsierenden Herz und Zähler

## Funktionen

- Animiertes pulsierendes Herz mit glatter Animation
- Zähler im Herzen, der zwischen 1 und 10 läuft
- Einfache, selbstständige Java-Anwendung

## Anforderungen

- Java Runtime Environment (JRE) 8 oder höher

## Installation und Ausführung

### Option 1: Direkte Ausführung der JAR-Datei

1. Laden Sie die [neueste Version](https://github.com/intiequals1/PulsatingHeart/releases/tag/v1.0.0) herunter
2. Doppelklicken Sie auf die JAR-Datei oder führen Sie sie mit folgendem Befehl aus:
   ```
   java -jar PulsatingHeart.jar
   ```

### Option 2: Kompilieren des Quellcodes

1. Klonen Sie dieses Repository:
   ```
   git clone https://github.com/intiequals1/PulsatingHeart.git
   ```
2. Navigieren Sie zum Projektverzeichnis:
   ```
   cd PulsatingHeart
   ```
3. Kompilieren Sie den Quellcode:
   ```
   javac -d bin src/pkg/PulsatingHeart.java
   ```
4. Führen Sie die Anwendung aus:
   ```
   java -cp bin pkg.PulsatingHeart
   ```

## Projektstruktur

```
PulsatingHeart/
├── src/
│   └── pkg/
│       └── PulsatingHeart.java
├── bin/
│   └── pkg/
│       ├── PulsatingHeart.class
│       ├── PulsatingHeart$HeartPanel.class
│       └── PulsatingHeart$PulseThread.class
├── PulsatingHeart.jar
├── README.md
└── LICENSE
```

## Funktionsweise

Die Anwendung basiert auf Java Swing und besteht aus drei Hauptkomponenten:

1. PulsatingHeart: Die Hauptklasse, die das JFrame erstellt
2. HeartPanel: Zeichnet das Herz mit der Zählervariable
3. PulseThread: Steuert die Pulsation und den Zähler

Die Pulsation wird durch Änderung des Skalierungsfaktors des Herzens erreicht, während die Zählervariable im Zentrum des Herzens angezeigt wird.

## Beitragen

Beiträge zum Projekt sind willkommen! Hier sind einige Möglichkeiten:

1. Neue Funktionen hinzufügen (z.B. verschiedene Herzformen, Farboptionen)
2. Bugs beheben
3. Dokumentation verbessern

Einfach einen Fork erstellen und einen Pull Request öffnen.

## Lizenz

Dieses Projekt steht unter der MIT-Lizenz - siehe die [LICENSE](LICENSE) Datei für Details.
