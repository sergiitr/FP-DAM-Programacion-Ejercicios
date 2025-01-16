import java.util.Scanner;

public class ejercicio1 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;

        System.out.print("Introduzca la frase: ");
        frase=sc.nextLine();

        frase=frase.toLowerCase();
        
        char[] cadena = new char[frase.length()];
        int[] cadena2 = new int[frase.length()];
        for (int i=0; i<frase.length();i++) {
            for (int j=0; j<cadena.length;j++) {
                if (frase.charAt(i)==cadena[j]) {
                    cadena2[j]+=1;
                } else if (cadena[j] !='\u0000'){
                    cadena[j]=frase.charAt(i);
                    cadena2[j]+=1;
                } else {
                    System.out.println(cadena[i]);
                }
            }
        }
        
        for (int i=0; i<frase.length(); i++){
            System.out.println(i+" "+cadena[i]+" "+cadena2[i]);
        }
    }
}