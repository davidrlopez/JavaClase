package Trimestre3.Colecciones.Instituto;

import java.util.Scanner;
import Trimestre2.Excepciones.RepasoExcepciones.Persona;
import Trimestre3.Colecciones.Instituto.InstitutoExceptions.GeneracionDatosException;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Instituto miInstituto = new Instituto();

    System.out.println("=== INICIALIZANDO DATOS ===");
    inicializarDatos(miInstituto);

    int opcion;
    do {
      System.out.println("\n===== MENÚ INSTITUTO =====");
      System.out.println("1. Buscar Persona en ArrayList (por DNI)");
      System.out.println("2. Borrar Persona en ArrayList (por DNI)");
      System.out.println("3. Ver suma sueldos Profesores (ArrayList)");
      System.out.println("--------------------------");
      System.out.println("4. Buscar Profesor en HashMap (por Clave)");
      System.out.println("5. Borrar Profesor en HashMap (por Clave)");
      System.out.println("6. Ver suma sueldos Profesores (HashMap)");
      System.out.println("0. Salir");
      System.out.print("Elige una opción: ");

      if (!input.hasNextInt()) {
        input.next();
        System.out.println("Por favor, introduce un número válido.");
        opcion = -1;
        continue;
      }

      opcion = input.nextInt();
      input.nextLine();

      switch (opcion) {
        case 1:
          System.out.print("DNI a buscar");
          miInstituto.buscarPersonaPorDni(input.nextLine());
          break;
        case 2:
          System.out.print("DNI a borrar");
          miInstituto.borrarPersonaPorDni(input.nextLine());
          break;
        case 3:
          miInstituto.mostrarSumaSueldosProfesoresLista();
          break;
        case 4:
          System.out.print("Clave a buscar");
          if (input.hasNextInt()) {
            miInstituto.buscarProfesorEnMapa(input.nextInt());
            input.nextLine();
          } else {
            System.out.println("  Error: La clave debe ser un número entero.");
            input.nextLine();
          }
          break;
        case 5:
          System.out.print("Clave a borrar en HashMap: ");
          if (input.hasNextInt()) {
            miInstituto.borrarProfesorEnMapa(input.nextInt());
            input.nextLine();
          } else {
            System.out.println("Error: La clave debe ser un número entero.");
            input.nextLine();
          }
          break;
        case 6:
          miInstituto.mostrarSumaSueldosProfesoresMapa();
          break;
        case 0:
          break;
        default:
          System.out.println("Opción no válida.");
      }
    } while (opcion != 0);

    input.close();
  }

  private static void inicializarDatos(Instituto miInstituto) {
    try {
      Persona juan = new Persona();
      Persona miguel = new Persona();
      juan.setPersona("Juan", "Zapatero", "Lopez", "HOMBRE", "CASADO", "01/01/2000", "486763A");
      miguel.setPersona(juan);
      miInstituto.añadirPersona(juan);
      miInstituto.añadirPersona(miguel);
    } catch (Exception e) {
      e.getMessage();
    }

    try {
      Alumno adrian = new Alumno(3, "B2");
      Alumno javier = new Alumno(1, "C2");
      adrian.setPersona("Adrian", "Zamora", "", "HOMBRE", "ENNOVIAO", "18/09/2007", "234576X");
      javier.setPersona("Javier", "Martinez", "Fernandez", "HOMBRE", "CASADO", "20/06/2001", "658709E");
      miInstituto.añadirPersona(adrian);
      miInstituto.añadirPersona(javier);
    } catch (Exception e) {
      e.getMessage();
    }

    try {
      Profesor juanPedro = new Profesor(15, "Programacion", 25000);
      Profesor luismi = new Profesor(10, "Sistemas", 25000);
      juanPedro.setPersona("JuanPedro", "Zapatero", "Lopez", "HOMBRE", "CASADO", "01/01/2000", "486763A");
      luismi.setPersona(juanPedro); // Copia
      miInstituto.añadirPersona(juanPedro);
      miInstituto.añadirPersona(luismi);
    } catch (Exception e) {
      e.getMessage();
    }

    try {
      miInstituto.generarProfesoresMapaAleatorios(10);
    } catch (GeneracionDatosException e) {
      System.out.println("Error grave al inicializar el mapa: " + e.getMessage());
    }
  }
}
