/*
 * Hacer un programa que elimine los valores pares en un arreglo
 * de tamaño MAX=10.
 */
public class ejercicio22{
    public static final int MAX = 10;
    public static void main (String[]args){
        int [] numeros = {2, 2 ,2, 1, 6, 45, 11, 8, 2, 9};
        
        System.out.println("Arreglo Original:");
        UtilsArr.mostrarArreglo(numeros);
        
        eliminarPares(numeros);
        
        System.out.println("\nArreglo modificado:");
        UtilsArr.mostrarArreglo(numeros);
    }
    
    public static void eliminarPares(int [] numeros){
       int i = 0;
       while (i < MAX) {
           if (numeros[i] % 2 == 0){
               corrimientoIzq(numeros, i);
                // No incremento i porque quiero revisar el nuevo valor en esa posición
            } else {
                i++; // solo avanzo si no hubo eliminación
            }
        }
    }
    
    public static void corrimientoIzq(int[] enteros, int posAmodificar){
        //realizo primero el corrimiento a izquierda y una vez terminado agrego un 0 en la ultima posicion
        for(int i = posAmodificar; i < MAX-1; i++){ //comienzo el corrimiento desde el elmento q quiero eliminar hasta el final
            enteros[i] = enteros[i+1];
        }
        enteros[MAX-1] = -1;
    }
}