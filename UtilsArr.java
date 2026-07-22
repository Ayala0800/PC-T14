public class UtilsArr {
    //Cargar arreglo de enteros por consola
    public static void cargarArreglo(int [] arr){
        for (int pos=0; pos < arr.length; pos++){
            System.out.println("ingrese un número para la posición "+pos+" :");
            arr[pos] = Utils.leerInt();
        }
    }
    
    /*PEDIR UN NUMERO*/
    public static int obtenerNumero(){
        int numero;
        System.out.println("ingrese el número que quiere buscar en el arreglo:");
        numero = Utils.leerInt();
        return numero;
    }
    
    //Obtener la posicion de un numero en el arreglo de enteros
    public static int obtenerPosicion(int [] arreglo, int numerobuscado){
        int pos = 0;
        while((pos < arreglo.length) && (arreglo[pos] != numerobuscado)){
            pos++;
        }
        return pos;
    }
    
    //Imprimir arreglo de enteros en consola
    public static void mostrarArreglo(int [] arrenteros){
        for (int pos = 0; pos < arrenteros.length; pos++){
            System.out.print("|"+arrenteros[pos]);
        }
        System.out.println("");
    }
    
        //Imprimir arreglo de caracteres en consola
    public static void mostrarArregloChar(char [] arrenchars){
        for (int pos = 0; pos < arrenchars.length; pos++){
            System.out.print("|"+arrenchars[pos]);
        }
        System.out.println("");
    }
    
    //Invertir el orden de los elementos del arreglo.
    public static void invertirArreglo(int [] arreglo){
        int j = arreglo.length-1;
        for(int i=0;i<(arreglo.length/2);i++){
            int aux=arreglo[j];
            arreglo[j]=arreglo[i];
            arreglo[i]=aux;
            j--;
        }
    }
}
