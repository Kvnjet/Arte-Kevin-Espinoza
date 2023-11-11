package Pintor;
import Observer.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class PintorDeLineas implements Pintor {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void pintar(Graphics g, Component componente) {
    	Graphics2D g2d = (Graphics2D) g;
        String[] colores = {"red", "green", "blue", "yellow", "orange", "purple", "pink"};
        String colorName = colores[new Random().nextInt(colores.length)];
        Color color = Color.getColor(colorName);
        g2d.setColor(color);
        notificarObservers();
        
        int longitud = new Random().nextInt(50) + 10;

        // Ángulo al azar en radianes
        double angulo = Math.toRadians(new Random().nextInt(360));

        // Calcular las coordenadas finales de la línea
        int x1 = new Random().nextInt(componente.getWidth());
        int y1 = new Random().nextInt(componente.getHeight());
        int x2 = (int) (x1 + longitud * Math.cos(angulo));
        int y2 = (int) (y1 + longitud * Math.sin(angulo));

        g2d.drawLine(x1, y1, x2, y2);
        notificarObservers();
    }

    @Override
    public void agregarObserver(Observer observer) {
        observers.add(observer);
    }

    private void notificarObservers() {
        for (Observer observer : observers) {
            observer.actualizar(this);
        }
    }
}

