import java.util.*;

/**
 * Genera los valores bases de cada carta.
 * 
 * @author Esteban Porras Herrera C06044
 * @version 15/5/2021
 */
public class Cartas2
{
    String letra;
    int numero;

    public Cartas2(){

    }

    /**
     * Constructor principal de la clase Cartas2
     * 
     * @param letra inicializa el atributo letra.
     * @param numero inicializa el atributo numero.
     */
    public Cartas2(String letra, int numero){
        this.letra =  letra;
        this.numero = numero;
    }

    
    /**
     * Establece el valor del atributo letra.
     * 
     * @param l asigna el valor de la letra de la carta.
     */
    public void setLetra(String l){
        letra = l;
    }

    /**
     * @return Retorna el valor del atributo letra.
     */
    public String getLetra(){
        return letra;
    }

    
    /**
     * Establece el valor del atributo numero;
     * 
     * @param n asigna el valor del numero de la carta.
     */
    public void setNumero(int n){
        numero = n;
    }

    /**
     * @return Retorna el valor del atributo numero.
     */
    public int getNumero(){
        return numero;
    }

    
    /**
     * @return  Entrega los datos de la carta
     */ 
    public String darCarta(){
        return letra+""+numero;
    }

    // public void mostrarCarta(){
    // Random r = new Random();
    // for(int i=0 ;i < letra.length; i++){
    // for(int j=0; j<numero.length; j++){

    // int let = r.nextInt(26);
    // int num = r.nextInt(10);
    // System.out.println("("+letra[let]+","+numero[num]+")");
    // }
    // }
    // }    


    // public static void main(String args[]){
    // Cartas2 c = new Cartas2();
    // int i = 0;
    // int j=0;
    // // c.mostrarCarta();
    // }
}