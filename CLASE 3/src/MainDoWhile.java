import java.util.Scanner;

public class MainDoWhile {
    public static void main (String[] args){
    /*do-while -> se repite siempre y cuando se cumpla 1 condición, la condición de repetición de true -> 1 a N
    * Evaluamos el cuerpo de ejecución
    * */
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Las opciones del menu son: ");
            System.out.println("1 - sumar");
            System.out.println("2 - restar");
            System.out.println("3 - salir");
            System.out.println("Que opcion quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1-> {
                    System.out.println("Vamos a sumar");
                }
                case 2 -> {
                    System.out.println("Vamos a restar");
                }
                case 3 -> {
                    System.out.println("Vamos a salir...");
                }
                default -> {
                    System.out.println("Error");
                }
            }
        }while (opcion !=3);
    }
}
