/*
   * Enunciado: Modela asignaturas de un alumno y un profesor que pone notas y calcula la media.

   - Asignatura: identificador, calificación; constructor con id; getters y setter de calificación.
   - Alumno: tres Asignatura; constructores con 3 Asignatura o con 3 ids.
   - Profesor: ponerNotas(Alumno) asigna aleatorias; calcularMedia(Alumno) devuelve double.
   - Entrada: crear 3 Asignaturas, 1 Alumno, 1 Profesor; poner notas y mostrar media y notas.*/

import model.Alumno;
import model.Asignatura;
import model.Profesor;

public class Main {
    public static void main(String[] args) {
        // UML -> Lenguaje Universal de Modelado. Diagrama de clases -> Nos define que relación hay entre las clases para poder determinar la solución.

        //Instanciamos
        Asignatura programacion = new Asignatura(1); // tiene las caracteristicas id(0) y calificacion(0.0)

        Asignatura sistemas = new Asignatura(2);
        Asignatura entornos = new Asignatura(3);
        Asignatura baseDatos = new Asignatura();
        Asignatura fundamentos = new Asignatura();

       // System.out.println("La calificacion de programacion es" + programacion.getId()); //Devuelve su identificador
        sistemas.mostrarDatos();
        baseDatos.mostrarDatos();

        //Instanciamos la clase Alumno
        Alumno paco = new Alumno(programacion,sistemas, entornos);
        Alumno marcos = new Alumno(programacion, sistemas, entornos);
        Alumno maria = new Alumno(programacion, sistemas, entornos);

        //Objeto nuevo pero crado con un constructor id
        Alumno celia =  new Alumno(1,2,3);

        System.out.println("Se compueba notas");
        System.out.println("Marcos: ");
        marcos.mostrarDatos();

        System.out.println("Se compueba notas");
        System.out.println("Celia: ");
        celia.mostrarDatos();

        System.out.println("Procedemos a poner notas");
        Profesor profesor = new Profesor();
        profesor.ponerNotas(marcos);
        profesor.ponerNotas(celia);
     }
}
