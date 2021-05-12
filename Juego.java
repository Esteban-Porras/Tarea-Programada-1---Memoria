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
    Cartas c[];
    int desplazamiento;
    
    public Juego(int n){
        c = new Cartas[n];
        desplazamiento=0;
    }
    
    public void agregueCarta(int k, int t){
        c[desplazamiento++]= new Cartas(k, t);  // se reserva espacio para el jugador actual
    }
    
    public void mostrar(){
        for (Cartas x: c){ 
            x.mostrarCarta();
        }
    }
    
    public static void main(){
        int i = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de jugadores en partida"));
        ListaJugadores lj = new ListaJugadores(i);
        lj.main(i);
        
        int k = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de pares que habrá"));
        int t = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de trios que habrá"));
        int n = (2*k+3*t);
        
        Cartas c = new Cartas(k, t);

        System.out.println("Cantidad de cartas: "+n);

        c.creacionPares();
        c.creacionTrios();
        for (int j=0;j<20;j++){
            lj.agregueCarta();
        }
        lj.mostrar();
    }
}
