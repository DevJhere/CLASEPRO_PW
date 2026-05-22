package org.example.tiendaapp.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.tiendaapp.HelloApplication;
import org.example.tiendaapp.data.DataSet;
import org.example.tiendaapp.model.User;

import javax.swing.*;

public class FormController implements Initializable {

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnComprobar;

    @FXML
    Button btnEliminar;

    @FXML
    private Button btnVaciar;

    @FXML
    private CheckBox checkLista;

    @FXML
    private ComboBox<String> comboTipo;//Definimos el tipo que queremos manejar si dejas ? maneja Objetos
    //Lista de elemento
    private ObservableList<String> perfiles; //ObservableList es el ArrayList de JAVAFX

    @FXML
    private TextField editApellido;

    @FXML
    private TextField editDni;

    @FXML
    private TextField editNombre;

    @FXML
    private TextField editEmail;

    @FXML
    private TextField editPass;

    @FXML
    private RadioButton radioFem;

    @FXML
    private RadioButton radioMasc;

    @FXML
    private ListView<User> listViewUsers;
    @FXML
    ObservableList<User> listaUsers;

    @FXML
    private BorderPane bordeGeneral;

    @FXML
    private Button btnCerrar;

    @FXML
    private Spinner<?> spinnerEdad;
    private SpinnerValueFactory modelEdad;

    private DropShadow shadow;
    private ToggleGroup grupoGenero;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Instancias para poder iniciar los metodos o atributos que noe estan definido en el XML
        instances();

        //Metodo actions para llamar a todas las acciones
        actions();

