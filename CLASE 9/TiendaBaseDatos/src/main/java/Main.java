import controller.Tienda;
import dao.ClienteDao;

import model.Cliente;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.SortedMap;


public class Main {
    public static void main(String[] args) {

        /*ClienteDao clienteDao = new ClienteDao();

        try {
            int rows = clienteDao.insertarUsuario(new Cliente("Margarita", "Lema","margarita@gmail.com",112345, 2));
            if(rows>-1){
                System.out.println("Cliente nuevo registrado");
            }
        } catch (SQLException e) {
            System.out.println("Error en la sentencia SQL");
            System.out.println(e.getMessage());
        }*/
        Scanner scanner = new Scanner(System.in);

        Tienda tienda = new Tienda();
        /*//Menú - Insertar Cliente
        System.out.println("Nombre: ");
        String nombre = scanner.next();
        System.out.println("Apellido: ");
        String apellido = scanner.next();
        System.out.println("Correo: ");
        String correo = scanner.next();
        System.out.println("Saldo: ");
        int saldo = scanner.nextInt();
        System.out.println("Id Perfil: ");
        int perfil = scanner.nextInt();

        tienda.agregarUsuario(new Cliente(nombre, apellido, correo, saldo, perfil));*/

        /*//Menu Actualizar Usuario
        System.out.println("Nombre: ");
        String nombre = scanner.next();
        System.out.println("Correo: ");
        String correo = scanner.next();

        tienda.actualizarUsuario(correo, nombre);*/

        //Obtenemos los datos de la tabla clientes
        tienda.lanzarFidelizacion();

    }
}
