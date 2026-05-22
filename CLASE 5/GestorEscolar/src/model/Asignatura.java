package model;

import lombok.Getter;
import lombok.Setter;

//Libreria para ahorrarnos escribir getter and setters
@Getter
@Setter

public class Asignatura {
    //Atributos
    private int id;
    private double calificacion;

    //Constructor por defecto queda de lado cuando se escribe explicitamente un constructor
    public Asignatura(){

    }

    public Asignatura(int id){
        this.id = id;
    }

    //Metodos
    public void mostrarDatos(){
        System.out.println("La calificacion de las asignaturas");
        System.out.println("La asignatura es :" + id); //Devuelve su identificador
        System.out.println("La calificacion de programacion es" + calificacion); //Devuelve su identificador
    }

//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setCalificacion(double calificacion) {
//        this.calificacion = calificacion;
//    }
}
