import java.util.*;
import javax.swing.*;

/**
 * Write a description of class ListaJugadores here.
 * 
 * @author Esteban Porras Herrera C06044 
 * @version 9/5/2021
 */
public class ListaJugadores
{
    Jugador j[];  //definición de un contenedor de jugadores
    int desplazamiento;
    
    public ListaJugadores(int n) //el parametro n define la cantidad de jugadores en juego
    {
       j = new Jugador[n];  //RESERVA DE ESPACIO para manejar las direcciones a los objetos
       desplazamiento=0;
    }
    
    
    /**
     * @param n asigna el nombre al jugador
     */
    public void agregueJugador(String n, int p){
        j[desplazamiento++]= new Jugador(n, p);  // se reserva espacio para el jugador actual
    }
    
    
    public void mostrar(){
        for (Jugador x:j){ 
            x.mostrarJuador();
        }
    }

    
    public static void main (){
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de jugadores en partida"));
        ListaJugadores listaJ = new ListaJugadores(cantidad);
        String nombre;
        int puntaje = 0;
        for (int i=0;i<cantidad;i++){
            nombre= JOptionPane.showInputDialog("Digite el nombre del jugador");
            listaJ.agregueJugador(nombre, puntaje);
        }
        listaJ.mostrar();
    }
}
