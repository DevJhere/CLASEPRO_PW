package org.example.tiendaapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.example.tiendaapp.model.Product;


import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {

    @FXML
    private Label txtNombre;

    @FXML
    private Label txtDescripcion;

    @FXML
    private Label txtPrecio;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setProducto(Product product){
        this.txtDescripcion.setText(product.getDescription());
        this.txtNombre.setText(product.getTitle());
        this.txtPrecio.setText(String.valueOf(product.getPrice()));
    }
}
