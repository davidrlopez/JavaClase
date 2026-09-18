package Trimestre3.RepasoExamen;

public class Profesor extends Persona {
    private int aniosTrabajo;
    private String especialidad;
    private double sueldo;

    public Profesor(String dni, String nombre, String apellido1, String apellido2, String direccion,
            int aniosTrabajo, String especialidad, double sueldo) {
        super(dni, nombre, apellido1, apellido2, direccion);
        this.aniosTrabajo = aniosTrabajo;
        this.especialidad = especialidad;
        this.sueldo = sueldo;
    }

    public int getAniosTrabajo() {
        return aniosTrabajo;
    }

    public void setAniosTrabajo(int aniosTrabajo) {
        this.aniosTrabajo = aniosTrabajo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String verDatos() {
        return super.verDatos() + " | Profesor | " + aniosTrabajo + " anios | " + especialidad + " | " + sueldo;
    }
}
