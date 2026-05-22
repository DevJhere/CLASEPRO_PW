package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Profesor {
    //No tengo atributos -> El constructor default está implícito
    public Profesor() {

    }

    //Metodos
    public void ponerNotas(Alumno alumno){
        alumno.getAsignatura1().setCalificacion((Math.random() * 10) + 0.1 );
        alumno.getAsignatura2().setCalificacion((Math.random() * 10) + 0.1 );
        alumno.getAsignatura3().setCalificacion((Math.random() * 10) + 0.1 );
    }

    public double calcularMedia(Alumno alumno){
        double media = alumno.getAsignatura1().getCalificacion() +
                alumno.getAsignatura2().getCalificacion() +
                alumno.getAsignatura3().getCalificacion();

        return media/3;
    }
}
