package Trimestre3.Genericas;

public interface Operable<E extends Number> {
    E suma(E otro);

    E resta(E otro);

    E producto(E otro);

    E division(E otro);
}
