public class ejercicio3tipoprefi {

    /*
     * El servicio de inteligencia secreto MD5 desea implementar un sistema de encriptación de documentos
        ultrasecretos. Dichos documentos son almacenados en matrices de caracteres en donde cada fila representa
        un renglón del mismo. Todos los renglones tienen M caracteres y comienzan y terminan con uno o más
        espacios.
        Se desea principalmente encriptar los nombres propios (comienzan con mayúscula) que aparezcan en el
        documento, ya que seguramente harán referencia a información sensible como ciudades, espías propios o
        agentes enemigos. El mecanismo de encriptación consiste en realizar una simple inversión de los caracteres
        y la duplicación de las vocales minúsculas sólo de los nombres propios (secuencias) presentes en el
        documento. Se pide (a) implementar el mecanismo de encriptación antes descrito sobre una matriz de NxM e
        (b) informar, al finalizar la ejecución del mismo, la cantidad de secuencias encriptadas.
     */

     /*
      1- por cada fila de la matriz: buscar inicio y fin de secuencia.
      2- si el primer elemento de la secuencia cumple con la condicion (comenzar con mayuscula"esMayuscula""), entonces procesar:
        3- invertir orden de la secuencia.
        4- recorrer nuevamente cada elemento de la secuencia y si el elemento cumple la codición (ser vocal minuscula "esVocal"), duplicar elemento (corrimientoDer)
        5- si la secuencia tuvo q ser procesada, contador++.
      */

    public static final int MAXC = 16;
    public static final int MAXF = 4;
    public static final char SEPARADOR = ' ';

    public static void main(String[] args) {

        char [][] matM = {
                        {' ','e','l',' ','a','g','e','n','t','e',' ',' ',' ',' ',' ',' '},
                        {' ','J','a','m','e','s',' ','B','o',' ','s','e',' ',' ',' ',' '},
                        {' ','e','n','c','u','e','n','t','r','a',' ','e','n',' ',' ',' '},
                        {' ','C','o','l','o','n','i','a',' ',' ',' ',' ',' ',' ',' ',' '}
                        };


        System.out.println("Matriz Original: ");
        mostrarMatriz(matM);
        System.out.println("\nCantidada de Secuencias encriptadas: "+ nombrePropiosEncriptados(matM));
        System.out.println("\nMatriz encriptada: ");
        mostrarMatriz(matM);
    }

    public static int nombrePropiosEncriptados(char [][] matM){

        int cantSecEncriptadas = 0;

        for(int fila = 0; fila < MAXF; fila++){
            cantSecEncriptadas += procesarRenglon(matM[fila]);
        }
        return cantSecEncriptadas;
    }

    public static int procesarRenglon(char [] renglon){
        int inicio = 0;
        int fin = -1;
        int contador = 0;

        while(inicio < MAXC){
            inicio = inicio_secuencia(renglon, fin+1);
            if(inicio < MAXC){
                fin = fin_secuencia(renglon, inicio);
                //aca estoy en una sec.
                if(esMayuscula(renglon[inicio])){
                    encriptarPalabra(renglon, inicio, fin); //procesar sec
                    contador++;
                }
            }
        }
        return contador;
    }

    public static boolean esMayuscula(char elemento){
        if(elemento >= 'A' && elemento <= 'Z'){
            return true;
        }
        return false;
    }

    public static void encriptarPalabra(char [] renglon, int inicio, int fin){
        invertirSecuencia(renglon, inicio, fin);
        while(inicio <= fin){
            if(esVocal(renglon[inicio])){
                corrimientoDerecha(renglon, inicio);
                fin++;
                inicio += 2;  // saltamos la copia recién insertada
            }else{
                inicio++;
            }
        }
    }

    public static void invertirSecuencia(char [] renglon, int inicio, int fin){
        //Invertir el orden de los elementos del arreglo.
        while(inicio < fin){
            char temp = renglon[inicio];
            renglon[inicio] = renglon[fin];
            renglon[fin] = temp;
            inicio++;
            fin--;
        }
    }
    public static boolean esVocal(char elemento){
        if(elemento == 'a' || elemento == 'e'|| elemento == 'i'|| elemento == 'o'|| elemento == 'u'){
            return true;
        }
        return false;
    }
    public static void corrimientoDerecha(char[] arr, int ini) {
        for (int pos = MAXC - 1; pos > ini; pos--)
        arr[pos] = arr[pos - 1];
    }
    public static int inicio_secuencia(char [] arreglo, int desde){
        int i = desde;
        while(i < MAXC && arreglo[i] == SEPARADOR){
            i++;
        }
        return i; //devuelvo la posicion del primer elemento de la secuencia.
    }
    public static int fin_secuencia(char [] arreglo, int inicio){
        int i = inicio;
        while(i < MAXC && arreglo[i] != SEPARADOR){
            i++;
        }
        return i-1; //devuelvo la posicion del ultimo elemento de la secuencia.
    }
    public static void mostrarMatriz(char [][] matriz){
        for(int f = 0;f<MAXF;f++){
            for(int c = 0; c<MAXC;c++){
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println("");
        }
    }
}