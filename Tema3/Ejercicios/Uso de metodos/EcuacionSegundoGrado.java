public class EcuacionSegundoGrado {
    public EcuacionSegundoGrado() {
        this.a = 1;
        this.b = 5;
        this.c = 5;
    }
    public EcuacionSegundoGrado(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }

    public double solucion1() {
        x1 =(-this.b+Math.sqrt(this.b*this.b-4*this.a*this.c))/(2*this.a);
        return x1;
    }
    public double solucion2() {
        x2 =(-this.b-Math.sqrt(this.b*this.b-4*this.a*this.c))/(2*this.a);
        return x2;
    }
    
    private double x1;
    private double x2;
    private int a;
    private int b;
    private int c;
}