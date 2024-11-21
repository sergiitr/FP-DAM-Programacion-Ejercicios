import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vectorNotas = new int[10];
        final int N = vectorNotas.length;
        
        System.out.println("Introduce 10 notas:");
        for (int i=0; i<N; i++) {
            System.out.print("Nota "+(i+1)+":");
            vectorNotas[i] = sc.nextInt();
        }
        System.out.print("Nuestro vector es: [");
        for (int i=0; i<N; i++)
            System.out.print(vectorNotas[i]+" ");
        System.out.println("]");

        int aux=0;
        for (int i = 0; i < N-1; i++) 
            for (int j = 0; j < N-i-1; j++) 
                if(vectorNotas[j] > vectorNotas[j+1]){
                    aux=vectorNotas[j];
                    vectorNotas[j]=vectorNotas[j+1];
                    vectorNotas[j+1]=aux;
                }
        
        System.out.print("Nuestro vector ordenado de menor a mayor es: [");
        for (int i=0; i<N; i++)
            System.out.print(vectorNotas[i]+" ");
        System.out.println("]");
    }
}
