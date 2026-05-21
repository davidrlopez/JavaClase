/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Trimestre3.Ficheros;
import java.io.*;

/**
 *
 * @author javiermartinezfernandez
 */
class Persona implements Serializable{
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
    
    public static void LecturasEstandar(){
    
    StringBuilder str = new StringBuilder();
    
    char c;
    
        try {
            while((c=(char)System.in.read()) != '\n'){
            
                str.append(c);
            
            
            
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Cadena introducidad: " + str);
    }
    
    public static void CopiarFichero(String origen, String destino){
        
        try {
            OutputStream fsalida;
            InputStream fentrada = new FileInputStream(origen);
            try {
                fsalida = new FileOutputStream(destino);
                byte[] buffer= new byte[256];
                while(true){
                    int n = fentrada.read(buffer);
                    
                    if (n < 0) {
                        break;
                    }
                    fsalida.write(buffer,0,n);
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
        //System.out.println("Hello World!");
//        LecturasEstandar();
        
//        String str = "/Users/javiermartinezfernandez/Desktop/DAW 1º Presencial/Programación/prueba.txt";
//        String str2 = "/Users/javiermartinezfernandez/Desktop/DAW 1º Presencial/Programación/prueba2.txt";
//        
//        CopiarFichero(str, str2);
//        Persona elena = new Persona("Elena",18);
//        System.out.println(elena.toString());
//        
//        try {
//            FileOutputStream fos = new FileOutputStream("/Users/javiermartinezfernandez/Desktop/DAW 1º Presencial/Programación/ObjElena.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            
//            oos.writeObject(elena);
//            
//            oos.close();
//            fos.close();
//        } catch (Exception e) { e.printStackTrace();}
            ObjectInputStream in = new ObjectInputStream( 
                    new FileInputStream("/Users//Desktop/DAW 1º Presencial/Programación/ObjElena.txt"));
            Persona p = (Persona) in.readObject();
            
            in.close();
            
            System.out.println(p.nombre);
            System.out.println(p.edad);

    }
}

