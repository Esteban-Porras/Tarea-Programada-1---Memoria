import javax.swing.*;
import java.util.*;

/**
 * Clase controlador que permite el manejo de todas las demás clases así como de iniciar el juego mediante el método main.
 * 
 * @author Esteban Porras Herrera C06044
 * @version 15/5/2021
 */
public class Principal
{
    static int pares;
    static int trios;
    static int baraja;
    static int jugadorTurno = 0;
    static Jugador[] player;
    static Comodin[] comodin = new Comodin[10];
    static boolean seguir = true;
    static String historialJugadas = "";
    static String historialGanadas = "";

    /**
     * Metodo encargado de solicitar el tamaño que tendrá la baraja,
     * además de ser quien ejecuta el metodo para generar la baraja.
     */
    public static void pedirNumeroCarta(){
        pares = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de pares de Cartas"));
        trios = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de trios de Cartas"));
        baraja = (2*pares)+(3*trios);

        generarBaraja(baraja, pares, trios);
    }

    /**
     * Encargada de crear el arreglo con la cantidad de pares y trios establecidos en la clase pedirNumeroCarta().
     * 
     * @param numero asigna la cantidad de cartas totales.
     * @param pares asgina la cantidad de cartas dobles en la baraja.
     * @param trios asgina la cantidad de cartas triples en la baraja.
     */
    public static void generarBaraja(int numero, int pares, int trios){
        String letras[] = new String[]{"A","B","C", "D","E","F","G", "H","I","J","K", "L","M","N","O", "P","Q","R","S", "T", "U","V","W","X", "Y", "Z"};

        Cartas[] baraja = new Cartas[numero];
        Random aleatorio = new Random();
        Random posicionAleatoria = new Random();

        boolean numeroValido = true;

        boolean numeroValido2 = true;

        for(int i=0; i<pares; i++){
            Cartas carta = new Cartas();
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
            Cartas carta = new Cartas();
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
        pedirPosicion(baraja);
    }

    /**
     * Encargada de generar aleatoreamente un arreglo de cartas comodin.
     */
    public static void cargarComodin(){
        Random comAleatorio = new Random();
        int duplicados = comAleatorio.nextInt(10);
        boolean comodinValido = true;

        int cuadruplicados = 10 - duplicados;

        for(int i=0; i<duplicados; i++){

            while(comodinValido){
                int pos = comAleatorio.nextInt(10);
                if(validarComodin(pos)){
                    comodinValido = false;
                    comodin[pos]= new Comodin("Duplicado");
                }
            }
            comodinValido = true;
        } 

        comodinValido = true;

        for(int j=duplicados; j<10; j++){
            while(comodinValido){
                int pos = comAleatorio.nextInt(10);
                if(validarComodin(pos)){
                    comodinValido = false;
                    comodin[pos]= new Comodin("Cuadruplicado");
                }
            }
            comodinValido = true;
        }
    }

    /**
     * Verifica que los Duplicar y Cuadriplicar no ocupen la posición de otro en el arreglo.
     */
    public static boolean validarComodin(int numero){
        if(comodin[numero] == null){
            return true;
        } 
        return false;
    }

    /**
     * Baraja las cartas.
     * 
     * @param baraja[] llama a la variable creada en la clase generarBaraja.
     * @param numero hace referencia a la cantidad de cartas generadas.
     */
    public static boolean validarBaraja(Cartas baraja[], int numero){
        if(baraja[numero] == null){
            return true;
        } 
        return false;
    }

    /**
     * Cumple la funcion de imprimir el arreglo con las correspondientes cartas.
     * 
     * @param baraja[] llama a la variable creada en la clase generarBaraja.
     */
    public static void imprimirBaraja(Cartas baraja[]){
        int linea = 1;
        for(Cartas x: baraja){
            if(x != null){
                //System.out.println(linea+" - ("+x.letra +","+x.numero+")");
                System.out.println(linea+" - (x,y)");
                linea++;
            }
        }
    }

    /**
     * Se encarga de eliminar las cartas que ya han encontrado su par.
     * También se encarga darle vuelta a las cartas escogidas por el jugador.
     * 
     * @param baraja[] llama a la variable creada en la clase generarBaraja.
     * @param posX hace referencia a la primera carta escogida por el usuario.
     * @param posY hace referencia a la segunda carta escogida por el usuario.
     */
    public static void imprimirReverso(Cartas baraja[], int posX, int posY){
        int linea = 1;
        System.out.println();
        System.out.println();
        for(int i=0; i<baraja.length; i++){
            if(baraja[i] == null){
                System.out.println(linea+" - ( VACIO )");
            }
            
            if((i == posX-1) || (i == posY-1)){
                System.out.println(linea+" - ("+baraja[i].letra +","+baraja[i].numero+")");
            } else if(baraja[i] != null){
                System.out.println(linea+" - (x,y)");
            }
            linea++;
        }
    }

    /**
     * Cumple la función de imprimir, de manera oculta, las cartas de la baraja comodín.
     */
    public static void imprimirComodin(){
        int linea = 1;
        System.out.println();
        System.out.println();
        for(Comodin x: comodin){
            if(x != null){
                System.out.println(linea+" - (COMODIN)");
                linea++;
            }
        }
    }
    
    /**
     * Despues de cada turno le pregunta al usuario si gusta finalizar el juego.
     * También se encarga de mostrar en pantalla el historial de la partida.
     */
    public static void validaTerminarJuego(){
        int endgame = Integer.parseInt(JOptionPane.showInputDialog("Gusta terminar el juego?\n1. Si\n2. No"));
        if(endgame == 1){
            int verHistorial = Integer.parseInt(JOptionPane.showInputDialog("Digite\n1. Ver historial Ganadas \n2. Historial Completo"));
            if(verHistorial == 1){
                System.out.println(historialGanadas);
            } else if(verHistorial == 2){
                System.out.println(historialJugadas);
            }
            seguir = false;
        }
    }

    
    /**
     * Le solicita al usuario las posiciones en el arreglo y las compara.
     * 
     * @param baraja[] llama a la variable creada en la clase generarBaraja.
     */
    public static void pedirPosicion(Cartas baraja[]){
        while(seguir){
            int x = Integer.parseInt(JOptionPane.showInputDialog("Jugador #"+(jugadorTurno+1)+" Digite la posicion de la primera carta"));
            int y = Integer.parseInt(JOptionPane.showInputDialog("Jugador #"+(jugadorTurno+1)+" Digite la posicion de la segunda carta"));
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Jugador #"+(jugadorTurno+1)+" Digite en que coinciden las cartas.\n1. Letra\n2. Numero\n3. Ambas"));

            imprimirReverso(baraja, x, y);

            switch(opcion){

                case 1: compararLetra(baraja,x, y);
                validaTerminarJuego();
                break;

                case 2:compararNumero(baraja,x, y);
                validaTerminarJuego();
                break;

                case 3:compararAmbos(baraja,x, y);
                validaTerminarJuego();
                break;

                default:
                seguir = false;
                break;
            }
        }
    }

    
    /**
     * Si el usuario decide que las 2 cartas coinciden por letra, este método se de encarga comprobar si esto es cierto.
     */
    public static void compararLetra(Cartas baraja[], int x,int y){
        if(baraja[x-1].letra == baraja[y-1].letra){
            int puntaje = player[jugadorTurno].getPuntaje();
            player[jugadorTurno].setPuntaje(puntaje + baraja[x-1].numero + baraja[y-1].numero);
            
            System.out.println();
            System.out.println();
            historialJugadas += "Jugador #" +(jugadorTurno+1);
            historialJugadas += "\nCarta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n";
            historialJugadas += "Carta 2: "+baraja[y-1].letra+","+baraja[y-1].numero+"\n";
            
            historialJugadas += "Puntos: "+ (baraja[x-1].numero + baraja[y-1].numero);
            
            
            //historialGanadas = historialGanadas + "Carta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n"
            
            historialGanadas += "Jugador #" +(jugadorTurno+1);
            historialGanadas += "\nCarta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n";
            historialGanadas += "Carta 2: "+baraja[y-1].letra+","+baraja[y-1].numero+"\n";
            
            
            historialGanadas += "Puntos: "+ (baraja[x-1].numero + baraja[y-1].numero);
            
            baraja[x-1] = null;
            baraja[y-1] = null;
            
            System.out.println("Jugador #" +(jugadorTurno+1) +" puntos: "+ player[jugadorTurno].getPuntaje());
            
        } else{   
            System.out.println();
            System.out.println();
            historialJugadas += "Jugador #" +(jugadorTurno+1);
            historialJugadas += "\nCarta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n";
            historialJugadas += "Carta 2: "+baraja[y-1].letra+","+baraja[y-1].numero+"\n";

            historialJugadas += "Puntos: "+ baraja[x-1].numero + baraja[y-1].numero;
            
            
            
            System.out.println("Jugador #" +(jugadorTurno+1) +" puntos: "+ player[jugadorTurno].getPuntaje());
            validarTurno();
        }
    }

    
    /**
     * Si el usuario decide que las 2 cartas coinciden por número, este método se encarga de comprobar si esto es cierto.
     */
    public static void compararNumero(Cartas baraja[], int x,int y){
        if(baraja[x-1].numero == baraja[y-1].numero){
            int puntaje = player[jugadorTurno].getPuntaje();
            player[jugadorTurno].setPuntaje(puntaje + baraja[x-1].numero + baraja[y-1].numero);
            
            System.out.println();
            System.out.println();
            historialJugadas += "Jugador #" +(jugadorTurno+1);
            historialJugadas += "\nCarta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n";
            historialJugadas += "Carta 2: "+baraja[y-1].letra+","+baraja[y-1].numero+"\n";

            historialJugadas += "Puntos: "+ (baraja[x-1].numero + baraja[y-1].numero);
            
            //historialGanadas = historialGanadas + "Carta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n"
            historialGanadas+= "Jugador #" +(jugadorTurno+1);
            historialGanadas += "\nCarta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n";
            historialGanadas += "Carta 2: "+baraja[y-1].letra+","+baraja[y-1].numero+"\n";
            
            
            historialGanadas += "Puntos: "+ (baraja[x-1].numero + baraja[y-1].numero);
            baraja[x-1] = null;
            baraja[y-1] = null;
            
            System.out.println("Jugador #" +(jugadorTurno+1) +" puntos: "+ player[jugadorTurno].getPuntaje());
        } else{
            System.out.println();
            System.out.println();
            historialJugadas += "Jugador #" +(jugadorTurno+1);
            historialJugadas += "\nCarta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n";
            historialJugadas += "Carta 2: "+baraja[y-1].letra+","+baraja[y-1].numero+"\n";

            historialJugadas += "Puntos: "+ (baraja[x-1].numero + baraja[y-1].numero);
            
            System.out.println("Jugador #" +(jugadorTurno+1) +" puntos: "+ player[jugadorTurno].getPuntaje());
            validarTurno();
        }
    }

    
    /**
     * Si el usuario decide que las 2 cartas coinciden por letra y número, este método se encarga de comprobar si esto es cierto.
     */
    public static void compararAmbos(Cartas baraja[], int x,int y){
        if((baraja[x-1].letra == baraja[y-1].letra) && (baraja[x-1].numero == baraja[y-1].numero)){

            int puntaje = player[jugadorTurno].getPuntaje();
            
            System.out.println();
            System.out.println();
            historialJugadas += "Jugador #" +(jugadorTurno+1);
            historialJugadas += "\nCarta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n";
            historialJugadas += "Carta 2: "+baraja[y-1].letra+","+baraja[y-1].numero+"\n";

            historialJugadas += "Puntos: "+ (baraja[x-1].numero + baraja[y-1].numero);
            
            //historialGanadas = historialGanadas + "Carta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n"
            historialGanadas += "Jugador #" +(jugadorTurno+1);
            historialGanadas += "\nCarta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n";
            historialGanadas += "Carta 2: "+baraja[y-1].letra+","+baraja[y-1].numero+"\n";
            
            
            historialGanadas += "Puntos: "+ (baraja[x-1].numero + baraja[y-1].numero);
            
            
            imprimirComodin();
            int comodinEsp = Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion de la carta comodin"));

            if(comodin[comodinEsp-1].getMultiplicador() == "Duplicado"){
                player[jugadorTurno].setPuntaje(puntaje + ((baraja[x-1].numero + baraja[y-1].numero)*2));   
                
            } else if(comodin[comodinEsp-1].getMultiplicador() == "Cuadruplicado"){
                player[jugadorTurno].setPuntaje(puntaje + ((baraja[x-1].numero + baraja[y-1].numero)*4));
            }
            
            baraja[x-1] = null;
            baraja[y-1] = null;
            
            System.out.println("Jugador #" +(jugadorTurno+1) +" puntos: "+ player[jugadorTurno].getPuntaje());

        } else{
            System.out.println();
            System.out.println();
            historialJugadas += "Jugador #" +(jugadorTurno+1);
            historialJugadas += "\nCarta 1: "+baraja[x-1].letra+","+baraja[x-1].numero+"\n";
            historialJugadas += "Carta 2: "+baraja[y-1].letra+","+baraja[y-1].numero+"\n";

            historialJugadas += "Puntos: "+ (baraja[x-1].numero + baraja[y-1].numero);
            
            System.out.println("Jugador #" +(jugadorTurno+1) +" puntos: "+ player[jugadorTurno].getPuntaje());
            validarTurno();
        }
    }

    /**
     * Lleva el control de los turnos entre los jugadores.
     */
    public static void validarTurno(){
        if(jugadorTurno < player.length-1){
            jugadorTurno++;
        } else {
            jugadorTurno = 0;
        }
    }

    
    /**
     * Establece la cantidad de jugadores en partida.
     */
    public static void pedirCantidadJugadores(){
        int cantidadJugadores = Integer.parseInt(JOptionPane.showInputDialog("Digite cantidad de jugadores en partida"));
        player = new Jugador[cantidadJugadores];
        for(int i=0; i<player.length; i++){
            String nombre = JOptionPane.showInputDialog("Digite el nombre del jugador "+(i+1));
            Jugador j = new Jugador(nombre, 0);

            player[i] = j; 
        }
    }

    /**
     * Ejecuta el programa.
     */
    public static void main(String args[]){
        cargarComodin();
        pedirCantidadJugadores();
        pedirNumeroCarta();
    }
}
