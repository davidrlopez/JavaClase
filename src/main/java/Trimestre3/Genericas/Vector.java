package Trimestre3.Genericas;

import java.util.Arrays;
import java.util.Comparator;

public class Vector<E extends Number> {
    private E[] array;

    public Vector(E[] array) {
        this.array = array;
    }

    @SuppressWarnings("unchecked")
    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("El tamaño debe ser mayor que 0");
        }
        array = (E[]) new Number[size];
    }

    public void set(int index, E element) {
        try {
            array[index] = element;
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Excepción controlada: El índice " + index + " está fuera de los límites del vector.");
        }
    }

    public E get(int index) {
        try {
            return array[index];
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Excepción controlada: El índice " + index + " está fuera de los límites del vector.");
            return null;
        }
    }

    public int elementos() {
        return array.length;
    }

    public void mostrar() {
        System.out.println(Arrays.toString(array));
    }

    public E maximo() {
        if (array.length == 0 || array[0] == null) {
            return null;
        }

        E max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != null && array[i].doubleValue() > max.doubleValue()) {
                max = array[i];
            }
        }
        return max;
    }

    public E minimo() {
        if (array.length == 0 || array[0] == null) {
            return null;
        }

        E min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != null && array[i].doubleValue() < min.doubleValue()) {
                min = array[i];
            }
        }
        return min;
    }

    public boolean estaX(E valor) {
        for (E e : array) {
            if (e != null && e.equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public double media() {
        if (array.length == 0) {
            return 0.0;
        }

        double suma = 0.0;
        int count = 0;
        for (E e : array) {
            if (e != null) {
                suma += e.doubleValue();
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }
        return suma / count;
    }

    public boolean comparaMedia(Vector<?> otroVector) {
        if (otroVector == null) {
            return false;
        }
        return media() == otroVector.media();
    }

    public void ordenarASC() {
        Arrays.sort(array, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (o1 == null) {
                    return 1;
                }
                if (o2 == null) {
                    return -1;
                }
                return Double.compare(o1.doubleValue(), o2.doubleValue());
            }
        });
    }
}
