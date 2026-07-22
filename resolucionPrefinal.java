public class resolucionPrefinal {
    final static int MAXF = 4;
    final static int MAXC = 39;
    final static int MAX = 5; // No es necesario

    public static void main(String[] args) {
        char[][] matrizM = {{'-', 'Y', 'o', ' ', 'm', 'o', 'd', 'u', 'l', 'a', 'r', 'i', 'z', 'o', ':', '-', '-', '-', '-', '-', '-', '-', '-', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', '/', '/', '/', '/', '/', '/', '/'},
                            {'¡', '¡', 'p', 'e', 'r', 'o', ' ', 's', 'i', ' ', 'n', 'o', ' ', 'l', 'o', ' ', 'h', 'a', 'g', 'o', ',', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '-', '-', '-', '-', '-', ' ', ' ', ' ', ' '},
                            {' ', 'e', 'l', ' ', 'c', 'a', 'o', 's', ' ', 'd', 'e', ' ', 'm', 'i', ' ', 'c', 'o', 'd', 'i', 'g', 'o', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'!', 'c', 'a', 'r', 'o', ' ', 'l', 'o', ' ', 'p', 'a', 'g', 'o', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
                           };

        char[] arrC = {'p','m','l','p','t'};
        
        encriptarMensaje(matrizM, arrC);
        mostrarMatriz(matrizM);
    }

    public static void encriptarMensaje(char[][] matrizM, char[] arrC) {
        int minimaCant = Integer.MAX_VALUE; // Podría ser MAXC
        int filaConMinimo = -1;
        int cantActual = 0;

        for (int fila = 0; fila < MAXF; fila++) {
            cantActual = encriptarRenglon(matrizM[fila], arrC);
            if (cantActual < minimaCant) {
                minimaCant = cantActual;
                filaConMinimo = fila;
            }
        }

        System.out.println("La fila con menor cantidad de palabras encriptadas fue: " + filaConMinimo);
    }

    public static int encriptarRenglon(char[] fila, char[] arrC) {
        int ini = 0;
        int fin = -1;
        int cantEncriptadas = 0; // Almacena la cantidad de vocales encriptadas
        int totalEncriptadas = 0; // Almacena el total de palabras encriptadas

        while (ini < MAXC) {
            ini = buscarInicio(fila, fin + 1);
            if (ini < MAXC) {
                fin = buscarFin(fila, ini);
                cantEncriptadas = encriptarPalabra(fila, ini, fin, arrC);
                if (cantEncriptadas > 0) {
                    totalEncriptadas++;
                    fin = fin + cantEncriptadas * 2;
                }
            }
        }

        return totalEncriptadas;
    }

    public static int buscarInicio(char[] arr, int pos) {
        while (pos < MAXC && esSeparador(arr[pos])) {
            pos++;
        }

        return pos;
    }

    public static int buscarFin(char[] arr, int pos) {
        while (pos < MAXC && !esSeparador(arr[pos])) {
            pos++;
        }

        return pos - 1;
    }

    // Si hacen un esLetra, hay que invertir la negación en el buscar inicio y fin
    public static boolean esSeparador(char c) {
        // Es separador si no es un caracter alfabetico
        return !('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z');
    }

    public static int encriptarPalabra(char[] fila, int ini, int fin, char[] arrC) {
        int contadorEncriptadas = 0;
        int indiceVocal = -1;
        while (ini <= fin) {
            indiceVocal = getIndiceVocal(fila[ini]);
            if (indiceVocal != -1) {// Si es vocal
                correrADerecha(fila, ini);
                correrADerecha(fila, ini);
                fila[ini + 1] = arrC[indiceVocal];
                ini += 3;
                fin += 2;
                contadorEncriptadas++;
            }
            else {
                ini++;
            }
        }

        return contadorEncriptadas;
    }

    public static int getIndiceVocal(char c) {
        int indice = -1;
        switch (c) {
            case 'a': case 'A':
                indice = 0;
                break;
            case 'e': case 'E':
                indice = 1;
                break;
            case 'i': case 'I':
                indice = 2;
                break;
            case 'o': case 'O':
                indice = 3;
                break;
            case 'u': case 'U':
                indice = 4;
                break;
        }
        return indice;
    }

    public static void correrADerecha(char[] arr, int pos) {
        for (int i = MAXC - 1; i > pos; i--)
            arr[i] = arr[i - 1];
    }

    public static void mostrarMatriz(char[][] mat) {
        for (int i = 0; i < MAXF; i++)
            mostrarArreglo(mat[i]);
    }
    
    public static void mostrarArreglo(char[] arr) {
        for (int i = 0; i < MAXC; i++) {
            System.out.print(" | " + arr[i]);
        }
        System.out.println();
    }

}