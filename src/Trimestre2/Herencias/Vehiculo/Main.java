package Trimestre2.Herencias.Vehiculo;

import java.util.Arrays;
import Trimestre2.Excepciones.RepasoExcepciones.Fecha;

public class Main {
  public static void main(String[] args) {
    try {
      Fecha f = new Fecha(12, 4, 2001);
      Vehiculo v1 = new Vehiculo("Vespa", 200000, f);
      VehiculoConMotor vc1 = new VehiculoConMotor(v1, 1600);

      int[] K = { 30000, 15500, 22000 };
      int[] G = { 13000, 40000, 2000 };

      Moto m1 = new Moto(vc1, K, G, "MU-3456-CV", "Rogelio", 3);

      System.out.println("Kms iniciales: " + Arrays.toString(m1.getKms()));
      System.out.println("Gastos iniciales: " + Arrays.toString(m1.getGastos()));

      m1.tenerRevision(2345, 25567);

      int posMasCara = m1.lugarRevisionMasCara();
      int kmsMasCara = m1.posicionRevision(posMasCara);

      System.out.println("Posicion revision mas cara: " + posMasCara);
      System.out.println("Kms revision mas cara: " + kmsMasCara);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
