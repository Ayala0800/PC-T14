public class finalAgosto2025 {

    public static final int MAXF = 4;
    public static final int MAXC = 40;

    public static void main(String[] args) {
        char[][] V = {
            {'¡','E','n',' ','m','i',' ','c','l','a','s','e',' ','y','o',' ','p','r','o','g','r','a','m','o',',',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {'p','r','o','g','r','a','m','a','r',' ','e','s',' ','l','o',' ','q','u','e',' ','a','m','o','!',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {'S','i',' ','a','l','g','o',' ','f','a','l','l','a',' ','n','o',' ','r','e','c','l','a','m','o',',',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {'l','o',' ','d','e','p','u','r','o',' ','y',' ','r','e','p','r','o','g','r','a','m','o','.' ,' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
        };

        int N = 3; // cantidad de letras de la rima
        if (riman(V, N)) {
            System.out.println("Los versos riman con " + N + " caracteres.");
        } else {
            System.out.println("Los versos NO riman con " + N + " caracteres.");
        }
    }

    // Método principal que valida la rima
    public static boolean riman(char[][] V, int N) {
        // 1) Tomamos la última palabra de la primera fila como referencia
        int finRef = buscarUltimaLetra(V[0]);
        if (finRef == -1) return false; // no hay palabra
        int iniRef = buscarInicioPalabra(V[0], finRef);

        // Verificar que tenga al menos N letras
        if (finRef - iniRef + 1 < N) return false;

        // 2) Comparamos con las otras filas
        for (int f = 1; f < MAXF; f++) {
            int fin = buscarUltimaLetra(V[f]);
            if (fin == -1) return false;
            int ini = buscarInicioPalabra(V[f], fin);

            if (fin - ini + 1 < N) return false; // palabra demasiado corta

            // comparar de atrás hacia adelante
            for (int i = 0; i < N; i++) {
                if (V[0][finRef - i] != V[f][fin - i]) {
                    return false; // no coincide
                }
            }
        }
        return true;
    }

    // Busca la posición de la última letra de la fila
    public static int buscarUltimaLetra(char[] fila) {
        for (int i = MAXC - 1; i >= 0; i--) {
            if (esLetra(fila[i])) return i;
        }
        return -1;
    }

    // Busca el inicio de la palabra (antes del fin dado)
    public static int buscarInicioPalabra(char[] fila, int fin) {
        int i = fin;
        while (i >= 0 && esLetra(fila[i])) {
            i--;
        }
        return i + 1;
    }

    // chequeo de letra (solo alfabéticos)
    public static boolean esLetra(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}