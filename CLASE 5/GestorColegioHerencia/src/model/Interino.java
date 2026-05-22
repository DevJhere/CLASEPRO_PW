package model;

public class Interino extends Profesor{
    private int aniosExperiencia;


    public Interino(){};

    public Interino(String nombre, String apellido, int salario) {
        super(nombre, apellido, salario);
        this.aniosExperiencia = 0;
    }

    public Interino(String nombre, String apellido, int salario, int aniosExperiencia) {
        super(nombre, apellido, salario);
        this.aniosExperiencia = aniosExperiencia;
    }

    public Interino(String nombre, String apellido, int salario, int numeroHoras, int aniosExperiencia) {
        super(nombre, apellido, salario, numeroHoras);
        this.aniosExperiencia = aniosExperiencia;
    }

    //Getters and Setters
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    //Funcionalidades
    @Override
    public void saludar() {
       if (aniosExperiencia>0){
           System.out.println("Soy interino y empiezo a dar clases hoy. Con pocos años de experiencia");
       }else {
           System.out.println("Soy novato");
       }

        System.out.println("Buenos días. La clase empieza ya.");
    }

    public void realizarOpsicion(){
        System.out.println("Realizando el examen de oposicion para plaza fija.");
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Años de Experiencia: " + this.aniosExperiencia);
    }
}
