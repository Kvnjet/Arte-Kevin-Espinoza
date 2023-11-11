package Pintor;
import Observer.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class PintorDeFiguras implements Pintor {
	 private List<Observer> observers = new ArrayList<>();

	 public void pintar(Graphics g, Component componente) {
		 Graphics2D g2d = (Graphics2D) g;
	        String[] colores = {"red", "green", "blue", "yellow", "orange", "purple", "pink"};
	        String colorName = colores[new Random().nextInt(colores.length)];
	        Color color = Color.getColor(colorName);
	        g2d.setColor(color);
	        notificarObservers();

	        // Decidir al azar entre un triángulo y un cuadrado
	        if (new Random().nextBoolean()) {
	            dibujarTriangulo(g2d, componente);
	        } else {
	            dibujarCuadrado(g2d, componente);
	        }
	    }

	    private void dibujarTriangulo(Graphics2D g2d, Component componente) {
	        int[] xPoints = {new Random().nextInt(componente.getWidth()), new Random().nextInt(componente.getWidth()), new Random().nextInt(componente.getWidth())};
	        int[] yPoints = {new Random().nextInt(componente.getHeight()), new Random().nextInt(componente.getHeight()), new Random().nextInt(componente.getHeight())};

	        GeneralPath triangulo = new GeneralPath();
	        triangulo.moveTo(xPoints[0], yPoints[0]);
	        for (int i = 1; i < xPoints.length; i++) {
	            triangulo.lineTo(xPoints[i], yPoints[i]);
	        }
	        triangulo.closePath();

	        g2d.fill(triangulo);
	    }

	    private void dibujarCuadrado(Graphics2D g2d, Component componente) {
	        int lado = new Random().nextInt(50) + 10;
	        int x = new Random().nextInt(componente.getWidth() - lado);
	        int y = new Random().nextInt(componente.getHeight() - lado);

	        g2d.fillRect(x, y, lado, lado);
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
