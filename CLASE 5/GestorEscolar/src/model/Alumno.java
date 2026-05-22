package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Alumno {

    //Atributos
    private Asignatura asignatura1;
    private Asignatura asignatura2;
    private Asignatura asignatura3;


    public Alumno(Asignatura asignatura1, Asignatura asignatura2, Asignatura asignatura3){
        this.asignatura1 = asignatura1;
        this.asignatura2 = asignatura2;
        this.asignatura3 = asignatura3;
    }

    //Este constructor está definido mediante identificadores
    public Alumno(int id1, int id2, int id3){
        this.asignatura1 = new Asignatura(id1);
        this.asignatura2 = new Asignatura(id2);
        this.asignatura3 = new Asignatura(id3);
    }

    //Metodo mostrar datos
    public void mostrarDatos(){
        System.out.println("Imprimiendo los datos del alumno");
        asignatura1.mostrarDatos();
        asignatura2.mostrarDatos();
        asignatura3.mostrarDatos();
    }
}
