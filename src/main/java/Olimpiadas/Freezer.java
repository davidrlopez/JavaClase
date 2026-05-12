package Olimpiadas;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author david
 */
public class Freezer {

    private int vida;
    private String nombre;

    public Freezer(String nombre, int vida) {
        this.vida = vida;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void restarVida(int daño) {
        this.vida -= daño;
        System.out.println(nombre + ": recibe " + daño + " de daño");
    }

    public boolean isMuerto() {
        boolean isMuerto = this.vida <= 0;
        if (isMuerto) {
            System.out.println(nombre + ": Muerto");
        }
        return isMuerto;
    }

    public void atacar(Heroe heroe) {
        int daño = 10;
        System.out.println(nombre + ": Ataca a " + heroe.getNombre());
        heroe.restarVida(daño);
    }
}
