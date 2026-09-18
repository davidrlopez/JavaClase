package Trimestre3.RepasoExamen;

public class Alumno extends Persona {
    private String curso;
    private String nivelIngles;

    public Alumno(String dni, String nombre, String apellido1, String apellido2, String direccion,
            String curso, String nivelIngles) {
        super(dni, nombre, apellido1, apellido2, direccion);
        this.curso = curso;
        this.nivelIngles = nivelIngles;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNivelIngles() {
        return nivelIngles;
    }

    public void setNivelIngles(String nivelIngles) {
        this.nivelIngles = nivelIngles;
    }

    @Override
    public String verDatos() {
        return super.verDatos() + " | Alumno | " + curso + " | Ingles: " + nivelIngles;
    }
}
