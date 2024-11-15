public class ejercicio5 {
    public static void main(String[] args) {
        ejercicio4.main(null);
        float media=0;
        int suma=0;
        
        for (int i=0; i<vector.length; i++){
            suma = vector[i].getRadio();
        }

        media=(float)suma/vector.length;
        System.out.println("El radio medio es "+media);
    }
}
