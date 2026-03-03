package Trimestre2.Herencias;

public class Fecha {
    private int dia;
    private int mes;
    private int anyo;

    public Fecha(int dia, int mes, int anyo) {
        setFecha(dia, mes, anyo);
    }

    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.anyo = 2000;
    }

    public Fecha(Fecha f) {
        this.dia = f.dia;
        this.mes = f.mes;
        this.anyo = f.anyo;
    }

    public void setFecha(int dia, int mes, int anyo) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mes incorrecto: " + mes);
        }
        if (dia < 1 || dia > diasEnMes(mes, anyo)) {
            throw new IllegalArgumentException("Día incorrecto para el mes " + mes + ": " + dia);
        }
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    private int diasEnMes(int mes, int anyo) {
        switch (mes) {
            case 2:
                if (esBisiesto(anyo)) return 29;
                return 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    private boolean esBisiesto(int anyo) {
        return (anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 400 == 0);
    }

    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAnyo() { return anyo; }
    
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anyo;
    }
}
