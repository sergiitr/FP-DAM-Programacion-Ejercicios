package Recursividad;

import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;

        System.out.println("Introduzca el valor de A:");
        a=sc.nextInt();
        System.out.println("Introduzca el valor de b:");
        b=sc.nextInt();

        System.out.println("El mcd("+a+","+b+")="+mcd(a,b));
    }

    public static int mcd(int x, int y) {
        if (x==0)
            return y;
        else if(y==0)
            return x;
        else if(x>=y)
            return mcd(x-y,y);
        else
            return mcd(x,y-x);
    }
}
