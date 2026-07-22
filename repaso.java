public class repaso {

    /*  m.length          → cantidad de filas
        m[0].length       → cantidad de columnas (arranca desde uno, como un conteno normal)
        m[i][j]
        
        i = fila
        j = columna
  */

    public static final int MAX = 5;
    public static final int MAXF = 5;
    public static final int MAXC = 5;
    public static void main (String[]args){
        int [] arreglo1 = new int [4]; //array de dimension 4
        int [] arreglo2 = {32,732,357,27,7}; // x extensión
        int contador = 0;
        int [][] matriz1 = new int [MAXF][MAXC]; //filas * columnas



        for(int i = 0; i<MAX;i++){
            System.out.println(arreglo2[i]);
            if(arreglo2[i] % 2 == 0){
                contador++;
            }
        }

        for(int i = 0;i<MAXF;i++){
            for(int j = 0; j<MAXC;j++){
                System.out.print("Ingrese un valor para la posición "+i+","+j+" :");
                matriz1[i][j] = Utils.leerInt();
            }
        }

        System.out.println("matriz.length: "+matriz1.length);

        mostrarMatriz(matriz1);

        System.out.println("cantidad de pares en el arreglo2: "+contador);
        System.out.println("length: "+arreglo2.length);
    }

    public static void mostrarMatriz(int[][]matriz) {
            for (int i = 0; i < MAXF; i++)
            mostrarArreglo(matriz[i]);
        }
    
        public static void mostrarArreglo(int[] arr) {
            for (int i = 0; i < MAXC; i++) {
                System.out.print(" | " + arr[i]);
            }
            System.out.println();
        }
}
