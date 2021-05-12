import java.util.*;
import javax.swing.*;

/**
 * @author Esteban Porras Herrera C06044 
 * @version 3/5/2021
 */
public class Cartas
{
    int k,t,n;
    char letra;
    int numero;
    public Cartas(int k, int t){
        k = k;
        t = t;
        n = 0;
    }

    public void creacionPares(){
        Random aleatorio = new Random();
        
        for(int i=0; i<k; i++){
            letra = (char) ((Math.random()*26)+65);
            numero = (int) ((Math.random()*10)+1);
            // System.out.println("("+letra+","+numero+")"+"\t");
            
            // System.out.println("("+letra+","+numero+")"+"\t");
        }
    }
    
    public void creacionTrios(){
        for(int i=0; i<t; i++){
            letra = (char) ((Math.random()*26)+65);
            numero = (int) ((Math.random()*10)+1);
            // System.out.println("("+letra+","+numero+")"+"\t");
            // System.out.println("("+letra+","+numero+")"+"\t");
            // System.out.println("("+letra+","+numero+")"+"\t");
        }
    }
    
    public String darCarta(){
        return letra+" "+numero;
    }
    
    public void mostrarCarta(){
        JOptionPane.showMessageDialog(null, letra+" "+numero);
    }
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

