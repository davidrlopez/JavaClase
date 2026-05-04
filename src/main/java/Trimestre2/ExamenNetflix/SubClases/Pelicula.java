package Trimestre2.ExamenNetflix.SubClases;

import Trimestre2.ExamenNetflix.ExceptionsNetflix.DateFaultException;
import Trimestre2.ExamenNetflix.ExceptionsNetflix.GeneroException;
import Trimestre2.ExamenNetflix.ExceptionsNetflix.PrecioException;
import Trimestre2.ExamenNetflix.ExceptionsNetflix.DuracionException;
import Trimestre2.ExamenNetflix.Clases.Producto;
import Trimestre2.ExamenNetflix.Interfaces.*;

public class Pelicula extends Producto implements Vendible {
    private int numPelicula;
    private String fechaPelicula = "01/01/1700";
    private String generoPelicula = "DRAMA";
    private int duracion;
    private static double tipoIVA = 0.21;
    private boolean vendida;
    private double precioVenta;

    public int getNumPelicula() {
        return numPelicula;
    }

    public void setNumPelicula(int numPelicula) {
        this.numPelicula = numPelicula;
    }

    public String getFechaPelicula() {
        return fechaPelicula;
    }

    public static boolean fechaValida(String fechaPelicula) throws DateFaultException {
        boolean isValida = false;
        if (fechaPelicula.length() == 10 && fechaPelicula.charAt(2) == '/' && fechaPelicula.charAt(5) == '/') {
            isValida = true;
        } else {
            throw new DateFaultException("El formato de fecha debe ser XX/XX/XXXX y de valores positivos");
        }
        return isValida;
    }

    public void setFechaPelicula(String fechaPelicula) throws DateFaultException {
        if (!fechaValida(fechaPelicula)) {
            throw new DateFaultException("Fecha con formato incorrecto");
        }
        this.fechaPelicula = fechaPelicula;
    }

    public String getGeneroPelicula() {
        return generoPelicula;
    }

    public void setGeneroPelicula(String generoPelicula) throws GeneroException {
        validarGeneroPelicula(generoPelicula);
        this.generoPelicula = generoPelicula;
    }

    private void validarGeneroPelicula(String generoPelicula) throws GeneroException {
        if (!generoPelicula.toUpperCase().equals("DRAMA") && !generoPelicula.toUpperCase().equals("COMEDIA")
                && !generoPelicula.toUpperCase().equals("TERROR") && !generoPelicula.toUpperCase().equals("BELICA")
                && !generoPelicula.toUpperCase().equals("ANIMACION")) {
            throw new GeneroException("Genero desconocido");
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) throws DuracionException {
        validarDuracion(duracion);
        this.duracion = duracion;
    }

    private void validarDuracion(int duracion) throws DuracionException {
        if (duracion <= 0) {
            throw new DuracionException("La duracion no puede ser negativa");
        }
    }

    public static double getTipoIVA() {
        return tipoIVA;
    }

    public static void setTipoIVA(double tipoIVA) {
        Pelicula.tipoIVA = tipoIVA;
    }

    @Override
    public boolean estaVendido() {
        return vendida;
    }

    public void setVendida(boolean vendida) throws IllegalArgumentException {
        validarVendida();
        this.vendida = vendida;
    }

    private void validarVendida() throws IllegalArgumentException {
        if (isAlquilado()) {
            throw new IllegalArgumentException("El producto esta actualmente alquilado");
        }
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Pelicula(Producto otro) throws PrecioException, DateFaultException, GeneroException, DuracionException {
        super(otro);
        numPelicula++;
        fechaValida(fechaPelicula);
        validarGeneroPelicula(generoPelicula);
        validarDuracion(duracion);
        validarVendida();
        this.fechaPelicula = fechaPelicula;
        this.generoPelicula = generoPelicula;
        this.duracion = duracion;
        this.vendida = vendida;
        this.precioVenta = precioVenta;
    }

    public Pelicula(String nombreProd, int idProd, boolean alquilado, double precioAqluiler, int numPeliculaTry,
            String fechaPelicula, String generoPelicula, int duracion, boolean vendida, double precioVenta)
            throws PrecioException, DateFaultException, GeneroException, DuracionException {
        super(nombreProd, idProd, alquilado, precioAqluiler);
        numPelicula++;
        fechaValida(fechaPelicula);
        validarGeneroPelicula(generoPelicula);
        validarDuracion(duracion);
        validarVendida();
        this.fechaPelicula = fechaPelicula;
        this.generoPelicula = generoPelicula;
        this.duracion = duracion;
        this.vendida = vendida;
        this.precioVenta = precioVenta;
    }

    public Pelicula() {
        super();
    }

    @Override
    public boolean alquilar() throws IllegalArgumentException {
        if (isAlquilado()) {
            throw new IllegalArgumentException("Ya estaba alquilado");
        }
        setAlquilado(true);
        return isAlquilado();
    }

    @Override
    public boolean devolver() throws IllegalArgumentException {
        if (!isAlquilado()) {
            throw new IllegalArgumentException("No estaba alquilado");
        }
        setAlquilado(false);
        return isAlquilado();
    }

    @Override
    public double PrecioAlquilerIVA() {
        return super.getPrecioSinIVA() + (super.getPrecioSinIVA() * Pelicula.tipoIVA);
    }

    @Override
    public boolean estaAlquilado() {
        return isAlquilado();
    }

    @Override
    public boolean vender() {
        if (vendida) {
            return false;
        }
        try {
            setVendida(true);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return estaVendido();
    }

    @Override
    public double precioVentaIVA() {
        return precioVenta + (precioVenta * Pelicula.tipoIVA);
    }

    @Override
    public String toString() {
        return "Nombre del producto:" + getNombreProd() + " ID:" + getIdProd() + " estado alquiler:"
                + isAlquilado() + " precio alquiler sin iva:" + super.getPrecioSinIVA() + " numPelicula:"
                + getNumPelicula()
                + " genero:" + getGeneroPelicula() + " tipoIVA:" + Pelicula.getTipoIVA()
                + " precio alquiler total con IVA:"
                + PrecioAlquilerIVA() + " precio total venta con IVA:" + precioVentaIVA();

    }

}
