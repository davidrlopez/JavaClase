/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Trimestre2.ProyectoCoche2.src.main.java.paqCoche;

/**
 *
 * @author juanp
 */
public class Principal 
{

    public static void main(String[] args)
    {
         // TODO code application logic here
        Coche c1 = new Coche();
        Coche c2 = new Coche("Seat", "Leon es un modelo de seat", "Rojo", "Gasolina", "Manual", 4, 20000);
        Coche c3 = new Coche(c2);
        
        System.out.println(c1.toString());
        c2.ver_datos();
        c3.ver_datos();
        
        System.out.println("Numero puertas c2: " + c2.getNumpuertas());
        c2.setNumPuertas(3);
        
        System.out.println("Numero puertas c2: " + c2.getNumpuertas());
        
        c3.setDatos("Lamborghini", "Huracán", "Negro", "Gasolina", "Manual", 7, 50000);
        c3.toString();
        
        if (c2.equals(c3))
            System.out.println("C2 y C3 son iguales");
        else
            System.out.println("C2 y C3 NO son iguales");
        
    }
}
