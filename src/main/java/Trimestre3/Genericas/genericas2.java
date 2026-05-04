package Trimestre3.Genericas;

public class genericas2<T, V> {
    T objeto1;
    V objeto2;

    public genericas2(T objeto1, V objeto2) {
        this.objeto1 = objeto1;
        this.objeto2 = objeto2;
    }

    public T getobjeto1() {
        return objeto1;
    }

    public V getobjeto2() {
        return objeto2;
    }

    @Override
    public String toString() {
        String cad1 = objeto1.getClass().getName();
        String cad2 = objeto2.getClass().getName();
        return "f" + "objetol=" + objeto1 + " Tipo= " + cad1 + " objeto2=" + objeto2 + "Tipo= " + cad2;
    }
}
