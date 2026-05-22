package model;

public class Director extends Persona implements  Inspector{

    public Director(){

    }

    public Director(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void saludar() {
        System.out.println("Soy el director del Colegio");
    }

    @Override
    public void realizarInspeccion() {
        System.out.println("Soy el jefe de inspección.");
    }
}
