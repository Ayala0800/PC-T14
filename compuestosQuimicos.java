public class compuestosQuimicos {
    public static final int MAXC = 19;
    public static final int MAXF = 4;
    public static final char SEP = ' ';

    public static void main (String[]args){
        char [][] Q = {
            {' ','H','H','S',' ','S','O','O',' ','N','a','C','l',' ','N','a','C','l',' ','N','a','O','H',' '},
            {' ','C','a','O','H','O','H',' ','C','a','C','O','O','O',' ',' ',' ',' ',' '},
            {' ','N','a','N','O','O','O',' ','S','O','O',' ','H','H','S',' ',' ',' ',' '},
            {' ','M','g','O',' ','N','H','H','H',' ','N','a','H','C','O','O','O',' ',' '}
        };

        char [][] F = {
            {' ','N','a','C','l',' ','H','H','S',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ','S','O','O',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ','S','O','O',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ','S','O','O',' ','N','H','H','H',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
        };

        procesarCompuestos(Q, F);
    }

    public static void procesarCompuestos(char [][] Q, char [][] F){
        int diaConMasEliminaciones = -1;
        int maxEliminaciones = -1;
        int cantDeEliminaciones = 0;

        for(int fila = 0;fila < MAXF;fila++){
            cantDeEliminaciones = procesarDia(Q[fila],F[fila]);

            if(cantDeEliminaciones > maxEliminaciones){
                maxEliminaciones = cantDeEliminaciones; //el dia con mas  eliminaciones pasa a ser el día procesado.
                diaConMasEliminaciones = fila;
            }
        }
    }

    public static int procesarDia(char [] filaQ, char [] filaF){
        //esta función va a retornar cuantas eliminaciones se hicieron en el dia procesado.
        int iniQ = 0;
        int finQ = -1;
        int eliminacionesDelDia = 0;

        while(iniQ < MAXC){
            iniQ = buscarInicio(filaQ, finQ+1);
            if(iniQ < MAXC){
                finQ = buscarFin(filaQ, iniQ);
                int longitudSecuenciaQ = finQ - iniQ + 1;
                eliminacionesDelDia = revisarProduccion(filaQ, iniQ, finQ, filaF, longitudSecuenciaQ);
            }
        }

        return 1;
    }

    public static int revisarProduccion(char [] filaQ, int iniQ, int finQ, char [] filaF, int longitudSecuenciaQ){
        //debo buscar la secuencia q traigo de Q en F, si la encuentro, debo eliminarla de Q.
        if(secuenciaExisteEnF(filaQ, iniQ, finQ, filaF, longitudSecuenciaQ)){
            //eliminoSecuenciaEnQ(filaQ, iniQ, finQ);
            //corrimientoIzq(filaQ, iniQ, finQ);
        }
        
        return 0;
    }
//PENDIENTE:
    //*IMPLEMENTAR EL CORRIMIENTO A IZQUIERDA EN FILAQ PARA ELIMINAR LA SECUENCIA RECIBIDA (desde INIQ hasta FINQ).

   /* public static void eliminoSecuenciaEnQ(char [] filaQ, int iniQ, int finQ){
        while(iniQ <= finQ){
            corrimientoIzq(filaQ, iniQ);
        }
    }*/

   /* public static void corrimientoIzq(char[] filaQ, int pos) {
        for (int i = pos; i < MAXC - 1; i++)
            filaQ[i] = filaQ[i + 1];
    }*/

    public static boolean secuenciaExisteEnF(char [] filaQ, int iniQ, int finQ, char [] filaF, int longitudSecuenciaQ){
        int iniF = 0;
        int finF = -1;
        boolean existe = false;
        //recorro la fila de F, comparo cada secuencia con la que recibi x para parametro proveniente de Q.
        while(iniF < MAXC){
            iniF = buscarInicio(filaF, finF-1);
            if(iniF < MAXC){
                finF = buscarFin(filaF, finF);
                int longitudSecuenciaF = finF - iniF + 1;
                if(longitudSecuenciaF == longitudSecuenciaQ){
                    //si son misma longitud, compruebo que sean iguales.
                    existe = (sonIguales(filaQ, iniQ, finQ, filaF, iniF, finF, longitudSecuenciaF));
                }
            }
        }
        return existe;
    }

    public static boolean sonIguales(char [] filaQ, int iniQ, int finQ, char [] filaF, int iniF, int finF, int longitud){
        int contadorDeAvances = 0;
        boolean iguales = false;

        while(iniQ <= finQ && filaQ[iniQ] == filaF[iniF]){
            iniQ++;
            iniF++;
            contadorDeAvances++;
        }

        if(contadorDeAvances == longitud){
            iguales = true;
        }

        return iguales;
    }

    public static int buscarInicio(char [] fila, int pos){
        while (pos < MAXC && fila[pos] == SEP) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char [] fila, int pos){
        while(pos < MAXC && fila[pos] != SEP){
            pos++;
        }
        return pos-1;
    }

    /*    public static void corrimiento_izq(int [] arreglo, int posicion){
        for(int i=posicion;i<MAXC-1;i++){
            arreglo[i]=arreglo[i+1];
        }
     */
}