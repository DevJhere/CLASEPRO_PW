import controller.Gestor;
import model.Usuario;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class MainPrograma {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gestor gestor = new Gestor();

        int opcion;
        do {
            System.out.println("1. Añadir Usuario");
            System.out.println("2. Exportar Usuarios");
            System.out.println("3. Listar Usuarios");
            System.out.println("4. Importar Usuarios");
            System.out.println("5. Salir");
            System.out.print("Eliga una opción: ");
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce el nombre: ");
                    String nombre = sc.next();

                    System.out.println("Introduce el apellido: ");
                    String apellido = sc.next();

                    System.out.println("Introduce el DNI: ");
                    String dni = sc.next();

                    sc.nextLine();

                    gestor.agregarUsuario(new Usuario(nombre, apellido, dni));
                }
                case 2 -> {
                    gestor.exportar();
                }
                case 3 -> {
                    gestor.listarUsuario();
                }
                case 4 -> {
                    gestor.importar();
                }case 5 -> System.out.println("Saliendo de la aplicación...");
                default -> {
                    System.out.println("Opción no válida");
                    sc.nextLine();
                }
            }
        } while (opcion != 5);


        sc.close();
    }
}
