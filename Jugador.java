import java.util.*;
import javax.swing.*;

/**
 * Write a description of class Jugador here.
 * 
 * @author Esteban Porras Herrera 
 * @version 10/5/2021
 */
public class Jugador
{
    String nombre;
    int puntaje;

    public Jugador(String n, int p){
        nombre = n;
        puntaje = p;
    }

    public String darJugador(){
        return nombre+" "+puntaje;
    }
    
    public void mostrarJuador(){
        JOptionPane.showMessageDialog(null, "Nombre: "+nombre+"  Puntaje: "+puntaje);
    }
}
