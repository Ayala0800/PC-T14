/*
 Hacer un programa que devuelva la posición de inicio y de fin
de la secuencia de mayor tamaño.
 
*/
public class ejercicio26{
    public static final int MAX = 20;
    public static void main (String[]args){
        int [] enteros = {0,0,0,6,9,0,4,1,4,5,0,3,2,2,0,0,0,45,45,0};
        int inicio = 0; int fin = 0;int tamanio = 0; int mayorTamanio = 0;
        int mayorInicio = 0, mayorFin = 0;
        
        while(inicio < MAX){
            inicio = obtener_inicio_secuencia_desde(enteros, inicio);
            fin = obtener_fin_secuencia(enteros, inicio);
            tamanio = obtener_tamanio_secuencia(enteros, inicio, fin);
            if(tamanio > mayorTamanio){
                mayorTamanio = tamanio;
                mayorInicio = inicio;
                mayorFin = fin;
            }
            inicio = fin + 1;
        }
        
        System.out.println("Posición de inicio de la secuencia de mayor tamaño: "+mayorInicio);
        System.out.println("Posición de fin de la secuencia de mayor tamaño: "+mayorFin);
        UtilsArr.mostrarArreglo(enteros);

    }
    
    public static int obtener_inicio_secuencia_desde(int [] arreglo, int desde){
        int i = desde;
        while(i < MAX && arreglo[i] == 0){
            i++;
        }
        return i; //devuelvo la posicion del primer elmento de la secuencia.
    }
    
    public static int obtener_fin_secuencia(int [] arreglo, int inicio){
        while(inicio < MAX && arreglo[inicio] != 0){
            inicio++;
        }
        return inicio-1; //devuelvo la posicion del ultimo elemento de la secuencia.
    }
    
    public static int obtener_tamanio_secuencia(int [] arreglo, int inicio, int fin){
        int elementos = 0;
        for(int i = inicio; i <= fin; i++){
            elementos++;
        }
        return elementos;
    }
}