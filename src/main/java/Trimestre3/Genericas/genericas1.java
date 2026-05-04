package Trimestre3.Genericas;

class Generica1<T> {
    T objeto;

    public Generica1(T objeto) {
        this.objeto = objeto;
    }

    public T getObjeto() {
        return objeto;
    }

    @Override
    public String toString() {
        return "Generica1(p1=" + objeto + " tipo:" + objeto.getClass().getSimpleName() + ")";
    }
}
