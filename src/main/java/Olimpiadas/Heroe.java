package Olimpiadas;

public abstract class Heroe {
    private String nombre;
    private int vida;

    public Heroe(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void atacar(Freezer freezer) {
        System.out.println(this.nombre + ": Ataca");
        int daño = 10;
        freezer.restarVida(daño);
    }

    public boolean isMuerto() {
        boolean isMuerto = (this.vida <= 0);
        if (isMuerto) {
            System.out.println(nombre + ": Muerto");
        }
        return isMuerto;
    }

    public void restarVida(int daño) {
        this.vida -= daño;
        System.out.println(nombre + ": recibe " + daño + " de daño");
    }
}
