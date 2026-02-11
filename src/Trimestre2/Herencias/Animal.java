package Trimestre2.Herencias;

public class Animal {
    private int peso;
    private Fecha fechaNac;

    // Constructors
    public Animal(int peso, int dia, int mes, int anyo) {
        setAnimal(peso, dia, mes, anyo);
    }

    public Animal(int peso, Fecha fecha) {
        setAnimal(peso, fecha);
    }

    public Animal(Animal animal) {
        setAnimal(animal);
    }

    public Animal() {
        this.peso = 0;
        this.fechaNac = new Fecha(); // Fecha default
    }

    // Methods
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        if (peso < 0 || peso > 5000) {
            System.out.println("Error: El peso debe estar entre 0 y 5000. Se asigna 0 por defecto.");
            this.peso = 0;
        } else {
            this.peso = peso;
        }
    }

    public Fecha getFecha() {
        return fechaNac;
    }

    public void setFecha(Fecha fecha) {
        this.fechaNac = fecha;
    }
    
    // Helper to set date components safely
    public void setFecha(int dia, int mes, int anyo) {
        try {
            this.fechaNac = new Fecha(dia, mes, anyo);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la fecha: " + e.getMessage() + ". Se asigna fecha por defecto.");
            this.fechaNac = new Fecha();
        }
    }

    public void setAnimal(int peso, int dia, int mes, int anyo) {
        setPeso(peso);
        setFecha(dia, mes, anyo);
    }

    public void setAnimal(int peso, Fecha fecha) {
        setPeso(peso);
        setFecha(fecha);
    }

    public void setAnimal(Animal animal) {
        if (animal != null) {
            setPeso(animal.getPeso());
            setFecha(animal.getFecha()); // Should probably clone if mutable, but assignment is standard unless deep copy needed
        }
    }
}
