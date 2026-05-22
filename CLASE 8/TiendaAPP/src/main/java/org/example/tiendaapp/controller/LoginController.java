package org.example.tiendaapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.tiendaapp.HelloApplication;
import org.example.tiendaapp.data.DataSet;
import org.example.tiendaapp.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Metodo que recoge todas las funcionalides o acciones de la parte grafica
        actions();
    }

    private void actions() {
        btnLogin.setOnAction(event -> {
            //Validacion de los campos rellenos Correo y Pass
            String correo =  txtCorreo.getText();
            String pass = txtPassword.getText();
            //TODO el filtrado de las lista o de la BD (CRUD)
            User user = DataSet.getLogin(correo, pass);


            if (correo.isEmpty() || pass.isEmpty()){
                Alert dialogPane = new Alert(Alert.AlertType.WARNING);

                dialogPane.setHeaderText("¡Aviso!");
                dialogPane.setContentText("Debe completar los campos.");
                dialogPane.show();
            }

            if (user != null){
                //Crea una nueva ventana
                Stage ventanaPrincipal = new Stage();

                //Carga Parte Gráfica;
                try {
                    FXMLLoader fxmlLoader;
                    switch (user.getPerfil().toLowerCase()){
                        case "admin":
                            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("form-view.fxml"));
                            ventanaPrincipal.setTitle("Formulario de Administración");
                            break;
                        case "usuario":
                            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tienda-clase-view.fxml"));
                            ventanaPrincipal.setTitle("Tienda de Productos");
                            System.out.println(user.getNombre());
                            break;
                        default:
                            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("form-view.fxml"));
                    }

                    //Crea una nueva escena
                    Scene scene =  new Scene(fxmlLoader.load());
                    ventanaPrincipal.setScene(scene);
                    ventanaPrincipal.show();
                    ((Stage) (btnLogin.getScene().getWindow())).close();

                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }


            }else {
                Alert dialogPane = new Alert(Alert.AlertType.WARNING);

                dialogPane.setHeaderText("¡Aviso!");
                dialogPane.setContentText("Correo o Password incorrectos.");
                dialogPane.show();
            }
        });
    }

}
