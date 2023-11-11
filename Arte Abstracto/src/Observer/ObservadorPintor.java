package Observer;
import Observer.*;
import Pintor.*;
import java.util.ArrayList;
import java.util.List;



public class ObservadorPintor implements Observer {
    private Pintor ultimoPintor;

    public void actualizar(Pintor pintor) {
        this.ultimoPintor = pintor;
        //System.out.println("Último pintor que pintó: " + pintor.getClass().getSimpleName());
    }
}