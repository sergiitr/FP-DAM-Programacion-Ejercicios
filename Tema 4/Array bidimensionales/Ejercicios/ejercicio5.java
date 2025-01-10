/**
 * Juego 3 en raya
 */
public class ejercicio5 {
    /**
     * Funcion para crear nuestras matrices con numeros random
     * @param filas
     * @param columnas
     * @return matriz
     */
    public static String[][] crearMatriz(int filas, int columnas) {
        String[][] matriz=new String[filas][columnas];
        for (int i=0;i<filas; i++) {
            for (int j=0;j<columnas;j++)
                matriz[i][j]="- ";
        }
        return matriz;
    }

    /**
     * Funcion para mostrar la matriz
     * @param matriz
     * @param filas
     * @param columnas
     */
    public static void mostrarMatriz(String[][] matriz, int filas, int columnas) {
        for (int i=0;i<filas; i++) {
            for (int j=0;j<columnas;j++) 
                System.out.print(matriz[i][j]+"\t");
            System.out.println("");
        }
    }

    public static void turnoHumano(String[][] matriz,int fil, int col) {
        String guion="- ";
        System.out.println("Turno Humano");
        int fila,columna;
        fila=(int)(Math.random()*3);
        columna=(int)(Math.random()*3);

        
        if ( matriz[fila][columna].equals(guion) ) {
            matriz[fila][columna] = "x ";
        }
        

        mostrarMatriz(matriz,fil,col);
        int contador=0;
        for (int i=0;i<fil; i++) {
            for (int j=0;j<col;j++) {
                if (matriz[i][j].equals(guion) ) {
                    contador++;
                }
            }
        }
        if(contador==0)
            finPartida();
        else
            turnoMaquina(matriz, fil, col);
    }

    public static void finPartida() {
        System.out.println("Fin partida");
    }
    public static void turnoMaquina(String[][] matriz,int fil, int col) {
        String guion="- ";
        System.out.println("Turno Maquina");
        int fila,columna;
        fila=(int)(Math.random()*3);
        columna=(int)(Math.random()*3);

        
        if ( matriz[fila][columna].equals(guion) ) {
            matriz[fila][columna] = "o ";
        }
        mostrarMatriz(matriz,fil,col);
        int contador=0;
        for (int i=0;i<fil; i++) {
            for (int j=0;j<col;j++) {
                if (matriz[i][j].equals(guion) ) {
                    contador++;
                }
            }
        }
        if(contador==0)
            finPartida();
        else
            turnoHumano(matriz, fil, col);
    }

    public static void main(String[] args) {
        final int FILAS=3;
        final int COLUMNAS=FILAS;
        
        String[][] matriz = new String[FILAS][COLUMNAS];

        matriz=crearMatriz(FILAS, COLUMNAS);

        turnoHumano(matriz,FILAS, COLUMNAS);
    }
}
