import java.util.*;
import javax.swing.*;

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
