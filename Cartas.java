import java.util.*;
import javax.swing.*;

/**
 * @author Esteban Porras Herrera C06044 
 * @version 3/5/2021
 */
public class Cartas
{
    int k,t,n; 

    public Cartas(){
        k = 0;
        t = 0;
        n = 0;
    }

    public void creacionCartas(int k, int t, char letra, int numero){

        this.k = k;

        for(int i=0; i<k; i++){
            letra = (char) ((Math.random()*26)+65);
            numero = (int) ((Math.random()*10)+1);
            System.out.println("("+letra+","+numero+")"+"\t");
            System.out.println("("+letra+","+numero+")"+"\t");
        }

        this.t = t;
        for(int i=0; i<t; i++){
            letra = (char) ((Math.random()*26)+65);
            numero = (int) ((Math.random()*10)+1);
            System.out.println("("+letra+","+numero+")"+"\t");
            System.out.println("("+letra+","+numero+")"+"\t");
            System.out.println("("+letra+","+numero+")"+"\t");
        }

        int n = (2*k+3*t);

        System.out.println("Cantidad de cartas: "+n);

    }

    // public void creacionEspeciales(){
    // Random aleatorio = new Random();
    // for(int i=1; i<=10; i++){
    // if(i == aleatorio.nextInt(10)){
    // System.out.println("("+letra+","+numero+")"+"\t");
    // }
    // }

    // // }

    
    
    
    // public static void main(){
    // int i = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de jugadores en partida"));
    // ListaJugadores lj = new ListaJugadores(i);
    // lj.main(i);

    // Cartas c = new Cartas();

    // int k = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de pares que habrá"));
    // int t = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de trios que habrá"));
    // char letra = ' ';
    // int numero = 0;

    // c.creacionCartas(k,t, letra, numero);
    // }
}
