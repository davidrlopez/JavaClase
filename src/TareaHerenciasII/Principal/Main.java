package TareaHerenciasII.Principal;

import TareaHerenciasII.Fecha.Fecha;
import TareaHerenciasII.Motor.VehiculoConMotor;
import TareaHerenciasII.Vehiculo.Moto;
import TareaHerenciasII.Vehiculo.Vehiculo;

public class Main {
  public static void main(String[] args) {
    try {
      Fecha f = new Fecha(12, 4, 2001);
      Vehiculo v1 = new Vehiculo("Vespa", 200000, f);
      VehiculoConMotor vc1 = new VehiculoConMotor(v1, 1600);

      Revision[] revisiones = {
          new Revision(30000, 13000),
          new Revision(15500, 40000),
          new Revision(22000, 2000)
      };

      Moto m1 = new Moto(vc1, "MU-3456-CV", "Rogelio", revisiones);

      m1.tenerRevision(new Revision(2345, 25567));
      m1.ordenKms();

      int posMasCara = m1.getPosRevisionMasCara();
      Revision[] revisionesOrdenadas = m1.getListRevisiones();

      System.out.println("===== DATOS MOTO =====");
      System.out.println("Matricula   : " + m1.getMatricula());
      System.out.println("Propietario : " + m1.getPropietario());
      System.out.println("Modelo      : " + m1.getModelo());
      System.out.println("Potencia    : " + m1.getPotencia());
      System.out.println("Precio      : " + m1.getPrecio());
      System.out.println("Fecha compra: " + m1.getFechaCompra());
      System.out.println();

      System.out.println("===== REVISIONES (ordenadas por kms) =====");
      for (int i = 0; i < revisionesOrdenadas.length; i++) {
        System.out.println((i + 1) + ". " + revisionesOrdenadas[i]);
      }
      System.out.println();
      System.out.println("Posicion revision mas cara (indice base 0): " + posMasCara);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
