package Trimestre2.Interfaces.Interfaces;

public interface Prestable {
  public boolean prestar() throws IllegalArgumentException;

  public boolean devolver() throws IllegalArgumentException;

  public boolean prestado();
}
