/**
 * Representa a un empleado con sus datos personales, departamento y salario.
 */
public class Empleado {
  private String nombre;
  private String apellidos;
  private String departamento;
  private double salario;

  /**
   * Crea un empleado con valores por defecto.
   */
  public Empleado() {
    this("Sin nombre", "Sin apellidos", "Sin departamento", 0);
  }

  /**
   * Crea un empleado con los datos indicados.
   *
   * @param nombre nombre del empleado
   * @param apellidos apellidos del empleado
   * @param departamento departamento en el que trabaja el empleado
   * @param salario salario mensual del empleado
   * @throws IllegalArgumentException si algun texto esta vacio o el salario es negativo
   */
  public Empleado(String nombre, String apellidos, String departamento, double salario) {
    setNombre(nombre);
    setApellidos(apellidos);
    setDepartamento(departamento);
    setSalario(salario);
  }

  /**
   * Devuelve el nombre del empleado.
   *
   * @return nombre del empleado
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Modifica el nombre del empleado.
   *
   * @param nombre nuevo nombre del empleado
   * @throws IllegalArgumentException si el nombre esta vacio
   */
  public void setNombre(String nombre) {
    if (nombre == null || nombre.isBlank()) {
      throw new IllegalArgumentException("El nombre no puede estar vacio");
    }
    this.nombre = nombre;
  }

  /**
   * Devuelve los apellidos del empleado.
   *
   * @return apellidos del empleado
   */
  public String getApellidos() {
    return apellidos;
  }

  /**
   * Modifica los apellidos del empleado.
   *
   * @param apellidos nuevos apellidos del empleado
   * @throws IllegalArgumentException si los apellidos estan vacios
   */
  public void setApellidos(String apellidos) {
    if (apellidos == null || apellidos.isBlank()) {
      throw new IllegalArgumentException("Los apellidos no pueden estar vacios");
    }
    this.apellidos = apellidos;
  }

  /**
   * Devuelve el departamento del empleado.
   *
   * @return departamento del empleado
   */
  public String getDepartamento() {
    return departamento;
  }

  /**
   * Modifica el departamento del empleado.
   *
   * @param departamento nuevo departamento del empleado
   * @throws IllegalArgumentException si el departamento esta vacio
   */
  public void setDepartamento(String departamento) {
    if (departamento == null || departamento.isBlank()) {
      throw new IllegalArgumentException("El departamento no puede estar vacio");
    }
    this.departamento = departamento;
  }

  /**
   * Devuelve el salario mensual del empleado.
   *
   * @return salario mensual del empleado
   */
  public double getSalario() {
    return salario;
  }

  /**
   * Modifica el salario mensual del empleado.
   *
   * @param salario nuevo salario mensual del empleado
   * @throws IllegalArgumentException si el salario es negativo
   */
  public void setSalario(double salario) {
    if (salario < 0) {
      throw new IllegalArgumentException("El salario no puede ser negativo");
    }
    this.salario = salario;
  }

  /**
   * Calcula el salario anual del empleado.
   *
   * @return salario anual del empleado
   */
  public double calcularSalarioAnual() {
    return salario * 12;
  }

  /**
   * Devuelve una representacion en texto del empleado.
   *
   * @return texto con los datos principales del empleado
   */
  @Override
  public String toString() {
    return nombre + " " + apellidos + " | Departamento: " + departamento + " | Salario: " + salario;
  }
}
