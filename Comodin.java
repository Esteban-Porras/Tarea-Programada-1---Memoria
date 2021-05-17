
/**
 * Genera los valores bases de cada carta comodín.
 * 
 * @author Esteban Porras Herrera C06044
 * @version 16/6/2021
 */
public class Comodin
{
    String multiplicador;

    /**
     * Constructor secundario de la clase Comodin.
     */
    public Comodin(){

    }

    /**
     * Constructor principal de la clase Comodin.
     * 
     * @param multiplicador inicializa el atributo multiplicador.
     */
    public Comodin(String multiplicador){
        this.multiplicador =  multiplicador;
    }
    
    /**
     * Establece el valor del atributo multiplicador.
     * 
     * @param l asigna el valor del multiplicador de la clase Comodín.
     */
    public void setMultiplicador(String l){
        multiplicador = l;
    }

    /**
     * @return Retorna el valor del atributo multiplicador.
     */
    public String getMultiplicador(){
        return multiplicador;
    }
    
    /**
     * @return  Entrega los datos de la carta comodín.
     */ 
    public String darComodin(){
        return multiplicador;
    }
}
