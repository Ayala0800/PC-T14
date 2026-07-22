public class prefinal2025{

    public static final int MAXC = 39;
    public static final int MAXF = 4;
    public static final int MAX = 5;
    public static void main (String[]args){

        char [][] texto = {
            {'-','Y','o',' ','m','o','d','u','l','a','r','i','z','o',':','-','-','-','-','-','-','-','-',' ',' ',' ',' ',' ',' ',' ',' ','/','/','/','/','/','/','/','/'},
            {'¡','¡','p','e','r','o',' ','s','i',' ','n','o',' ','l','o',' ','h','a','g','o',',',' ',' ',' ',' ',' ',' ',' ',' ',' ','-','-','-','-','-',' ',' ',' ',' '},
            {' ','e','l',' ','c','a','o','s',' ','d','e',' ','m','i',' ','c','o','d','i','g','o','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
            {'¡','c','a','r','o',' ','l','o',' ','p','a','g','o','!','!','!','!','!','!','!','!','!','!','!','!','!','!','!',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
            };
        char [] arrC = {'p','m','l','p','t'}; //remplazo de vocales.


        procesarMatriz(texto, arrC);
        mostrarMatriz(texto);

    }

    public static void procesarMatriz(char [][] matriz, char [] arrC){
        int menorCantidad = 1000;
        int filamenor = -1;
        for(int fila = 0;fila < MAXF;fila++){
            int nro_encriptaciones = procesarFila(matriz[fila], arrC);
            if(nro_encriptaciones < menorCantidad){
                menorCantidad = nro_encriptaciones;
                filamenor = fila;
            }
        }

        System.out.println("La fila con menor cantidad de palabras encriptadas fue: "+filamenor);
    }

    public static int procesarFila(char [] fila, char [] arrC){

        int inicio = 0;
        int fin = -1;
        int contador = 0;

        while(inicio < MAXC){
            inicio = obtener_inicio_secuencia_desde(fila, fin+1);
            if (inicio < MAXC) {
                fin = obtener_fin_secuencia(fila, inicio);
                //aca en secuencia
                procesarSecuencia(fila, inicio, fin, arrC);
                contador++;
            }
        }

        return contador;
    }

    public static void procesarSecuencia(char [] fila, int inicio, int fin, char [] arrC){

        while(inicio < fin){
            if(esVocal(fila[inicio])){
                int id_vocal = indentificarVocal(fila[inicio]); //retorna la posición del elemento en el arrC segun la vocal recibida.
                corrimientoDer(fila, inicio+1, fila[inicio]);//duplico la vocal
                corrimientoDer(fila, inicio+1, fila[inicio]);//duplico la vocal
                fila[inicio+1] = arrC[id_vocal]; //piso la primera duplicacion
                //corrimientoDer(fila, inicio, arrC[id_vocal]);//piso la primera duplicacion
                fin+=2;
                inicio+=3;
            }else{ 
                inicio++;
            }
        }

    }

    public static boolean esVocal(char elemento){
        if(elemento == 'a'||elemento == 'A'||elemento == 'e'||elemento == 'E'
        ||elemento == 'i'||elemento == 'I'||elemento == 'o'||elemento == 'O'||elemento == 'u'||elemento == 'U'){
            return true;
        }else{
            return false;
        }
    }

    public static int indentificarVocal(char elemento){
        if(elemento == 'a'||elemento == 'A'){
            return 0;
        }
        if(elemento == 'e'||elemento == 'E'){
            return 1;
        }
        if(elemento == 'i'||elemento == 'I'){
            return 2;
        }
        if(elemento == 'o'||elemento == 'O'){
            return 3;
        }
        if(elemento == 'u'||elemento == 'U'){
            return 4;
        }
        return -1;
    }

    public static int obtener_inicio_secuencia_desde(char [] arreglo, int desde){
        int i = desde;
        while(i < MAXC && !esElementoValido(arreglo[i])){
            i++;
        }
        return i; //devuelvo la posicion del primer elemento de la secuencia.
    }
    public static int obtener_fin_secuencia(char [] arreglo, int inicio){
        int i = inicio;
        while(i < MAXC && esElementoValido(arreglo[i])){
            i++;
        }
        return i-1; //devuelvo la posicion del ultimo elemento de la secuencia.
    }

    public static boolean esElementoValido(char elemento){
        if(elemento >= 'A' && elemento <= 'Z' || elemento >= 'a' && elemento <= 'z'){
            return true;
        }else{
            return false;
        }
    }

    public static void corrimientoDer(char[] fila, int ini, char elemento){
        int posAmodificar = ini;
        //realizo el corrimiento a derecha y una vez terminado agrego el elemnto nuevo:
        for(int i = MAXC - 1; i > posAmodificar; i--){ //comienzo el corrimiento desde la ultima posición hasta que i > posAmodificar.
            fila[i] = fila[i-1];
        }
        fila[posAmodificar] = elemento;
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