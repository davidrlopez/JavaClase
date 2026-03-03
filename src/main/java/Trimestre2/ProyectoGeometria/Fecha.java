package Trimestre2.ProyectoGeometria;

public class Fecha {
  private int dia;
  private int mes;
  private int año;
  private static final int dias[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private static final String meses[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
      "Septiembre", "Octubre", "Noviembre", "Diciembre" };

  public Fecha() {
    this.dia = 1;
    this.mes = 1;
    this.año = 2000;
  }

  public Fecha(int dia, int mes, int año) {
    this.SetFecha(dia, mes, año);
  }

  public int getDia() {
    return dia;
  }

  public void setDia(int d) {
    if (d < 1 || d > dias[this.getMes()]) {
      System.out.println("No se puede cambiar ese dia");
    }
    this.dia = d;
  }

  public int getMes() {
    return mes;
  }

  public void setMes(int m) {
    if (m < 1 || m > 12 || this.getDia() > dias[m]) {
      System.out.println("No se puede cambiar este mes");
      this.mes = m;
    }
  }

  public int getAño() {
    return año;
  }

  public void setAño(int a) {
    if (a < 0) {
      System.out.println("No se puede cambiar este año");
    } else {
      this.año = a;
    }
    this.año = a;
  }

  public static int[] getDias() {
    return dias;
  }

  public static String[] getMeses() {
    return meses;
  }

  public void SetFecha(int d, int m, int a) {
    if (d < 1 || m < 1 || m > 12 || a < 0 || d > dias[m]) {
      this.dia = 1;
      this.mes = 1;
      this.año = 2000;
    } else {
      this.dia = d;
      this.mes = m;
      this.año = a;
    }

  }

  public void verFecha() {
    System.out.println("__________________");
    System.out.println(dia + " de" + mes + " de" + año);
    ;
  }

  public String tString(int n) {
    switch (n) {
      case 1:
        return this.dia + "-" + this.mes + "-" + this.año;
      case 2:
        return this.dia + "-" + meses[this.mes] + "-" + this.año;
      case 3:
        return this.dia + " de" + this.mes + " de" + this.año;
      case 4:
        return this.dia + "/" + this.mes + "/" + this.año;
      default:
        return "Formato elegido no correcto";
    }
  }

  public boolean equals(Fecha f) {
    return this.equals(f.getDia(), f.getMes(), f.getAño());
    /*
     * if (this.getDia() == f.getDia() && this.getMes() == f.getMes() &&
     * this.getAño() == f.getAño()) {
     *
     * return true;
     * } else {
     * return false;
     * }
     */
  }

  public boolean equals(int d, int m, int a) {
    /* return this.equals(new Fecha(d,m,a)); */
    if (this.getDia() == d && this.getMes() == m && this.getAño() == a) {

      return true;
    } else {
      return false;
    }
  }

}
