package org.example.tiendaapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    //Necesitamos un Id: para poder acceder a los elementos
    //Una variable por cada uno de los elementos del fxml

    @FXML //Esto sirve para linkear la parte gráfica, si no sale es porque no se ha puesto correctamente el nombre del id
    //o no se ha realizado esto -> fx:controller="org.example.tiendaapp.controller.MainController"
    private Button botonSaludar; //Debe ser idéntico al id de la parte grafica

    @FXML
    private TextField nombre;

    @FXML
    private Text textoSaludo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Todos los códigos que se pongan aquí, se ejecutan nada más cargar la parte fxml del fichero
        //fx:controller="org.example.tiendaapp.controller.MainController" -> Esto hace que la parte gráfica sea controlada por la parte lógica, es decir ahora trabajan en conjunto.
        botonSaludar.setOnAction( event-> { //Evento que se va a realizar
            //Ejecución del Código
            String texto = nombre.getText();
            if (texto.isEmpty()){
                textoSaludo.setFill(Color.RED); //Letras Rojas de Error
                textoSaludo.setText("No hay nadie a quien saludar");
            }else {
                textoSaludo.setFill(Color.GREEN);
                textoSaludo.setText("Enhorabuena " + texto + " has completado la primera App JAVA FX");
                nombre.clear(); //Borra el nombre del Texfield para poder asignar otro nombre
            }

        });
    }
}
