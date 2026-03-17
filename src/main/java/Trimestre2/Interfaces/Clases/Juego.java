package Trimestre2.Interfaces.Clases;

import Trimestre2.Interfaces.Interfaces.VendibleVideoClub;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.*;

public class Juego extends ProductoVideoClub implements VendibleVideoClub {

  private boolean vendido = false;
  private static int contJuegos = 0;
  private String plataforma = "";

  public boolean isVendido() {
    return vendido;
  }

  public void setVendido(boolean vendido) {
    this.vendido = vendido;
  }

  public static int getContJuegos() {
    return contJuegos;
  }

  public static void setContJuegos(int contJuegos) {
    Juego.contJuegos = contJuegos;
  }

  public String getPlataforma() {
    return plataforma;
  }

  public void setPlataforma(String plataforma) {
    this.plataforma = plataforma;
  }

  public double getPrecio() {
    return 3.0;
  }

  public void vender(int precio) {
    this.precio = precio;
  }

  public Juego(String nombre, String plataforma) {
    super(nombre);
    this.plataforma = plataforma;
    contJuegos++;
  }

}
