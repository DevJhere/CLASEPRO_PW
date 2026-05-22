package model;

//Nadie puede heredar de Alumno con final
public final class Alumno extends Persona{

    //Atributos
    private int numeroMatricula;
    private int cursoMatriculado;

    //Hereadamos los getter/setter y metodos de Persona
    //Constructores
    public Alumno(String nombre, String apellido, int numeroMatricula){
        super(nombre, apellido);
        this.numeroMatricula = numeroMatricula;
    }

    public Alumno(String nombre, String apellido, int numeroMatricula, int cursoMatriculado){
        super(nombre, apellido);
        this.numeroMatricula = numeroMatricula;
        this.cursoMatriculado = cursoMatriculado;
    }

    //Getter and setter

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public int getCursoMatriculado() {
        return cursoMatriculado;
    }

    public void setCursoMatriculado(int cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }

    //Metodos para sobrescribir - En caso de que se vaya a cambiar el comportamiento de las funcionalidades
    @Override
    public void mostrarDatos() {
        super.mostrarDatos(); //Llama al metodo mostrarDatos() del Padre
        System.out.println("Numero Matricula: "  + numeroMatricula);
        System.out.println("Curso Matriculado: "  + cursoMatriculado);
    }

    @Override
    public void saludar() {
        System.out.println("Soy alumno y digo: Buenos Días.");
    }

    public void realizarExamen(){
        System.out.println("Examen en proceso.....");
        int nota = (int) (Math.random() * 11);
        System.out.println("La nota es : " + nota);
    }
}
