package Trimestre2.Herencias;

public class HombreExceptions {
  public static class HijosException extends Exception{
    public HijosException(String mensaje){
      super(mensaje);
    }
    @Override

    public String toString(){
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }
   public static class VivoException extends Exception{
    public VivoException(String mensaje){
      super(mensaje);
    }
    @Override

    public String toString(){
      return this.getClass().getSimpleName() + ":" + getMessage();
    }
  }

}
