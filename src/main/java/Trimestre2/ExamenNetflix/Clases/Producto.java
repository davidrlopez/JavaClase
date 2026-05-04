package Trimestre2.ExamenNetflix.Clases;

import Trimestre2.ExamenNetflix.Interfaces.Alquilable;
import Trimestre2.ExamenNetflix.ExceptionsNetflix.PrecioException;

public abstract class Producto implements Alquilable {

    private String nombreProd;
    private int idProd;
    private boolean alquilado;
    private double precioAqluiler;

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    public double getPrecioSinIVA() {
        return precioAqluiler;
    }

    public void setPrecioSinIVA(double precioAqluiler) throws PrecioException {
        validarPrecioSinIVA(precioAqluiler);
        this.precioAqluiler = precioAqluiler;
    }

    private void validarPrecioSinIVA(double precioAqluiler) throws PrecioException {
        if (precioAqluiler < 0) {
            throw new PrecioException("Precio no puede ser negativo");
        }
    }

    public Producto(String nombreProd, int idProd, boolean alquilado, double precioAqluiler) throws PrecioException {
        validarPrecioSinIVA(precioAqluiler);
        this.nombreProd = nombreProd;
        this.idProd = idProd;
        this.alquilado = alquilado;
        this.precioAqluiler = precioAqluiler;
    }

    public Producto(Producto otro) throws PrecioException {
        validarPrecioSinIVA(otro.precioAqluiler);
        nombreProd = otro.nombreProd;
        idProd = otro.idProd;
        alquilado = otro.alquilado;
        precioAqluiler = otro.precioAqluiler;
    }

    public Producto() {

    }

    @Override
    public String toString() {
        return "Nombre del producto:" + getNombreProd() + " ID:" + getIdProd() + " estado alquiler:"
                + isAlquilado() + " precio sin iva:" + getPrecioSinIVA();
    }

}
