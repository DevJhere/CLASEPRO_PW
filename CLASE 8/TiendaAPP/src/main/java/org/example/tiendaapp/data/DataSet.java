package org.example.tiendaapp.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.tiendaapp.model.Product;
import org.example.tiendaapp.model.User;

import java.util.Optional;

public class DataSet {

    /*Esta variable pertenece a la clase en sí misma, y no a los objetos individuales que crees de esta clase*/
    static private ObservableList<User> listUser = FXCollections.observableArrayList(
            new User("Admin", "Admin", "admin@admin.com", "admin", "1234", "admin", "femenino", 50),
            new User("Maria", "Maria", "maria@gmail.com", "maria", "12345", "usuario", "femenino", 25)
    );

    static private ObservableList<Product> carrito=
            FXCollections.observableArrayList(

    );

    public static ObservableList<User> getListUser() {
        return listUser;
    }

    public static ObservableList<Product> getCarrito() {
        return carrito;
    }

    public static void addUser(User user){
        // Logica -> No se pueden meter dos usuarios con el mismo correo.

        listUser.add(user);
    }

    public static User getLogin(String mail, String pass){
        Optional<User> userOptional = listUser.stream().filter(item -> item.getCorreo().equals(mail) && item.getPass().equals(pass))
                .findFirst();
        return userOptional.orElse(null);
    }


    public static void addCarrito(Product product){

        carrito.add(product);
    }
}
