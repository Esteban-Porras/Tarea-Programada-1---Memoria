import java.util.*;
import javax.swing.*;

/**
 * Controlador de todas las clases
 * 
 * @author Esteban Porras Herrera C06044
 * @version (a version number or a date)
 */
public class Juego
{
    Cartas c[][];
    int desplazamiento;
    
    public Juego(){
        
    }
    
    public static void main(){
        int i = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de jugadores en partida"));
        ListaJugadores lj = new ListaJugadores(i);
        lj.main(i);
        
        Cartas c = new Cartas();

        int k = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de pares que habrá"));
        int t = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de trios que habrá"));
        char letra = ' ';
        int numero = 0;

        c.creacionCartas(k,t, letra, numero);
    }
}
