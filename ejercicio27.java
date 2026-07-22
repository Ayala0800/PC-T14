/*
    Hacer un programa que dado un número N ingresado por el
    usuario, elimine las secuencias de tamaño N de números distintos
    de cero.
 */

public class ejercicio27 {
    public static final int MAX = 20;
    public static void main (String[]args){
        int [] enteros = {0,0,0,6,9,0,4,1,4,5,0,3,2,2,0,0,0,45,45,0};
        int inicio = 0; int fin = 0;int tamanio = 0;

        System.out.println("Ingrese el tamaño de la secuencia a eliminar: ");
        int N = Utils.leerInt();

        while(inicio < MAX){
            inicio = obtener_inicio_secuencia_desde(enteros, inicio);
            fin = obtener_fin_secuencia(enteros, inicio);
            tamanio = obtener_tamanio_secuencia(enteros, inicio, fin);
            if(tamanio == N){
                eliminar_secuencia(enteros, inicio, fin);
            }
            inicio = fin + 1;
        }

        UtilsArr.mostrarArreglo(enteros);
    }
    public static int obtener_inicio_secuencia_desde(int [] arreglo, int desde){
        int i = desde;
        while(i < MAX && arreglo[i] == 0){
            i++;
        }
        return i; //devuelvo la posicion del primer elemento de la secuencia.
    }
    public static int obtener_fin_secuencia(int [] arreglo, int inicio){
        int i = inicio;
        while(i < MAX && arreglo[i] != 0){
            i++;
        }
        return i-1; //devuelvo la posicion del ultimo elemento de la secuencia.
    }
    public static int obtener_tamanio_secuencia(int [] arreglo, int inicio, int fin){
        return fin - inicio + 1;
    }
    public static void corrimientoIzq(int [] arreglo, int posAmodificar){
        for(int i = posAmodificar; i < MAX-1; i++){
            arreglo[i] = arreglo[i+1];
        }
        arreglo[MAX-1] = 0;
    }
    public static void eliminar_secuencia(int [] arreglo, int inicio, int fin){
        for(int i = inicio; i <= fin; i++){
            corrimientoIzq(arreglo, i);
        }
    }
}