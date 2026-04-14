package ActividadJUnitMaven;

public class Persona {
    private int edad;

    public Persona(int edad) {
        this.edad = edad;
    }

    public boolean isMayorDeEdad() {
        if (edad >= 18 && edad <= 120)  {
            return true;
        } else {
            return false;
        }
    }
}
