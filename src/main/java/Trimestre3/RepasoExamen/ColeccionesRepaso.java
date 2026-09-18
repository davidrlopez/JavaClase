package Trimestre3.RepasoExamen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ColeccionesRepaso {
    private final Scanner input = new Scanner(System.in);

    public void run() {
        System.out.println("Ejercicio 1: ArrayList de Persona");
        ejercicioArrayList();
        System.out.println();
        System.out.println("Ejercicio 2: HashMap de Profesor");
        ejercicioHashMap();
    }

    private void ejercicioArrayList() {
        ArrayList<Persona> personas = crearPersonas();

        mostrarPersonas(personas);
        buscarPersona(personas);
        borrarPersona(personas);
        mostrarPersonas(personas);
        System.out.println("Suma sueldos profesores: " + sumarSueldos(personas));
    }

    private void ejercicioHashMap() {
        HashMap<Integer, Profesor> profesores = crearProfesoresHashMap();

        mostrarProfesores(profesores);
        buscarProfesor(profesores);
        borrarProfesor(profesores);
        mostrarProfesores(profesores);
        System.out.println("Suma sueldos HashMap: " + sumarSueldos(profesores));
    }

    private ArrayList<Persona> crearPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();

        personas.add(new Profesor("11111111", "Ana", "Lopez", "Soto", "Calle A", 5, "Programacion", 2100));
        personas.add(new Profesor("22222222", "Luis", "Perez", "Mora", "Calle B", 8, "BasesDatos", 2300));
        personas.add(new Alumno("33333333", "Marta", "Ruiz", "Gil", "Calle C", "1DAW", "B1"));
        personas.add(new Alumno("44444444", "Pablo", "Diaz", "Rey", "Calle D", "2DAW", "B2"));

        return personas;
    }

    private HashMap<Integer, Profesor> crearProfesoresHashMap() {
        HashMap<Integer, Profesor> profesores = new HashMap<>();
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            int clave;
            do {
                clave = random.nextInt(100) + 1;
            } while (profesores.containsKey(clave));

            Profesor profesor = new Profesor(
                    "P" + i,
                    "Profesor" + i,
                    "Apellido" + i,
                    "Segundo" + i,
                    "Direccion" + i,
                    i + 1,
                    "Especialidad" + i,
                    1800 + i * 100);

            profesores.put(clave, profesor);
        }

        return profesores;
    }

    private void buscarPersona(ArrayList<Persona> personas) {
        String dni = leerTexto("DNI a buscar: ");

        for (Persona persona : personas) {
            if (persona.getDni().equalsIgnoreCase(dni)) {
                System.out.println(persona.verDatos());
                return;
            }
        }

        System.out.println("No existe una persona con ese DNI");
    }

    private void borrarPersona(ArrayList<Persona> personas) {
        String dni = leerTexto("DNI a borrar: ");

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getDni().equalsIgnoreCase(dni)) {
                personas.remove(i);
                System.out.println("Persona borrada");
                return;
            }
        }

        System.out.println("No existe una persona con ese DNI");
    }

    private double sumarSueldos(ArrayList<Persona> personas) {
        double suma = 0;

        for (Persona persona : personas) {
            if (persona instanceof Profesor) {
                Profesor profesor = (Profesor) persona;
                suma += profesor.getSueldo();
            }
        }

        return suma;
    }

    private void buscarProfesor(HashMap<Integer, Profesor> profesores) {
        int clave = leerEntero("Clave a buscar: ");
        Profesor profesor = profesores.get(clave);

        if (profesor == null) {
            System.out.println("No existe un profesor con esa clave");
        } else {
            System.out.println(profesor.verDatos());
        }
    }

    private void borrarProfesor(HashMap<Integer, Profesor> profesores) {
        int clave = leerEntero("Clave a borrar: ");
        Profesor profesor = profesores.remove(clave);

        if (profesor == null) {
            System.out.println("No existe un profesor con esa clave");
        } else {
            System.out.println("Profesor borrado");
        }
    }

    private double sumarSueldos(HashMap<Integer, Profesor> profesores) {
        double suma = 0;

        for (Profesor profesor : profesores.values()) {
            suma += profesor.getSueldo();
        }

        return suma;
    }

    private void mostrarPersonas(ArrayList<Persona> personas) {
        for (Persona persona : personas) {
            System.out.println(persona.verDatos());
        }
    }

    private void mostrarProfesores(HashMap<Integer, Profesor> profesores) {
        for (Map.Entry<Integer, Profesor> entrada : profesores.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue().verDatos());
        }
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero entero");
            }
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return input.nextLine().trim();
    }
}
