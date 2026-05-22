package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Permite la conexión a la base de datos
public class DBConnection {

    //Patrón Singleton
    private static Connection connection;


    public static Connection getConnection(){

        if (connection == null){
            createConnection();
        }

        return connection;
    }


    private static void createConnection(){

        //1. Definimos las variables de Conexión a la DB
        String user = "root";
        String pass = "root";
        String database = "tienda_thpw";

        //2. Creamos la conexión
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, pass);
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la DB. " + e.getSQLState());
            System.out.println(e.getMessage());
        }
    }
}
