package Pintor;

import Observer.*;
import Pintor.*;

public class PintorFactory {
    public Pintor crearPintor(String tipo) {
    	Pintor pintor = null;
        switch (tipo.toLowerCase()) {
            case "lineas":
                pintor = new PintorDeLineas();
                break;
            case "puntos":
                pintor = new PintorDeLunares();
                break;
            case "figuras":
                pintor = new PintorDeFiguras();
                break;
        }

        // Agregar el observador por defecto a cada pintor
        pintor.agregarObserver(new ObservadorPintor());

        return pintor;
    }
}

