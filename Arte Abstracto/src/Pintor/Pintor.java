package Pintor;
import Observer.*;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public interface Pintor {
    void pintar(Graphics g, Component componente);
    void agregarObserver(Observer observer);
}
