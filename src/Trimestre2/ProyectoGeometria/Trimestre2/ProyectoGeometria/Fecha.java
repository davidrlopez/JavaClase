package Trimestre2;

public class Fecha{
private int dia;
  private int mes;
  private int año;
  private static final int dias[]={31,28,31,30,31,30,31,31,30,31,30,31};
  private static final String meses[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
public Fecha(){
    this.dia=1;
    this.mes=1;
    this.año=2000;
  }
}