        //Inicio del GUI
        initGUI();
    }

    private void initGUI() {
        //Cuando iniciamos la interfaz grafica el radio button inicia en el que selecciones
        listViewUsers.setItems(DataSet.getListUser()); //Cuando iniciamos la parte gráfica pasamos la lista de usuarios
        grupoGenero.getToggles().addAll(radioMasc, radioFem);
        radioFem.setSelected(true);
        comboTipo.setItems(perfiles);
        spinnerEdad.setValueFactory(modelEdad);
        if (checkLista.isSelected()) {
            bordeGeneral.setRight(listViewUsers);
        } else {
            bordeGeneral.setRight(null);
        }
    }

    private void instances() {
        shadow = new DropShadow();
        grupoGenero = new ToggleGroup();
        perfiles = FXCollections.observableArrayList();
        listaUsers = FXCollections.observableArrayList();
        perfiles.addAll("Administrador", "Usuario", "Trabajador");
        modelEdad = new SpinnerValueFactory.IntegerSpinnerValueFactory(18, 90, 18, 1);
    }

    private void actions() {

        //Funcionalidades del los Botones - EventHandler solo maneja acciones de click - Con estas funcionalidades podremos comprobar que acción realiza cada botón
        //Botones realizan funcionalidades diferentes

        //Accesos de setOnAction de Forma Directa
        btnAgregar.setOnAction(event -> {

            if (editNombre.getText().isEmpty()
                    || editPass.getText().isEmpty()
                    || editApellido.getText().isEmpty()
                    || editEmail.getText().isEmpty()
                    || editDni.getText().isEmpty()
                    || grupoGenero.getSelectedToggle() == null
                    || comboTipo.getSelectionModel().getSelectedIndex() == -1) {
                //Si los campos están vacios, creamos una aletar que nos muestra el siguiente mensaje
                //Crea un evento modal, es decir hasta que no finalice el evento de la ventan creada no se puede continuar
                Alert dialogPane = new Alert(Alert.AlertType.WARNING);

                dialogPane.setHeaderText("Faltan datos");
                dialogPane.setContentText("Por favor, comprueba todos los datos.");
                dialogPane.show();
            } else { //En caso contrario se crea el usuario

                // Lo que se escriba aquí en código se ejecuta después de la pulsación del botón
                String nombre = editNombre.getText();
                String apellido = editApellido.getText();
                String dni = editDni.getText();
                String correo = editEmail.getText();
                String pass = editPass.getText();
                String perfil = comboTipo.getSelectionModel().getSelectedItem();
                int edad = (int) spinnerEdad.getValue();
                String genero = ((RadioButton) grupoGenero.getSelectedToggle()).getText(); //Como es de tipo RadioButton casteamos para coger el texto del Radio Button

                //String nombre, String apellido, String correo, String pass, String dni, String genero, int edad
                User user = new User(nombre, apellido, correo, pass, dni, genero, perfil, edad);

                //listaUsers.add(user);
                //TODO USUARIO A UNA LISTA
                DataSet.addUser(user); //Al haber creado la lista "Global" podremos acceder desde otros elementos.

                //Podremos saber quien ha generado el evento
                //event.getSource(); //->btnAgregar

                Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);

                dialogPane.setHeaderText("Datos Correctos");
                dialogPane.setContentText("Usuario añadido correctamente");
                dialogPane.show();
                clearFields();
            }

        });
        btnVaciar.setOnAction(event -> {
            // Lo que se escriba aquí en código se ejecuta después de la pulsación del botón
            //System.out.println("Pulsado el boton vaciar");
            //event.getSource(); //->btnVaciar

            clearFields();

        });
        btnComprobar.setOnAction(event -> {
            // Lo que se escriba aquí en código se ejecuta después de la pulsación del botón
            User user = listViewUsers.getSelectionModel().getSelectedItem(); //Pedimos un usuario de la lista seleccionada
            System.out.println(user.getNombre());
            System.out.println(user.getCorreo());

            if (user == null) {
                Alert dialogPane = new Alert(Alert.AlertType.ERROR);
                dialogPane.setHeaderText("¡Error!");
                dialogPane.setContentText("No hay elemento seleccionado.");
                dialogPane.show();
            }

        });
        btnEliminar.setOnAction(event -> {
            // Lo que se escriba aquí en código se ejecuta después de la pulsación del botón
            User user = listViewUsers.getSelectionModel().getSelectedItem(); //Pedimos un usuario de la lista seleccionada

            if (user == null) {
                Alert dialogPane = new Alert(Alert.AlertType.ERROR);

                dialogPane.setHeaderText("¡Error!");
                dialogPane.setContentText("No hay elemento seleccionado.");
                dialogPane.show();
            } else {
                listaUsers.remove(user); //Como es un objeto de tipo observable una vez seleccionado busca cual es que tipo seleccionado y en este caso lo elimina
                Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);

                dialogPane.setHeaderText("Eliminado");
                dialogPane.setContentText("Usuario eliminado con éxito");
                dialogPane.show();
                listViewUsers.getSelectionModel().select(-1);
            }
        });
        btnCerrar.setOnAction(event -> {
            //1. Creo Ventana
            Stage stage = new Stage();
            try {
                //2. Creo Scene
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("login-clase-view.fxml"));
                //3. Asocio Stage a Scence
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                stage.setTitle("TIENDA THE POWER");
                stage.show();
                //4. Cierro Stage actual
                ((Stage) btnCerrar.getScene().getWindow()).close();

            } catch (IOException e) {
                System.out.println("No se encuentra la ruta" + e.getMessage());
            }

        });


        //Accesos de setOnAction de Forma Indirecta
        btnComprobar.setOnMouseEntered(new ManejoRaton());
        btnVaciar.setOnMouseEntered(new ManejoRaton());
        btnAgregar.setOnMouseEntered(new ManejoRaton());
        btnEliminar.setOnMouseEntered(new ManejoRaton());

        btnAgregar.setOnMouseExited(new ManejoRaton());
        btnVaciar.setOnMouseExited(new ManejoRaton());
        btnComprobar.setOnMouseExited(new ManejoRaton());
        btnEliminar.setOnMouseExited(new ManejoRaton());

        //Acceso a propiedades
        checkLista.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            //Según el evento que mostremos hará una cosa u otra
            if (newValue) {
                bordeGeneral.setRight(listViewUsers);
            } else {
                bordeGeneral.setRight(null);
            }
        });

    }


    private void clearFields() {
        editNombre.clear();
        editDni.clear();
        editEmail.clear();
        editPass.clear();
        editApellido.clear();
        comboTipo.getSelectionModel().select(-1);
        grupoGenero.selectToggle(null);

    }

    //Clases anidadas centradas específicamente en controlar los eventos de ratón - Manejadores - Handlers
    // El anidamiento de clases hacer referencia al uso de eventos dentro la clase donde estamos empleando las diferentes funcionalidades
    // es decir, si tenemos funcionalidades del ratón para este controlador lo lógico sería emplear clases anidadas con relación a la clase donde estámos.
    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            //Se ejecuta el evento sombra cuando sea de Tipo - MouseEventEnteres
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                ((Button) mouseEvent.getSource()).setEffect(shadow);

                System.out.println("Evento de raton entrando");
                if (mouseEvent.getSource() == btnComprobar) {
                    System.out.println("Boton comprobar entrando");
                } else if (mouseEvent.getSource() == btnAgregar) {
                    System.out.println("Boton agregar entrando");
                } else if (mouseEvent.getSource() == btnVaciar) {
                    System.out.println("Boton vaciar entrando");
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                ((Button) mouseEvent.getSource()).setEffect(null);
            }

        }
    }

    //Clases anidadas centradas específicamente en controlar los eventos de teclas - Manejadores - Handlers
    /*class ManejoTeclas implements EventHandler<KeyEvent>{

        @Override
        public void handle(KeyEvent keyEvent) {

        }
    }*/

}
