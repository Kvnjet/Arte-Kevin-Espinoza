package Interfaz;

import Pintor.*;
import Observer.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Interfaz extends JFrame {
	private int Npintores;
	private int Nelementos;
	//private PintorFactory pintorFactory; // Agrega una instancia de PintorFactory
	private List<Pintor> pintoresCreados; // Lista para almacenar los pintores creados
	private PintorFactory factory = new PintorFactory();
	
	
	public Interfaz() {
		this.pintoresCreados = new ArrayList<>(); // Inicialización de la lista
		
		// Configuración del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);  
        setExtendedState(JFrame.MAXIMIZED_BOTH); 

        JPanel panel = new JPanel();
        //panel.setBackground(Color.BLACK);  // Color de fondo

        getContentPane().add(panel);

        setVisible(true);
    }
	
	public void paint (Graphics g){
		super.paint(g);
		if (this.Nelementos > 0 && !pintoresCreados.isEmpty()) {
			for (int i = 0; i < this.Nelementos; i++ ) {
				this.getPintor().pintar(this.getGraphics(),this);
			}
		}
	}
	
	public static String generarElementoAleatorio() {
        // Generar un número aleatorio entre 1 y 3
        int numeroAleatorio = (int) (Math.random() * 3) + 1;

        // Array de strings
        ArrayList<String> elementos = new ArrayList<>();
        elementos.add("lineas");
        elementos.add("puntos");
        elementos.add("figuras");

        // Obtener el elemento correspondiente al número aleatorio
        String elementoGenerado = elementos.get(numeroAleatorio - 1);

        System.out.println(elementoGenerado);
        return elementoGenerado;
    }
	
	public void CrearPintura(int pintores, int elementos) {
	    this.Npintores = pintores;
	    this.Nelementos = elementos;
	    
		while (pintores > 0) {
		    Pintor pintor = factory.crearPintor(generarElementoAleatorio());
		    pintor.agregarObserver(new ObservadorPintor());
		    pintoresCreados.add(pintor);
		    pintores--;
		}
	    this.repaint();
    }
	
	public Pintor getPintor(){
		int numeroAleatorio = (int) (Math.random() * this.pintoresCreados.size());
		return this.pintoresCreados.get(numeroAleatorio);
	}
	
	public static void main(String[] args) {
		Interfaz ventana = new Interfaz();
		ventana.CrearPintura(12,20);
	}
}

