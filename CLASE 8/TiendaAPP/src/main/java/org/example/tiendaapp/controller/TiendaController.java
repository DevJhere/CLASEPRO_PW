package org.example.tiendaapp.controller;

import com.google.gson.Gson;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.tiendaapp.HelloApplication;
import org.example.tiendaapp.data.DataSet;
import org.example.tiendaapp.model.Product;
import org.example.tiendaapp.model.ProductResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class TiendaController implements Initializable {

    @FXML
    private Button btnCerrar;

    @FXML
    private Button btnCompra;

    @FXML
    private Button btnDetalle;

    @FXML
    private TableColumn<Product, String> colNombre;

    @FXML
    private TableColumn<Product, Number> colPrecio;

    @FXML
    private TableColumn<Product, Number> colStock;

    @FXML
    private TableView<Product> tablaProductos;

    private ObservableList<Product> listProductos;

    @FXML
    private TextField txtFiltro;

    //Lista asociada Observable
    private FilteredList<Product> listFilter;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instances();
        initGUI();
        actions();
        loadJsonProducts();
    }

    private void actions() {

        // Escucha las propiedades del txtFiltro
        txtFiltro.promptTextProperty();

        //Funcionalidad Botón Comprar
        btnCompra.setOnAction(event -> {
            //Traemos el producto seleccionado
            Product product = tablaProductos.getSelectionModel().getSelectedItem();

            //Agregamos producto dentro del DataSet -> carrito
            DataSet.addCarrito(product);

            System.out.println(DataSet.getCarrito().size());

            // Como tenemos el conjunto de producto seleccion y hemos pulsado al boton comprar, cada vez que se compre el Stock de producto se reduce en 1
            product.setStock(product.getStock() -  1);
            // Actualiza la tabla
            tablaProductos.refresh();

            //Si Stock llega a 0 se elimina de la lista de los productos
            if (product.getStock() == 0){
                listProductos.remove(product);
            }


        });

        //A traves de addLister se escucha los valores antiguos y los nuevos valores para poder realizar una búsqueda en directo
        txtFiltro.textProperty().addListener((observable, oldValue, newValue) -> {
            //Con .setPredicate podremos realizar una busqueda booleana -> true -> Producto y lo renderiza, false no devuelve nada
            listFilter.setPredicate(product -> product.getTitle().contains(newValue));

        });

        //Funcionalidad de Boton Detalle
        btnDetalle.setOnAction(event -> {
            Stage stage =  new Stage();

            FXMLLoader loader =  new FXMLLoader(HelloApplication.class.getResource("detail-clase-view.fxml"));

            //Cargamos la nueva ventana. Creando un Stage y una nueva Scene y finalmente lo mostramos
            try {
                Parent root = loader.load();

                // Se llama al metodo de DetailController
                //Debemos cargar dede loader los elementos cargados. No podremos cargar una nueva DatailController ya que no se ejecutaria la carga de los elementos
                DetailController detailController = loader.getController();
                detailController.setProducto(tablaProductos.getSelectionModel().getSelectedItem());

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

        });
    }

    private void initGUI() {

        colNombre.setCellValueFactory(new PropertyValueFactory<>("title"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("price"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tablaProductos.setItems(listFilter);

    }

    private void instances() {
        listProductos = FXCollections.observableArrayList();
        listFilter = new FilteredList<>(listProductos);
    }

    private void loadJsonProducts() {


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/products"))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            Gson gson = new Gson();

            ProductResponse responseProduct = gson.fromJson(body, ProductResponse.class);
            //Asignamos la lista de productos a la tabla
            listProductos.setAll(responseProduct.getProducts());

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }


}
