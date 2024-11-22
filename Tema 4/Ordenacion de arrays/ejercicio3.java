import java.util.Scanner;

public class ejercicio3 {
    //Metodo de Ordenamiento QuickSort
    public static void Quicksort(int numeros[], int izq, int der){
        /**
         * Este metodo recibe un arreglo de numero, y dos enteros que referencian el primer valor y el ultimo
         */
        //Se toma como pivote el primer valor
        int pivote = numeros[izq];
        
        //Se definen los dos lados y un auxiliar
        int i = izq; 
        int j = der; 
        int aux;
        
        while(i<j) {
            while (numeros[i] <= pivote && i < j) 
                i++;
            while (numeros[j] > pivote) 
                j--;   

            if (i<j) {                                     
                aux = numeros[i];                  
                numeros[i]= numeros[j];
                numeros[j]=aux;
            }
        }

        numeros[izq] = numeros[j]; 
        numeros[j] = pivote;

        if (izq < j-1)
            Quicksort(numeros,izq,j-1);

        if (j+1 < der)
            Quicksort(numeros,j+1,der);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vector = new int[10];
        final int N = vector.length;
        
        System.out.println("Introduce 10 notas:");
        for (int i=0; i<N; i++) {
            System.out.print("Nota "+(i+1)+":");
            vector[i] = sc.nextInt();
        }
        Quicksort(vector,0,(vector.length-1));
        System.out.print("Nuestro vector es: [");
        for (int i=0; i<N; i++)
            System.out.print(vector[i]+" ");
        System.out.println("]");
    }    
}
