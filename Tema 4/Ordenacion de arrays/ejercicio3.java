public class ejercicio3 {
    private void quickSort(int numerosAOrdenar[], int izq, int der) {
        int pivote = numerosAOrdenar[izq]; 
        int i=izq;        
        int j=der;    
        int auxiliar;
		 
		while(i < j) {                                                    
		     while(numerosAOrdenar[i] <= pivote && i < j) i++; 
		     while(numerosAOrdenar[j] > pivote) j--;          
		     if (i < j) 
		     {                                         
		    	 auxiliar = numerosAOrdenar[i];                   
		    	 numerosAOrdenar[i] = numerosAOrdenar[j];
		    	 numerosAOrdenar[j] = auxiliar;
		     }
		}
		   
		  numerosAOrdenar[izq] = numerosAOrdenar[j];                                      
		  numerosAOrdenar[j] = pivote;     
		   
		   if(izq < j-1)
		   {
			   quickSort(numerosAOrdenar,izq,j-1);          
		   }
		   if(j+1 < der)
		   {
			   quickSort(numerosAOrdenar,j+1,der);          
		   } 
	}

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
    }    
}
