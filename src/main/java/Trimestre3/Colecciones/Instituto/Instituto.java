package Trimestre3.Colecciones.Instituto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import Trimestre2.Excepciones.RepasoExcepciones.Persona;
import Trimestre3.Colecciones.Instituto.InstitutoExceptions.GeneracionDatosException;

public class Instituto {

  private ArrayList<Persona> personas;
  private HashMap<Integer, Profesor> mapaProfesores;

  public Instituto() {
    this.personas = new ArrayList<>();
    this.mapaProfesores = new HashMap<>();
  }

  public void añadirPersona(Persona p) throws IllegalArgumentException {
    if (p == null) {
      throw new IllegalArgumentException("Persona no valida");
    }
    personas.add(p);
    System.out.println("-> Añadido [" + p.getClass().getSimpleName() + "]: " + p.toString());
  }

  public boolean buscarPersonaPorDni(String dni) {
    boolean encontrado = false;
    for (Persona persona : personas) {
      if (persona.getNif().toString().equalsIgnoreCase(dni)) {
        System.out.println(persona.toString());
        encontrado = true;
      }
    }
    if (!encontrado) {
      System.out.println("  No se encontró ninguna persona con DNI: " + dni);
    }
    return encontrado;
  }

  public boolean borrarPersonaPorDni(String dni) {
    boolean borrado = personas.removeIf(persona -> persona.getNif().toString().equalsIgnoreCase(dni));
    if (borrado) {
      System.out.println("Persona con DNI " + dni + " borrada correctamente de la lista.");
    } else {
      System.out.println("No se encontró ninguna persona con DNI " + dni);
    }
    return borrado;
  }

  public void mostrarSumaSueldosProfesoresLista() {
    double sumaSueldo = 0;
    for (Persona persona : personas) {
      if (persona instanceof Profesor) {
        sumaSueldo += ((Profesor) persona).getSueldo();
      }
    }
    System.out.println("Suma total de sueldos de Profesores en la Lista: " + sumaSueldo + "€");
  }

  public void generarProfesoresMapaAleatorios(int cantidad) throws GeneracionDatosException {
    Random random = new Random();
    System.out.println("-> Generando " + cantidad + " profesores aleatorios en el Mapa...");
    for (int i = 1; i <= cantidad; i++) {
      try {
        Profesor prof = new Profesor(i, "Especialidad_" + i, 20000 + (i * 500));
        prof.setPersona("ProfNombre" + i, "Apel" + i, "Apel" + i, "HOMBRE", "SOLTERO", "01/01/1990",
            (10000000 + i) + "A");
        int clave;
        do {
          clave = random.nextInt(100) + 1;
        } while (mapaProfesores.containsKey(clave));

        mapaProfesores.put(clave, prof);
        System.out.println("   [Clave " + clave + "] " + prof.toString());
      } catch (Exception e) {
        throw new GeneracionDatosException("Error al crear profesor aleatorio " + i + ": " + e.getMessage());
      }
    }
  }

  public void buscarProfesorEnMapa(int clave) {
    Profesor profEncontrado = mapaProfesores.get(clave);
    if (profEncontrado != null) {
      System.out.println(profEncontrado.toString());
    } else {
      System.out.println("No hay ningún profesor con la clave" + clave);
    }
  }

  public void borrarProfesorEnMapa(int clave) {
    Profesor profBorrado = mapaProfesores.remove(clave);
    if (profBorrado != null) {
      System.out.println("Profesor con clave " + clave + " borrado correctamente del mapa.");
    } else {
      System.out.println("No se encontró ningún profesor con la clave " + clave);
    }
  }

  public void mostrarSumaSueldosProfesoresMapa() {
    double sumaSueldosMap = 0;
    for (Profesor p : mapaProfesores.values()) {
      sumaSueldosMap += p.getSueldo();
    }
    System.out.println("Suma total de sueldos de Profesores en el Mapa: " + sumaSueldosMap + "€");
  }
}
