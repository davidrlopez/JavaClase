/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DepuracionTareaCompleja;

/**
 *
 * @author Alumno
 */
public class Ppal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    /*
     * Complejo c=new Complejo(3,4);
     * System.out.println("c="+c);
     *
     * Complejo s=c.sumaComplejo(1,2);
     * System.out.println("Suma de c y 1+2i ="+s);
     *
     * Complejo ss=c.sumaComplejo(s);
     * System.out.println("ss= "+ss);
     *
     * Complejo xx=c.sumaComplejo(7,7).sumaComplejo(ss);
     * System.out.println("xx (c+(7+7i)+ss)="+xx);
     *
     * int x=c.sumaComplejo(7,7).sumaComplejo(ss).getR();
     * System.out.println("Parte real de xx ="+x);
     *
     * Complejo r=ss.complejoResta(s.getR(),s.getI());
     * System.out.println("r= "+r);
     *
     *
     * Complejo angel=ss.complejoResta(c.sumaComplejo(s).getR(),4);
     *
     * Complejo nacho=ss.complejoResta(c.getR() + s.getR(),4);
     * System.out.println("angel ="+angel+"\nnacho="+nacho);
     *
     * System.out.println("nacho + angel ="+nacho.sumaComplejo(angel));
     *
     */
    MisArrays util = new MisArrays();
    int[] miArray = { 9, 5, 2, 8, 1 };
    Complejo c1, c2, c3, c4;
    c1 = new Complejo(4, 2);
    c2 = new Complejo(5, 9);
    c3 = new Complejo(15, 4);
    c4 = new Complejo(c3);

    int i = c1.sumaComplejo(7, c2.getI()).complejoProducto(4, c4.sumaComplejo(c1).getI()).getI();
    System.out.println("i=" + i);

  }

}
