public class RegEx {
    private int numerosDNI;
    private String letraDNI;
    String DNI;
    private String letrasPasaporte;
    private int numerosPasaporte;
    //String Pasaporte;

    /**
     * Constructor DNI
     */
    public RegEx(int numerosDNI) {
        if (String.valueOf(numerosDNI).length()==8)
            this.numerosDNI = numerosDNI;
        else
            this.numerosDNI=11111111;
    }
    /**
     * Getter y setter Numero DNI
     */
    public int getNumerosDNI() {
        return numerosDNI;
    }
    public void setNumerosDNI(int numerosDNI) {
        if(String.valueOf(numerosDNI).length()==8)
            this.numerosDNI = numerosDNI;
    }

    /**
     * Getter y setter Letra DNI
     */
    public String getLetraDNI() {
        switch(numerosDNI%23) {
            case 0:
                letraDNI="T";
                break;
            case 1:
                letraDNI="R";
                break;
            case 2:
                letraDNI="W";
                break;
            case 3:
                letraDNI="A";
                break;
            case 4:
                letraDNI="G";
                break;
            case 5:
                letraDNI="M";
                break;
            case 6:
                letraDNI="Y";
                break;
            case 7:
                letraDNI="F";
                break;
            case 8:
                letraDNI="P";
                break;
            case 9:
                letraDNI="D";
                break;
            case 10:
                letraDNI="X";
                break;
            case 11:
                letraDNI="B";
                break;
            case 12:
                letraDNI="N";
                break;
            case 13:
                letraDNI="J";
                break;
            case 14:
                letraDNI="Z";
                break;
            case 15:
                letraDNI="S";
                break;
            case 16:
                letraDNI="Q";
                break;
            case 17:
                letraDNI="V";
                break;
            case 18:
                letraDNI="H";
                break;
            case 19:
                letraDNI="L";
                break;
            case 20:
                letraDNI="C";
                break;
            case 21:
                letraDNI="K";
                break;
            case 22:
                letraDNI="E";
                break;
            default:
                letraDNI="-";
                break;
        }
        return letraDNI;
    }
    public void setLetraDNI(String letraDNI) {
        this.letraDNI = letraDNI;
    }

    public String getDNI() {
        String DNI = String.valueOf(this.numerosDNI);
        DNI+=this.getLetraDNI();
        return DNI;
    }

    /**
     * Getter y setter Letras Pasaporte
     */
    public String getLetrasPasaporte() {
        return letrasPasaporte;
    }
    public void setLetrasPasaporte(String letrasPasaporte) {
        if (letrasPasaporte.length()==3)
            this.letrasPasaporte = letrasPasaporte;
    }

    /**
     * Getter y setter Numeros Pasaporte
     */
    public int getNumerosPasaporte() {
        return numerosPasaporte;
    }
    public void setNumerosPasaporte(int numerosPasaporte) {
        if (String.valueOf(numerosPasaporte).length()==3)
            this.numerosPasaporte = numerosPasaporte;
    }
}