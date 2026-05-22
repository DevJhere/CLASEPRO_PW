package model;

public abstract class Persona { //Si hay un metodo Abstracta la clase debe ser Abstracta
    //Atributos
    private String nombre, apellido;

    //Constructor
    public Persona(){}

    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Getters and Setters
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodos-Funcionalidades
    public abstract void saludar(); //Metodo que queremos que se va a ejecutar por los hijos obligatorios

    public void mostrarDatos(){
        System.out.println("nombre: " + nombre);
        System.out.println("apellido: " + apellido);
    }


}
