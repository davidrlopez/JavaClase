/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Trimestre3.Ficheros;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author javiermartinezfernandez
 */
class Persona implements Serializable {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }

}

public class FicherosJava {

    public static void LecturasEstandar() {

        StringBuilder str = new StringBuilder();

        char c;

        try {
            while ((c = (char) System.in.read()) != '\n') {

                str.append(c);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Cadena introducidad: " + str);
    }

    public static void CopiarFichero(String origen, String destino) {

        try {
            OutputStream fsalida;
            InputStream fentrada = new FileInputStream(origen);
            try {
                fsalida = new FileOutputStream(destino);
                byte[] buffer = new byte[256];
                while (true) {
                    int n = fentrada.read(buffer);

                    if (n < 0) {
                        break;
                    }
                    fsalida.write(buffer, 0, n);
                }
                fsalida.close();
                fentrada.close();

                System.out.println("Fichero copiado");
            } catch (IOException e) {
                e.getMessage();
            }

        } catch (Exception e) {
            e.getMessage();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // System.out.println("Hello World!");
        // LecturasEstandar();

        // String str = "/Users/javiermartinezfernandez/Desktop/DAW 1º
        // Presencial/Programación/prueba.txt";
        // String str2 = "/Users/javiermartinezfernandez/Desktop/DAW 1º
        // Presencial/Programación/prueba2.txt";
        //
        // CopiarFichero(str, str2);
        Persona elena = new Persona("Elena", 18);
        System.out.println(elena.toString());
        String userHome = System.getProperty("user.home");
        Scanner input = new Scanner(System.in);
        System.out.println("Save as:");
        String fileName = input.next();
        if (Paths.get(userHome, fileName).toFile().exists()) {
            if (fileName.contains(".")) {
                int dotIndex = fileName.lastIndexOf(".");
                fileName = fileName.substring(0, dotIndex) + "-2" + fileName.substring(dotIndex);
            } else {
                fileName = fileName.concat("-2");
            }
        }
        if (!fileName.contains(".")) {
            fileName = fileName.concat(".txt");
        }
        File fileg = Paths.get(userHome, fileName).toFile();
        int iterationsR = (int) (Math.random() * 1000);
        try {
            FileOutputStream fos = new FileOutputStream(fileg);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(elena);
            for (int i = 0; i < iterationsR; i++) {
                int ageRandom = (int) (Math.random() * 94) + 5;
                int nameLengthR = (int) (Math.random() * 8) + 1;
                String fullName = "";
                for (int j = 0; j < nameLengthR; j++) {
                    char charR = (char) (Math.random() * 24 + 97);
                    fullName += charR;
                }
                Persona b = new Persona(fullName, ageRandom);
                oos.writeObject(b);
            }
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileg));
            try {
                while (true) {
                    Persona p = (Persona) in.readObject();
                    System.out.println(p.nombre + " " + p.edad);
                }
            } catch (EOFException e) {
            }
            in.close();
            System.out.println("***************************************************");
            System.out.println("File:" + fileg.getName() + " created at:" + userHome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        input.close();
    }
}
