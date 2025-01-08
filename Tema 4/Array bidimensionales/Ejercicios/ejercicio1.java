/**
 * Matriz trapuesta
 */
public class ejercicio1 {
    /**
     * Funcion para crear nuestras matrices con numeros random
     * @param tamanio
     * @return matriz
     */
    public static int[][] crearMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        for (int i=0;i<filas; i++) {
            for (int j=0;j<columnas;j++)
                matriz[i][j] = (int)(Math.random()*10);
        }
        return matriz;
    }

    /**
     * Funcion para mostrar la matriz
     * @param matriz
     * @param tamanio
     */
    public static void mostrarMatriz(int[][] matriz, int filas, int columnas) {
        for (int i=0;i<filas; i++) {
            for (int j=0;j<columnas;j++) 
                System.out.print(matriz[i][j]+"\t");
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        final int FILA=3;
        final int COLUMNA=4;
        int[][] matriz1 = new int[FILA][COLUMNA];

        matriz1 = crearMatriz(FILA,COLUMNA);
    }
}
