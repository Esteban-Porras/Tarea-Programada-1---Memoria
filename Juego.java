import java.util.*;
import javax.swing.*;

/**
 * @author Esteban Porras Herrera
 * @version 6/5/2021
 */
public class Juego
{
    Cartas c[][];
    int desplazamiento;
    
    ///
    int matrizEjemplo[][] = { {0,0,0} , {1,1,1} , {2,2,2} }; //matriz de enteros para ejemplo

    
    public Juego(int m, int n){
        c = new Cartas[m][n];
        desplazamiento = 0;
        
        ///
        mostrarMatriz(matrizEjemplo);
    }
    
    public void llenarMatriz(int m, int n){
        for(int i = 0; i<m; ++i){ //recorre las filas de la matriz
            for (int j = 0; j<n; ++j){ //recorre las columnas de la matriz
                //c[i][j] = ; //da un valor a cada entrada de la matriz. Utilizar un objeto carta
            }
        }
    }
    
    ///
        public void mostrarMatriz(int c[][]){
            int m = 3; //tamaño de filas, hay otra forma de ponerlo
            int n = 3; //tamaño de columnas, hay otra forma de ponerlo
        for(int i = 0; i < m; ++i){ //recorre las filas de la matriz
            for (int j = 0; j<n; ++j){ //recorre las columnas de la matriz
                System.out.print(c[i][j] + "\t"); //da un valor a cada entrada de la matriz. Utilizar un objeto carta
            }
            System.out.print("\n"); //salta de línea al recorrer la columna
        }
    }
}
