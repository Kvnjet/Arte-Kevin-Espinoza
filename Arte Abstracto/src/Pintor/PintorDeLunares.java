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

public class PintorDeLunares implements Pintor {

    private List<Observer> observers = new ArrayList<>();
    

    public void pintar(Graphics g, Component componente) {
    	Graphics2D g2d = (Graphics2D) g;
        String[] colores = {"red", "green", "blue", "yellow", "orange", "purple", "pink"};
        String colorName = colores[new Random().nextInt(colores.length)];
        Color color = Color.getColor(colorName);
        g2d.setColor(color);
        notificarObservers();
        int radio = new Random().nextInt(50) + 10;
        int x = new Random().nextInt(componente.getWidth() - 2 * radio);
        int y = new Random().nextInt(componente.getHeight() - 2 * radio);

        Ellipse2D circulo = new Ellipse2D.Double(x, y, 2 * radio, 2 * radio);
        g2d.fill(circulo);
    }

	    public void agregarObserver(Observer observer) {
	        observers.add(observer);
	    }

	    private void notificarObservers() {
	        for (Observer observer : observers) {
	            observer.actualizar(this);
	        }
	    }
	}

