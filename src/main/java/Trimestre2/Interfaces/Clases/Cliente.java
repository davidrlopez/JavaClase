package Trimestre2.Interfaces.Clases;

import java.util.ArrayList;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.NoMas5ProductosAlquiladosPorClienteException;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.AlquilarException;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.ProductosException;

public class Cliente {

  private ArrayList<ProductoVideoClub> productosAlquilados;
  private int idCliente;
  private static int contCliente = 0;
  private String nombreCliente = "";

  public ArrayList<ProductoVideoClub> getProductosAlquilados() {
    return productosAlquilados;
  }

  public void setProductosAlquilados(ProductoVideoClub producto)
      throws NoMas5ProductosAlquiladosPorClienteException {
    if (getProductosAlquilados().size() < 5) {

      this.productosAlquilados.add(producto);
    } else {
      throw new NoMas5ProductosAlquiladosPorClienteException("Limite de 5 productos alquilados alcanzado");
    }
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public static int getContCliente() {
    return contCliente;
  }

  public static void setContCliente(int contCliente) {
    Cliente.contCliente = contCliente;
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  public Cliente(String nombreCliente) {
    this.productosAlquilados = new ArrayList<>();
    contCliente++;
    this.idCliente = contCliente;
    this.nombreCliente = nombreCliente;
  }

  public boolean alquilarProducto(ProductoVideoClub alquilable)
      throws AlquilarException, ProductosException, NoMas5ProductosAlquiladosPorClienteException {
    if (alquilable.isAlquilado() == false) {
      setProductosAlquilados(alquilable);
      alquilable.alquilar();
    } else {
      throw new ProductosException(
          "El producto con ID:" + alquilable.getId() + " y nombre:" + alquilable.getNombre() + " ya esta alquilado");
    }
    return alquilable.isAlquilado();
  }

  public boolean devolverProducto(ProductoVideoClub devolvible) throws AlquilarException {
    if (this.productosAlquilados.contains(devolvible)) {
      productosAlquilados.remove(devolvible);
      devolvible.devolver();
    } else {
      throw new AlquilarException("El producto con ID:" + devolvible.getId() + " y con nombre:" + devolvible.getNombre()
          + " no se ha podido devolver");
    }
    return !devolvible.isAlquilado();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Cliente: ").append(nombreCliente).append(" (ID: ").append(idCliente).append(")\n");
    sb.append("Productos alquilados:\n");
    if (productosAlquilados.isEmpty()) {
      sb.append("  Ninguno\n");
    } else {
      for (ProductoVideoClub p : productosAlquilados) {
        sb.append("  - [ID: ").append(p.getId()).append("] ").append(p.getNombre()).append("\n");
      }
    }
    return sb.toString();
  }

}
