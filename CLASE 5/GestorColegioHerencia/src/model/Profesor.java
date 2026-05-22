package model;

public abstract class Profesor extends Persona{

    private  int salario;
    private int numeroHoras;

    public Profesor (){}

    public Profesor (String nombre, String apellido, int salario){
        super(nombre, apellido);
        this.salario = salario;
    }

    public Profesor (String nombre, String apellido, int salario, int numeroHoras){
        super(nombre, apellido);
        this.salario = salario;
        this.numeroHoras = numeroHoras;
    }


    //Getters y Setters


    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    //Funcionalidades
    //Tengo un método abstracto
    //saludar(); heredado de Persona - Si quiero emplear este método lo utilizo sino no.
    //@Override
    //public void saludar() {
    //System.out.println("Soy profesor y voy a impartir la clase");
    //}

    public void corregirExamen(){
        System.out.println("Examen corregido");
        System.out.println("Nota finalizada.");
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("salario: " + this.salario);
        System.out.println("número de horas: " + this.numeroHoras);
    }


}
