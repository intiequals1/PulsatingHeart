package pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

/**
 * Eine Java-Swing-Anwendung, die ein pulsierendes Herz mit einer Zählervariable anzeigt.
 * 
 * Das Herz pulsiert kontinuierlich und zeigt einen Zähler von 1 bis 10 in der Mitte an.
 */
public class PulsatingHeart extends JFrame {
    
    private HeartPanel heartPanel;

    /**
     * Konstruktor - Initialisiert das Hauptfenster und startet die Animation
     */
    public PulsatingHeart() {
        setTitle("Pulsierendes Herz");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        heartPanel = new HeartPanel();
        add(heartPanel);
        
        setVisible(true);
        
        // Starten des Pulsierens
        new PulseThread().start();
    }
    
    /**
     * Panel-Klasse für das Zeichnen des Herzens
     */
    class HeartPanel extends JPanel {
        private double scaleFactor = 1.0;
        private int currentValue = 1;
        
        public HeartPanel() {
            setBackground(Color.WHITE);
        }
        
        /**
         * Setzt den Skalierungsfaktor und Zählerwert für das Herz
         * 
         * @param scale Der Skalierungsfaktor für die Herzgröße
         * @param value Der Wert, der im Herzen angezeigt werden soll
         */
        public void setScaleFactor(double scale, int value) {
            this.scaleFactor = scale;
            this.currentValue = value;
            repaint();
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            int width = getWidth();
            int height = getHeight();
            
            // Herz in der Mitte zeichnen
            g2d.translate(width / 2, height / 2);
            g2d.scale(scaleFactor, scaleFactor);
            
            // Herz-Pfad erstellen
            Path2D path = new Path2D.Double();
            
            // Herzform basierend auf einer mathematischen Kurve
            path.moveTo(0, -50);
            
            // Linke Seite des Herzens
            path.curveTo(-100, -100, -100, 50, 0, 100);
            
            // Rechte Seite des Herzens
            path.curveTo(100, 50, 100, -100, 0, -50);
            
            // Rot ausfüllen
            g2d.setColor(Color.RED);
            g2d.fill(path);
            
            // Den aktuellen Wert von i in der Mitte des Herzens anzeigen
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 40));
            
            FontMetrics fm = g2d.getFontMetrics();
            String valueText = String.valueOf(currentValue);
            int textWidth = fm.stringWidth(valueText);
            int textHeight = fm.getHeight();
            
            g2d.drawString(valueText, -textWidth/2, textHeight/3);
        }
    }
    
    /**
     * Thread-Klasse für die Steuerung der Pulsation
     */
    class PulseThread extends Thread {
        @Override
        public void run() {
            int i = 1;
            
            for (int k = 1; k < 100; k++) {
                System.out.println(k + ". Step: ");
                
                while (i <= 10) {
                    try {
                        // Herzgröße basierend auf i anpassen (1.0 - 1.5)
                        final double scale = 1.0 + (i / 20.0);
                        
                        // UI-Update im EDT ausführen - sowohl Skalierung als auch aktuellen i-Wert übergeben
                        final int currentI = i;
                        SwingUtilities.invokeLater(() -> heartPanel.setScaleFactor(scale, currentI));
                        
                        // Eine Sekunde warten
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println("Thread was interrupted!");
                    }
                    System.out.println("i = " + i);
                    i++;
                }
                
                if (i == 10 || i > 10) {
                    i = 1;
                }
                
                try {
                    // 3 Sekunden warten am Ende jedes Zyklus
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.err.println("Thread was interrupted!");
                }
            }
        }
    }
    
    /**
     * Hauptmethode zum Starten der Anwendung
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PulsatingHeart());
    }
}
