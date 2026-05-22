package controller;

import dao.ClienteDao;
import model.Cliente;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Scanner;

public class Tienda {
    private ClienteDao clienteDao;

    public Tienda(){
        clienteDao = new ClienteDao();
    }

    public void agregarUsuario(Cliente cliente) {
        //Agregamos la capa logica
        System.out.println("Se procede a insertar el usuario en el sistema");

        //Como se ha escalado la Excepción SQLException desde la firma del método, debemos aplicar aquí try-catch para capturar los errores
        try {
            clienteDao.insertarUsuario(cliente);
        } catch (SQLException e) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Este correo ya está en uso. Debe introducir un nuevo correo." + e.getMessage());

            String correo = scanner.next();
            cliente.setCorreo(correo);
            agregarUsuario(cliente);
        }
    }

    public void actualizarUsuario(String correo, String nombre){
        System.out.println("Actualizando Usuario");
        int row = clienteDao.actualizarUsuario(correo, nombre);
        if (row == 0 ){
            System.out.println("El correo indicado no se en encuentra en la BD");
        }else {
            System.out.println("El numero de elementos actualizados es de " + row);
        }
    }

    public void lanzarFidelizacion(){
        //Se envia un correo a todos los usuarios
        List<Cliente> listadoClientes = clienteDao.obtenerTodosClientes();
        listadoClientes.stream().filter(data-> data.getSaldo()<50000)

                //JAVAMAIL
                .forEach(data -> System.out.println("Correo enviado  a " + data.getCorreo()));

    }
}
