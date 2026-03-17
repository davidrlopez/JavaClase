package Trimestre2.Interfaces.Clases;

import java.util.ArrayList;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.ProductosException;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.NoMas5ProductosAlquiladosPorClienteException;
import Trimestre2.Interfaces.Excepciones.VideoClubExceptions.AlquilarException;

public class Videoclub {

  private ArrayList<Cliente> listaClientes;
  private ArrayList<ProductoVideoClub> listaProductos;
  private String nombreVideoclub = "";

  public Videoclub(String nombreVideoclub) {
    this.nombreVideoclub = nombreVideoclub;
    this.listaClientes = new ArrayList<>();
    this.listaProductos = new ArrayList<>();
  }

  public ArrayList<Cliente> getListaClientes() {
    return listaClientes;
  }

  public void setListaClientes(ArrayList<Cliente> listaClientes) {
    this.listaClientes = listaClientes;
  }

  public ArrayList<ProductoVideoClub> getListaProductos() {
    return listaProductos;
  }

  public void setListaProductos(ArrayList<ProductoVideoClub> listaProductos) {
    this.listaProductos = listaProductos;
  }

  public String getNombreVideoclub() {
    return nombreVideoclub;
  }

  public void setNombreVideoclub(String nombreVideoclub) {
    this.nombreVideoclub = nombreVideoclub;
  }

  public int getNumClientes() {
    return listaClientes.size();
  }

  public int getNumProductos() {
    return listaProductos.size();
  }

  public boolean addProducto(ProductoVideoClub productoNuevo) throws ProductosException {
    boolean added = false;
    if (listaProductos.size() >= 50) {
      throw new IllegalArgumentException("Error, el Video Club no puede tener más de 50 productos");
    }
    if (listaProductos.contains(productoNuevo)) {
      throw new ProductosException("El producto ya estaba dado de alta");
    } else {
      listaProductos.add(productoNuevo);
      added = true;
    }
    return added;
  }

  public boolean addCliente(Cliente clienteNuevo) throws ProductosException {
    boolean added = false;
    if (listaClientes.size() >= 15) {
      throw new IllegalArgumentException("Error, el Video Club no puede tener más de 15 clientes");
    }
    if (listaClientes.contains(clienteNuevo)) {
      throw new ProductosException("El cliente ya estaba dado de alta");
    } else {
      listaClientes.add(clienteNuevo);
      added = true;
    }
    return added;
  }

  public boolean alquilarProducto(Cliente cl, ProductoVideoClub pr) throws IllegalArgumentException,
      NoMas5ProductosAlquiladosPorClienteException, ProductosException, AlquilarException {
    if (!listaClientes.contains(cl)) {
      throw new IllegalArgumentException("Cliente no dado de alta");
    }
    cl.alquilarProducto(pr);
    return pr.isAlquilado();
  }

  public boolean devolverProducto(Cliente cl, ProductoVideoClub pr) throws IllegalArgumentException,
      NoMas5ProductosAlquiladosPorClienteException, ProductosException, AlquilarException {
    if (!listaClientes.contains(cl)) {
      throw new IllegalArgumentException("Cliente no dado de alta");
    }
    cl.devolverProducto(pr);
    return pr.isAlquilado();
  }

  public boolean retirarProducto(ProductoVideoClub pr) throws AlquilarException, ProductosException {
    if (!listaProductos.contains(pr)) {
      throw new ProductosException("El producto no esta registrado en este videoclub");
    }
    pr.retirar();
    return pr.isRetirado();
  }

  public boolean venderProducto(ProductoVideoClub pr, int precio) throws ProductosException {
    if (!listaProductos.contains(pr)) {
      throw new ProductosException("El producto no es de este videoclub");
    }
    if (pr instanceof Juego) {
      ((Juego) pr).vender(precio);
      return ((Juego) pr).isVendido();
    } else if (pr instanceof Pelicula) {
      ((Pelicula) pr).vender(precio);
      return ((Pelicula) pr).isVendido();
    }
    return false;
  }

  public Cliente devolverCliente(Cliente c) {
    int index = listaClientes.indexOf(c);
    if (index != -1) {
      return listaClientes.get(index);
    }
    return null;
  }

  public void mostrarProductosAgrupadosPorTipo() {
    System.out.println("--- PELICULAS ---");
    for (ProductoVideoClub p : listaProductos) {
      if (p instanceof Pelicula) {
        System.out.println(p);
      }
    }
    System.out.println("--- CDs ---");
    for (ProductoVideoClub p : listaProductos) {
      if (p instanceof CD) {
        System.out.println(p);
      }
    }
    System.out.println("--- JUEGOS ---");
    for (ProductoVideoClub p : listaProductos) {
      if (p instanceof Juego) {
        System.out.println(p);
      }
    }
  }

  public double obtenerPrecioTotalProductosAlquilados() {
    double total = 0;
    for (Cliente c : listaClientes) {
      for (ProductoVideoClub p : c.getProductosAlquilados()) {
        total += p.getPrecio();
      }
    }
    return total;
  }

  public void mostrarPrecioProductosAlquiladosPorClientes() {
    for (Cliente c : listaClientes) {
      double totalCliente = 0;
      for (ProductoVideoClub p : c.getProductosAlquilados()) {
        totalCliente += p.getPrecio();
      }
      System.out.println("Cliente: " + c.getNombreCliente() + " - Precio total alquileres: " + totalCliente + "€");
    }
  }

  public void mostrarDuracionPeliculasIdioma(String idioma) {
    System.out.println("Duraciones de peliculas en idioma " + idioma + ":");
    boolean encontradas = false;
    for (ProductoVideoClub p : listaProductos) {
      if (p instanceof Pelicula) {
        Pelicula pelicula = (Pelicula) p;
        if (pelicula.getIdioma().name().equalsIgnoreCase(idioma)) {
          System.out.println("- " + pelicula.getNombre() + ": " + pelicula.getDuracion() + " minutos.");
          encontradas = true;
        }
      }
    }
    if (!encontradas) {
      System.out.println("No se encontraron peliculas en ese idioma.");
    }
  }

  public void mostrarGeneroPeliculasAlquiladasPor(Cliente c) {
    if (!listaClientes.contains(c)) {
      System.out.println("El cliente no esta registrado.");
      return;
    }
    System.out.println("Generos de peliculas alquiladas por " + c.getNombreCliente() + ":");
    boolean encontradas = false;
    for (ProductoVideoClub p : c.getProductosAlquilados()) {
      if (p instanceof Pelicula) {
        Pelicula pelicula = (Pelicula) p;
        System.out.println("- " + pelicula.getNombre() + ": " + pelicula.getGenero());
        encontradas = true;
      }
    }
    if (!encontradas) {
      System.out.println("Este cliente no tiene peliculas alquiladas.");
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("=== VIDEOCLUB: ").append(nombreVideoclub).append(" ===\n");
    sb.append("--- PRODUCTOS ---\n");
    for (ProductoVideoClub p : listaProductos) {
      sb.append(p.toString()).append("\n");
    }
    sb.append("--- CLIENTES ---\n");
    for (Cliente c : listaClientes) {
      sb.append(c.toString()).append("\n");
    }
    return sb.toString();
  }
}
