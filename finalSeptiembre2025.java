public class finalSeptiembre2025 {
    
    public static final int MAXC = 29;
    public static final int MAXF = 4;
    public static final int N = 2;

    public static void main(String[] args) {
        
        char [][] matriz = {
                    {'¡','E','s',' ','i','m','p','o','r','t','a','n','t','e',' ','r','e','c','o','n','o','c','e','r',' ',' ',' ',' ',' '},
                    {' ','l','o','s',' ','e','s','c','r','i','t','o','s',' ','d','e',' ','a','n','a',',',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ','p','o','r','q','u','e',' ',' ','h','a','b','l','a','n',' ','s','o','b','r','e',' ','u','n',' ','o','s','o',' '},
                    {' ',' ','q','u','e',' ','n','o',' ','a','p','a','r','e','c','e',' ','e','n',' ','e','l',' ','n','u','d','o','!','!'}
                    };

        if(validarMatriz(matriz)){
            System.out.println("SI Existen almenos "+N+" renglones consecutivos palindromos");
        }else{
            System.out.println("NO Existen almenos "+N+" renglones consecutivos palindromos");
        }
    }

    public static boolean validarMatriz(char [][] matriz) {
        int contador = 0;

        for(int fila = 0; fila < MAXF; fila++){
            if(renglonTerminaEnPalindromo(matriz[fila])){
                contador++;
            }else{
                contador = 0;
            }

            if(contador == N){
                return true;
            }
        }

        return false;
    }

    public static boolean renglonTerminaEnPalindromo(char [] fila){
        int ultimoFin = obtener_fin_ultima_sec(fila, MAXC - 1);

        if(ultimoFin < MAXC){
            int ultimoInicio = obtener_inicio_ultima_sec(fila, ultimoFin);

            if(!esPalindromo(fila, ultimoInicio, ultimoFin)){
                return false;
            }
        }
        return true;
    }

    public static boolean esPalindromo(char [] arreglo, int inicio, int fin){
        int i = inicio;
        int j = fin;
        while (i < j) {
            if (arreglo[i] != arreglo[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int obtener_fin_ultima_sec(char [] arreglo, int desde){

        int i = desde;

        while(i >= 0 && !esLetra(arreglo[i])){
            i--;
        }

        return i;
    }

    public static int obtener_inicio_ultima_sec(char [] arreglo, int desde){

        int i = desde;

        while(i >= 0 && esLetra(arreglo[i])){
            i--;
        }

        return i+1;
    }

    public static boolean esLetra(char elemento){
        return (elemento >= 'a' && elemento <= 'z') || (elemento >= 'A' && elemento <= 'Z');
    }
}