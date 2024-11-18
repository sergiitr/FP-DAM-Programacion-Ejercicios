public class ejercicio6 {
    public static void main(String[] args) {
        int[] arrayPrimero = {3,6,1,8,9};
        int[] arraySegundo = {5,3,5,4,10,7,1};

        final int LONGITUD_COMBINADO = arrayPrimero.length + arraySegundo.length;
        int[] arrayCombinado = new int[LONGITUD_COMBINADO];

        /**
         * Posiciones pares del arrayCombinado (0,2,4,6) para el arrayPrimero
         */
        int j=0;
        for (int i=0; i<arrayPrimero.length;i++) {
            arrayCombinado[j] = arrayPrimero[i];
            j+=2;
        }

        /**
         * Posiciones impares del arrayCombinado (1,3,5,7) para el arraySegundo
         */
        int k=1;
        for (int i=0; i<arrayPrimero.length;i++) {
            arrayCombinado[k] = arraySegundo[i];
            k+=2;
        }

        /**
         * Como faltan asignar las posiciones arrayCombinado[10] y arrayCombinado[11]
         * que son las posiciones arraySegundo[5] y arraySegundo[5] las asignamos
         */
        for (int i=((arrayPrimero.length*2));i<arrayCombinado.length;i++){
            arrayCombinado[i]=arraySegundo[i-5];
        }


        System.out.print("arrayCombinado[");
        for (int i=0;i<LONGITUD_COMBINADO;i++)
            System.out.print(arrayCombinado[i]+" ");
        System.out.println("]");
    }
}