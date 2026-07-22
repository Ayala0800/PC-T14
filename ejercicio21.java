/*
   Hacer un programa que inserte un elemento en un arreglo
(ordenado decrecientemente) de tamaño MAX=10.  
   */
public class ejercicio21{
    public static final int MAX = 10;
    public static void main (String[]args){
        int [] numeros = {10, 9 ,8 ,7, 6, 5, 4, 3, 2, 1};
        int elemento = Utils.leerInt();
        
        System.out.println("original:");
        UtilsArr.mostrarArreglo(numeros);
        corrimientoDer(numeros, elemento);
        System.out.println("modificada: ");
        UtilsArr.mostrarArreglo(numeros);
        
    }
    
    public static void corrimientoDer(int[] numeros, int elementoNuevo){
        //realizo el corrimiento a derecha y una vez terminado agrego el elemnto nuevo:
        for(int i = MAX - 1; i > 0; i--){ //comienzo el corrimiento desde la ultima posición hasta que i > posAmodificar.
            numeros[i] = numeros[i-1];
        }
        numeros[0] = elementoNuevo;
    }
}