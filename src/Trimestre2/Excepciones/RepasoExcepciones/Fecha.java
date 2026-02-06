package Trimestre2.Excepciones.RepasoExcepciones;

import static Trimestre2.Excepciones.RepasoExcepciones.FechasException.*;

public class Fecha {

  private int d = 1;
  private int m = 1;
  private int a = 2000;
  private int[] meses = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private String[] nombres = {
      "Enero",
      "Febrero",
      "Marzo",
      "Abril",
      "Mayo",
      "Junio",
      "Julio",
      "Agosto",
      "Septiembre",
      "Octubre",
      "Noviembre",
      "Diciembre",
  };

  public Fecha() throws DiaException, MesException, YearException {
    // Valores por defecto inicializados en la declaración
  }

  public Fecha(int d, int m, int a)
      throws DiaException, MesException, YearException {
    setDia(d);
    setMes(m);
    setYear(a);
  }

  public Fecha(String d, String m, String a)
      throws NumberFormatException, DiaException, MesException, YearException {
    setDia(Integer.parseInt(d));
    setMes(Integer.parseInt(m));
    setYear(Integer.parseInt(a));
  }

  // Nuevo constructor para cadena completa "dd/mm/yyyy"
  public Fecha(String fecha)
      throws NumberFormatException, DiaException, MesException, YearException {
    // Regex para dd/mm/yyyy, dd-mm-yyyy o dd.mm.yyyy
    String regex = "\\d{1,2}[-/.]\\d{1,2}[-/.]\\d{4}";

    if (!fecha.matches(regex)) {
      throw new NumberFormatException(
          "Formato incorrecto: " + fecha + ". Use dd/mm/yyyy");
    }

    // Dividimos por cualquiera de los separadores permitidos
    String[] partes = fecha.split("[-/.]");

    setDia(Integer.parseInt(partes[0]));
    setMes(Integer.parseInt(partes[1]));
    setYear(Integer.parseInt(partes[2]));
  }

  public Fecha(Fecha otra) {
    this.d = otra.d;
    this.m = otra.m;
    this.a = otra.a;
  }

  public int getDia() {
    return this.d;
  }

  public void setDia(int d) throws DiaException {
    int oldD = this.d;
    this.d = d;

    if (!fechaCorrecta()) {
      this.d = oldD; // Restauramos valor anterior
      throw new DiaException(
          "Error en el dia: " + d + ". No válido para el mes/año actual.");
    }
  }

  // Método privado para saber si es bisiesto
  private boolean esBisiesto() {
    return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
  }

  // Método que valida la lógica de la fecha actual
  private boolean fechaCorrecta() {
    if (a < 0)
      return false;
    if (m < 1 || m > 12)
      return false;

    int diasMes = meses[m - 1];

    // Ajuste para bisiesto en Febrero
    if (m == 2 && esBisiesto()) {
      diasMes = 29;
    }

    if (d < 1 || d > diasMes)
      return false;

    return true;
  }

  public int getMes() {
    return this.m;
  }

  public void setMes(int m) throws MesException {
    int oldM = this.m;
    this.m = m;

    if (!fechaCorrecta()) {
      this.m = oldM; // Restauramos valor anterior
      throw new MesException(
          "Error en el mes: " + m + ". No válido para el día actual.");
    }
  }

  public int getYear() {
    return this.a;
  }

  public void setYear(int a) throws YearException {
    int oldA = this.a;
    this.a = a;

    if (!fechaCorrecta()) {
      this.a = oldA; // Restauramos valor anterior
      throw new YearException(
          "Error en el año: " + a + ". No válido para la fecha actual.");
    }
  }

  public void setFecha(int d, int m, int a)
      throws DiaException, MesException, YearException {
    setDia(d);
    setMes(m);
    setYear(a);
  }

  public void setFecha(Fecha otra)
      throws DiaException, MesException, YearException {
    this.setFecha(otra.d, otra.m, otra.a);
  }

  public String toString(int entrada) {
    int year2d = a % 100;
    String mes = (m >= 1 && m <= 12) ? nombres[m - 1] : "MesInválido";

    if (entrada == 1) {
      return (String.valueOf(this.getDia()) +
          "-" +
          String.valueOf(this.getMes()) +
          "-" +
          String.valueOf(year2d));
    }
    if (entrada == 2) {
      return (String.valueOf(this.getDia()) +
          "-" +
          String.valueOf(this.getMes()) +
          "-" +
          String.valueOf(this.getYear()));
    }
    if (entrada == 3) {
      return (String.valueOf(this.getDia()) +
          "-" +
          mes +
          "-" +
          String.valueOf(this.getYear()));
    }
    if (entrada == 4) {
      return (String.valueOf(this.getDia()) +
          " de " +
          mes +
          " de " +
          String.valueOf(this.getYear()));
    }
    if (entrada == 5) {
      return (String.valueOf(this.getDia()) +
          "/" +
          String.valueOf(this.getMes()) +
          "/" +
          String.valueOf(year2d));
    }
    if (entrada == 6) {
      return (String.valueOf(this.getDia()) +
          "-" +
          String.valueOf(this.getMes()) +
          "-" +
          String.valueOf(this.getYear()));
    }

    return "Opcion de entrada no valida";
  }

  public boolean equals(Fecha otra) {
    if (otra == null) {
      return false;
    }
    return (this.getDia() == otra.getDia() &&
        this.getMes() == otra.getMes() &&
        this.getYear() == otra.getYear());
  }

  public boolean equals(int d, int m, int a) {
    return this.getDia() == d && this.getMes() == m && this.getYear() == a;
  }

  public int toDias() {
    // We calculate total days for this object
    int totalHoy = totalDesdeCero(this.d, this.m, this.a);

    // We calculate total days for the baseline (1/1/2000)
    int totalBase = totalDesdeCero(1, 1, 2000);

    return totalHoy - totalBase;
  }

  private int totalDesdeCero(int dia, int mes, int anio) {
    int total = anio * 365;

    // Add leap days (extra days for Feb 29th)
    total += (anio / 4) - (anio / 100) + (anio / 400);

    // Add days for months in the current year
    for (int i = 0; i < mes - 1; i++) {
      total += meses[i];
    }

    // If it's a leap year and we are past February, add the leap day
    if (mes > 2 && ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0))) {
      total++;
    }

    return total + dia;
  }

  public boolean mayorFecha(Fecha otra) {
    int dias1 = this.totalDesdeCero(this.d, this.m, this.a);
    int dias2 = otra.totalDesdeCero(otra.d, otra.m, otra.a);
    return dias1 > dias2;
  }

  public boolean menorFecha(Fecha otra) {
    int dias1 = this.totalDesdeCero(this.d, this.m, this.a);
    int dias2 = otra.totalDesdeCero(otra.d, otra.m, otra.a);
    return dias1 < dias2;
  }

  public int diasEntreFechas(Fecha otra) {
    return this.totalDesdeCero(this.d, this.m, this.a) - otra.totalDesdeCero(otra.d, otra.m, otra.a);
  }

  public Fecha fechaSiguiente() throws YearException, MesException, DiaException {
    Fecha siguiente = new Fecha();
    siguiente.setFecha(this.d + 1, this.m, this.a);
    return siguiente;
  }

  public Fecha fechaAnterior() throws YearException, MesException, DiaException {
    Fecha anterior = new Fecha();
    anterior.setFecha(this.d - 1, this.m, this.a);
    return anterior;
  }
}
