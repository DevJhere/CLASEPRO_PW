package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

//Uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class Liga implements Serializable {

    //Definimos atributos si o si deben ser identico a los representados en el JSON de la API que queremos usar.
    private String idLeague, strLeague, strSport;

    @Override
    public String toString() {
        return String.format("%s - %s", idLeague, strLeague);
    }
}
