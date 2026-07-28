public class repaso_v2{

    public static final int MAX_T = 2;

    public static void main (String[]args){
        int [][]matrizM = {{-2,-2,14,22,55,66,-2,3,-2,-5,2,8,44,67,90,-5,-1,9,12,15,46,48,78,-8,-9,-6,-8},
                      {-5,-1,2,5,8,49,-7,4,14,35,86,89,-1,2,9,24,46,88,90,-3,47,50,55,63,-3,-4,-1},
                      {-2,12,16,25,28,37,39,88,-9,24,38,49,65,72,103,-3,-3,7,8,56,62,77,88,-2,-2,-7,-9}};
        int [] R = {-1,-1,-1};
        int [] T = {46,100};


        procesarSelecciones(matrizM, R, T);
    }

    public static void procesarSelecciones(int [][] matriz, int [] R, int [] T){ /*procesar fila*/

        int vecesQueAumentoFilaActual = 0;
        int vecesQueAumentoFilaAnterior = 0;
        int filaQueMasAumentosTuvo = -1;

        for(int fila = 0; fila<matriz.length;fila++){ //recorro fila x fila
            vecesQueAumentoFilaActual = procesarSeleccion(matriz[fila], R, T, fila);

            if(vecesQueAumentoFilaActual != 0){
                if (vecesQueAumentoFilaActual > vecesQueAumentoFilaAnterior) {
                    filaQueMasAumentosTuvo = fila;
                    vecesQueAumentoFilaAnterior = vecesQueAumentoFilaActual;
                }
            }
        }

        imprimirR(R);

        if(filaQueMasAumentosTuvo == -1){
            System.out.println("No hubo ninguna selección que haya cumplido la condición");
        }else{
            System.out.println("La seleccion que mas veces aumento fue la nro:  "+filaQueMasAumentosTuvo);
        }
        
    }
    //probando git

    public static int procesarSeleccion(int [] fila, int [] R, int [] T, int nro_de_fila){
        int inicio = 0;
        int fin = -1;
        int cantGolesPartidoActual = 0;
        int cantGolesPartidoAnterior = 0;
        int cantDeAumentos = 0; //veces que hubo aumentos en la fila procesada
        int cantDePartidos = 0; //cantidad de secuencias que tiene la fila procesada

        while(inicio < fila.length){ //comienzo a buscar el inicio de la proxima secuencia
            inicio = buscarInicio(fila, fin+1);

            if(inicio < fila.length){
                fin = buscarFin(fila, inicio);

                cantGolesPartidoActual = procesarPartido(fila, inicio, fin, T);
                cantDePartidos++;//cuenta los partidos procesados.

                    if(cantDePartidos == 1){ //si es el 1er partido
                        cantGolesPartidoAnterior = cantGolesPartidoActual;
                    }else{ //si es el 2do. partido u otro
                        if(cantGolesPartidoActual > cantGolesPartidoAnterior){
                            cantGolesPartidoAnterior = cantGolesPartidoActual;
                            cantDeAumentos++;
                        }else{
                            cantGolesPartidoAnterior = cantGolesPartidoActual;
                        }
                    }
            }
        }

        if(cantDePartidos > 1 && cantDeAumentos == cantDePartidos-1){ //debo asegurar de que halla habido al menos 2 partidos.
            insertarSeleccionEnR(nro_de_fila, R);
            return cantDeAumentos;
        }else{
            return 0; //retorno 0, si alguna vez no se produjo un aumento en goles en parametro o la cantidad de partidos no fue mayor a 1.
        }             //de esta forma diferencio las selecciones que cumplieron o no las condición, para luego comparar cual fue la que mas veces aumento.
    }

    public static int procesarPartido(int [] fila, int inicio, int fin, int [] T){
        int indice = inicio;
        int cantGoles = 0;

        while(indice <= fin){ //recorro la secuencia (partido) y obtengo cant de goles en parametro.
            if(golEnParametro(fila[indice], T)){ //gol dentro del parametro 46 a 100?
                cantGoles++;
            }
            indice++;
        }

        return cantGoles;
    }

    public static void insertarSeleccionEnR(int nro_fila, int [] R){
        boolean insertado = false;
        int i = 0;

        while (i < R.length && !insertado) {
            if (R[i] == -1) {
                R[i] = nro_fila;
                insertado = true; //una vez que inserto, insertado cambia y deja de cumplirse el while, por lo tanto, corta.
            } else {
                i++;
            }
        }
    }

    public static boolean golEnParametro(int gol, int [] T){
        if(gol >= T[0] && gol <= T[1])return true;
        return false;
    }
    public static int buscarInicio(int [] fila, int pos){
        while (pos < fila.length && esSeparador(fila[pos])) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int [] fila, int pos){
        while(pos < fila.length && !esSeparador(fila[pos])){
            pos++;
        }
        return pos-1;
    }

    public static boolean esSeparador(int pos){
        if(pos < 0) return true;
        return false;
    }

    public static void imprimirR (int [] arregloR){
        for (int pos = 0; pos < arregloR.length; pos++){
            System.out.print("|"+arregloR[pos]);
        }
        System.out.println("");
    }













































    /*public static void main(String[] args){
        int [] arreglo_enteros = new int [5]; //declaracion de un arreglo de 5 enteros.

        int longitud_del_arreglo = arreglo_enteros.length;

        System.out.println("La longitud del arreglo es: " + longitud_del_arreglo);

        cargar_arreglo(arreglo_enteros);
        mostrar_arreglo(arreglo_enteros);
    }

    public static void cargar_arreglo(int [] arreglo){
        for(int indice = 0;indice < arreglo.length;indice++){
            System.out.println("Indique un valor para la posición |"+indice+"| en el arreglo:");
            arreglo[indice] = Utils.leerInt();
        }
    }

    public static void mostrar_arreglo(int [] arreglo){
        System.out.println("ARREGLO:");
        for(int indice = 0;indice < arreglo.length;indice++){
            System.out.print(arreglo[indice]+"|");
        }
    }
    */
}