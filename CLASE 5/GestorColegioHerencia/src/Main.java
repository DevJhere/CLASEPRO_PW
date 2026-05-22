import model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Instanciamos Objeto Persona
        Alumno pedro = new Alumno("Pedro", "Gomez" , 1, 101);
        //Polimorfismo - Ya que persona no puede acceder a los métodos a de la subclase.
        Persona pedro2 = new Alumno("Pedro", "Gomez" , 1, 101);
        Alumno pedro3 = new Alumno("Pedro", "Gomez" , 1, 101);

        Interino interino = new Interino("Roberto", "Gonzalez", 20000, 1);
        Interino interino2 = new Interino("Maria", "Rodriguez", 24000, 1);

        Fijo fijo1 = new Fijo("Celia", "Gomez", 20000, 20, 50);
        Fijo fijo2 = new Fijo("Celia", "Gomez", 30000, 30, 50);


        Director director1 =  new Director("Bills", "Towers");

        //Lista Alumnos
        //Podemos añadira los elenentos tabto como de alumnos o profesores
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(pedro);
        listaPersonas.add(pedro2);
        listaPersonas.add(pedro3);

        listaPersonas.add(interino);
        listaPersonas.add(interino2);
        listaPersonas.add(fijo1);
        listaPersonas.add(fijo2);
        listaPersonas.add(director1);

        fijo2.realizarInspeccion();
        director1.realizarInspeccion();

        for (Persona persona:listaPersonas){
            //Ejecuta de forma lineal los metodos correspondiente en persona de alumnos o profesor
//            persona.saludar();
//            persona.mostrarDatos();
            if (persona instanceof Inspector){
                ((Inspector)persona).realizarInspeccion();
            }

          }
//
//            if (persona instanceof  Alumno){
//                //Solo se puede llamar desde un alumno
//                ((Alumno) persona).realizarExamen();
//            } else if (persona instanceof  Profesor) {
//                //Solo se puede llamar desde un profesor
//                ((Profesor) persona).corregirExamen();
//            }
//
//
//        }

        //Persona alumno2 = new Alumno("Maria", "Lopez", 2);

        //Heredados y Polimorfismo
        //alumno2.mostrarDatos();
        //((Alumno)alumno2).realizarExamen();

//        pedro.mostrarDatos();
//        pedro.saludar();
//        pedro.realizarExamen();



        //Interino
        interino.saludar();
        interino.mostrarDatos();

        interino2.saludar();
        interino2.mostrarDatos();

        fijo2.mostrarDatos();
        fijo2.pedirAumento(1000);
        fijo2.mostrarDatos();
    }
}
