package Trimestre2.ExamenNetflix.SubClases;

import Trimestre2.ExamenNetflix.ExceptionsNetflix.GeneroException;
import Trimestre2.ExamenNetflix.ExceptionsNetflix.PrecioException;
import Trimestre2.ExamenNetflix.Clases.Producto;

public class Videojuego extends Producto {
    private int numVideojuego;
    private String genero = "DRAMA";
    private static double tipoIVA = 0.04;

    public int getNumVideojuego() {
        return numVideojuego;
    }

    public void setNumVideojuego(int numVideojuego) {
        this.numVideojuego = numVideojuego;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) throws GeneroException {
        validarGenero(genero);
        this.genero = genero;
    }

    private void validarGenero(String genero) throws GeneroException {
        if (!genero.toUpperCase().equals("DRAMA") && !genero.toUpperCase().equals("COMEDIA")
                && !genero.toUpperCase().equals("TERROR") && !genero.toUpperCase().equals("BELICA")
                && !genero.toUpperCase().equals("ANIMACION")) {
            throw new GeneroException("Genero desconocido");
        }
    }

    public double getTipoIVA() {
        return Videojuego.tipoIVA;
    }

    public void setTipoIVA(double tipoIVA) {
        Videojuego.tipoIVA = tipoIVA;
    }

    public Videojuego(Producto otro) throws PrecioException {
        super(otro);
        numVideojuego++;
    }

    public Videojuego(String nombreProd, int idProd, boolean alquilado, double precioAqluiler, int numVideojuegoTry,
            String genero, double tipoIVA) throws PrecioException, GeneroException {
        super(nombreProd, idProd, alquilado, precioAqluiler);
        numVideojuegoTry = numVideojuego++;
        validarGenero(genero);
        this.genero = genero;
        Videojuego.tipoIVA = tipoIVA;
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
        return getPrecioSinIVA() + (getPrecioSinIVA() * Videojuego.tipoIVA);
    }

    @Override
    public boolean estaAlquilado() {
        return isAlquilado();
    }

    @Override
    public String toString() {
        return "Nombre del producto:" + getNombreProd() + " ID:" + getIdProd() + " estado alquiler:"
                + isAlquilado() + " precio sin iva:" + getPrecioSinIVA() + " numVideojuego:" + getNumVideojuego()
                + " genero:" + getGenero() + " tipoIVA:" + getTipoIVA() + " precio total con IVA:"
                + PrecioAlquilerIVA();

    }
}
