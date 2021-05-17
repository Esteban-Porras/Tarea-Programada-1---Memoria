
/**
 * Genera los valores bases de cada jugador.
 * 
 * @author Esteban Porras Herrera C06044
 * @version 16/6/2021
 */
public class Jugador
{
    String nombre;
    int puntaje;

    /**
     * Constructor secundario de la clase Jugador.
     */
    public Jugador(){
    }
    
    /**
     * Constructor principal de la clase Jugador
     * 
     * @param nombre inicializa el atributo nombre.
     * @param puntaje inicializa el atributo puntaje.
     */
    public Jugador(String nombre, int puntaje){
        this.nombre =  nombre;
        this.puntaje = puntaje;
    }

    
    /**
     * Establece el valor del atributo nombre.
     * 
     * @param l asigna el nombre del jugador.
     */
    public void setNombre(String l){
        nombre = l;
    }

    /**
     * @return Retorna el valor del atributo nombre.
     */
    public String getNombre(){
        return nombre;
    }

    
    /**
     * Establece el valor del atributo puntaje.
     * 
     * @param n asigna el valor del puntaje de cada jugador.
     */
    public void setPuntaje(int n){
        puntaje = n;
    }

    /**
     * @return Retorna el valor del atributo puntaje.
     */
    public int getPuntaje(){
        return puntaje;
    }

    
    /**
     * @return  Entrega los datos del jugador.
     */ 
    public String darJugador(){
        return nombre+""+puntaje;
    }
}
