package Trimestre2.Herencias.Abstractas;

public abstract class Figura {

  private static final double DIMENSION_POR_DEFECTO = 1.0;
  private double fig1;
  private double fig2;

  protected Figura() {
    this(DIMENSION_POR_DEFECTO, DIMENSION_POR_DEFECTO);
  }

  protected Figura(double fig1, double fig2) {
    setFig1(fig1);
    setFig2(fig2);
  }

  public double getFig1() {
    return fig1;
  }

  public void setFig1(double fig1) {
    this.fig1 = validarDimension(fig1, "fig1");
  }

  public double getFig2() {
    return fig2;
  }

  public void setFig2(double fig2) {
    this.fig2 = validarDimension(fig2, "fig2");
  }

  private static double validarDimension(double valor, String nombreCampo) {
    if (valor <= 0) {
      throw new IllegalArgumentException(nombreCampo + " debe ser mayor que 0.");
    }
    return valor;
  }

  public abstract double area();

  public void verDatos() {
    System.out.println("---------------");
    System.out.println("fig1: " + getFig1());
    System.out.println("fig2: " + getFig2());
  }

  public void ver_datos() {
    verDatos();
  }

  public static class Rectangulo extends Figura {
    public Rectangulo() {
      super();
    }

    public Rectangulo(double fig1, double fig2) {
      super(fig1, fig2);
    }

    public double getDiagonal() {
      return Math.hypot(getFig1(), getFig2());
    }

    @Override
    public double area() {
      return getFig1() * getFig2();
    }
  }

  public static class Triangulo extends Figura {
    public Triangulo() {
      super();
    }

    public Triangulo(double fig1, double fig2) {
      super(fig1, fig2);
    }

    @Override
    public double area() {
      return (getFig1() * getFig2()) / 2;
    }
  }

  public static void main(String[] args) {
    Figura[] figuras = {
        new Rectangulo(9, 5),
        new Triangulo(9, 5),
        new Rectangulo(),
        new Triangulo()
    };

    for (Figura figura : figuras) {
      figura.verDatos();
      System.out.println("area: " + figura.area());

      if (figura instanceof Rectangulo) {
        Rectangulo rectangulo = (Rectangulo) figura;
        System.out.println("diagonal: " + rectangulo.getDiagonal());
      }
    }
  }
}
