package org.example.tiendaapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {// Permite crear la primera ventana -> Se añade una ventana fxml
        //Carga la ventana gráfica en el FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-clase-view.fxml"));
        //Crea la escena y le asocia la parte gráfica y
        Scene scene = new Scene(fxmlLoader.load(), 840, 720);
        //pone la escena en la ventana
        stage.setScene(scene);
        //Pone el titulo en la ventana
        stage.setTitle("Tienda The Power!");
        //Muestra la ventana
        stage.show();
    }
}
