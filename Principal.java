import javax.swing.*;
import java.util.*;

/**
 * Clase controlador que permite el manejo de todas las demás clases así como de iniciar el juego mediante el metodo main.
 * 
 * @author Esteban Porras Herrera C06044
 * @version 15/5/2021
 */
public class Principal
{
    static int pares;
    static int trios;
    static int baraja;

    public static void pedirNumeroCarta(){
        pares = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de pares"));
        trios = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de trios"));
        baraja = (2*pares)+(3*trios);

        generarBaraja(baraja, pares, trios);
    }

    
    /**
     * Encargada de crear el arreglo con la cantidad de pares y trios establecidos en la clase pedirNumeroCarta().
     * 
     * @param numero asigna la cantidad de cartas totales.
     * @param pares asgina la cantidad de cartas dobles en la baraja
     * @param trios asgina la cantidad de cartas triples en la baraja
     */
    public static void generarBaraja(int numero, int pares, int trios){
        String letras[] = new String[]{"A","B","C", "D","E","F","G", "H","I","J","K", "L","M","N","O", "P","Q","R","S", "T", "U","V","W","X", "Y", "Z"};

        Cartas2[] baraja = new Cartas2[numero];
        Random aleatorio = new Random();
        Random posicionAleatoria = new Random();

        boolean numeroValido = true;

        boolean numeroValido2 = true;
        
        for(int i=0; i<pares; i++){
            Cartas2 carta = new Cartas2();
            carta.numero = 1 + aleatorio.nextInt(10);
            carta.letra = letras[aleatorio.nextInt(26)];
            for(int j=0; j<2; j++){
                while(numeroValido){
                    int pos = posicionAleatoria.nextInt(numero);
                    if(validarBaraja(baraja, pos)){
                        numeroValido = false;
                        baraja[pos] = carta;
                    }
                }
                numeroValido = true;
            }            
        }
        
        

        for(int i=0; i<trios; i++){
            Cartas2 carta = new Cartas2();
            carta.numero = 1 + aleatorio.nextInt(10);
            carta.letra = letras[aleatorio.nextInt(26)];
            for(int j=0; j<3; j++){
                while(numeroValido2){
                    int pos = posicionAleatoria.nextInt(numero);
                    if(validarBaraja(baraja, pos)){
                        numeroValido2 = false;
                        baraja[pos] = carta;
                    }
                }
                numeroValido2 = true;
            }            
        }
        
        imprimirBaraja(baraja);
    }

    
    /**
     * Baraja las cartas.
     * 
     * @param baraja[] llama a la variable creada en la clase generarBaraja
     * @param numero hace referencia a la cantidad de cartas generadas.
     */
    public static boolean validarBaraja(Cartas2 baraja[], int numero){
        if(baraja[numero] == null){
            return true;
        } 
        return false;
    }

    /**
     * Cumple la funcion de imprimir el arreglo con las correspondientes cartas.
     * 
     * @param baraja[] llama a la variable creada en la clase generarBaraja
     */
    public static void imprimirBaraja(Cartas2 baraja[]){
        int linea = 1;
        for(Cartas2 x: baraja){
            if(x != null){
                // System.out.println("("+x.letra +","+x.numero+")");
                System.out.println(linea+" - (x,y)");
                linea++;
            }
        }
    }
    
    
    /**
     * Le solicita al usuario las posiciones en el arreglo y las compara.
     * 
     * @param baraja[] llama a la variable creada en la clase generarBaraja
     */
    public static void pedirPosicion(Cartas2 baraja[]){
        int x = Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion de la primera carta"));;
        int y = Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion de la segunda carta"));;
        if(baraja[x].letra == baraja[y].letra){
            
        }
    }

    
    /**
     * Ejecuta el programa.
     */
    public static void main(String args[]){
        pedirNumeroCarta();
    }
}
