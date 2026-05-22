package dao;


import database.DBConnection;
import database.SchemeDb;
import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* Permite ejecuciones CRUD sobre la base de datos en este caso sobre la tabla Clientes*/
// Importante nada de lógica
public class ClienteDao {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    //Objetos a utilizar para la ejecución de query en "plano" de la base de datos -> Statement (Peligro de SQLInyection) - Actualmente no se utiliza INSERT, UPDATE, DELETE
    //Objeto similiar para ejecutar querys de DB -> PrepareStatement -> Mediante parametros base 1 - INSERT, UPDATE, DELETE
    //ResultSet -> permite ejecutar una query y obtener una tupla de datos -> SELECT

    //Conexión activa para los métodos de este controlador, es decir no hace falta tener que iniciar cada vez que apliquemos un metodo
    public ClienteDao(){
        connection = DBConnection.getConnection();
    }


    //1.Insertar Usuario
    public int insertarUsuario(Cliente cliente) throws SQLException {
        //1. Conexion - Realizada en ClienteDao(){}

        //2. Query
        //INSER INTO clientes (nombre, apellido, correo, saldo, id_perfil) VALUES (cliente.getNombre)
        // Con String.format ponemos %s, ya que capturamos los nombres de la tabla clientes y el nombre de cada columna de la tabla.
        String query = String.format("INSERT INTO  %s (%s,%s,%s,%s,%s) VALUES (?,?,?,?,?)",
                SchemeDb.TAB_CLIENTES, SchemeDb.COL_NAME,SchemeDb.COL_SURNAME,SchemeDb.COL_MAIL,SchemeDb.COL_PRICE,SchemeDb.COL_PROFILE);

        /*// 3. Crear statement
        try {
            statement = connection.createStatement();

            //4. Ejecuta
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return -1;*/

        //3. Ejecucion de insercion con prepareStatement

            preparedStatement = connection.prepareStatement(query);

            //4. Parametrizar datos - Posiciones en base 1, es decir posicones que empiezan por 1
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getCorreo());
            preparedStatement.setInt(4, cliente.getSaldo());
            preparedStatement.setInt(5, cliente.getIdPerfil());

            //5. ejecuta
            return preparedStatement.executeUpdate();


    }

    //2. Actualizar usuario
    public int actualizarUsuario(String correo, String nombre){
        String query = String.format("UPDATE %s SET %s=? WHERE %s=?",
                SchemeDb.TAB_CLIENTES,SchemeDb.COL_NAME,SchemeDb.COL_MAIL);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,correo);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return -1;
    }

    //3. Obtener Clientes
    public List<Cliente> obtenerTodosClientes(){
         String query = "SELECT * FROM " + SchemeDb.TAB_CLIENTES;
         List<Cliente> clientes = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery(); //Tupla de datos


            //Obtenemos todos los datos de la DB
            while (resultSet.next()){
                String nombre = resultSet.getString(SchemeDb.COL_NAME);
                String apellido = resultSet.getString(SchemeDb.COL_SURNAME);
                String correo = resultSet.getString(SchemeDb.COL_MAIL);
                int saldo = resultSet.getInt(SchemeDb.COL_PRICE);
                int perfil = resultSet.getInt(SchemeDb.COL_PROFILE);

                clientes.add(new Cliente(nombre, apellido, correo, saldo, perfil));
            }


        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return clientes;
    }

}
