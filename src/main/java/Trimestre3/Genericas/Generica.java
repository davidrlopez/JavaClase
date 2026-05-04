package Trimestre3.Genericas;

import java.util.ArrayList;
import Trimestre2.ExamenNetflix.Clases.Producto;

public class Generica<T extends Producto> {
    private ArrayList<T> lista;

    public Generica() {
        lista = new ArrayList<>();
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public void aniadir(T objeto) {
        lista.add(objeto);
    }

    public T primero() throws IllegalArgumentException {
        if (estaVacia()) {
            throw new IllegalArgumentException("La lista está vacía.");
        }
        return lista.get(0);
    }

    public T extraer() throws IllegalArgumentException {
        T elemento = primero();
        lista.remove(0);
        return elemento;
    }

    @Override
    public String toString() {
        return "Generica [lista=" + lista + "]";
    }
}
