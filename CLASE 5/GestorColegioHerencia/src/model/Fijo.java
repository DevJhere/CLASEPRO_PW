package model;

public class Fijo extends Profesor implements Inspector{
    private int numHCotizadas;

    public Fijo() {
    }

    public Fijo(String nombre, String apellido, int salario) {
        super(nombre, apellido, salario);
        this.numHCotizadas = 0;
    }

    public Fijo(String nombre, String apellido, int salario, int numeroHoras, int numHCotizadas) {
        super(nombre, apellido, salario, numeroHoras);
        this.numHCotizadas = numHCotizadas;
    }

    //getters y setters
    public int getNumHCotizadas() {
        return numHCotizadas;
    }

    public void setNumHCotizadas(int numHCotizadas) {
        this.numHCotizadas = numHCotizadas;
    }

    //Funcionalidades
    @Override
    public void saludar() {
        System.out.println("Profesor fijo");
        System.out.println("Mi puesto no me lo quita nadie");
    }

    public void pedirAumento(int aumento){
        setSalario(getSalario() + aumento);
        System.out.println("Salario Aumentado");
    }

    @Override
    public void realizarInspeccion() {
        System.out.println("Inspección de profesor Fijo");
    }
}
