import java.util.Scanner;

public class MainWhile {
    public  static void main(String[] args){
        // Estructura que se repite mientras sea true, si no para la ejecución mientras (condición) {
        // cuantas ejecuciomes minimo tiene este estamento -> 0 a N
        // se jecuta hasta que se cumpla la condición o rompemos la ejecución
        //}

        int numero = 7;
        while (numero< 10){
            numero++;
            System.out.println("El número es inferior a 10");
        }

        Scanner scanner = new Scanner(System.in);
        int intentos = 3;
        int pin = 1234;
        int pinUsuario = 0;
        boolean bloqueado = false;
        //Quiero pedir al usuario que me introduzca números hasta que sea negativo
        while (intentos >=0 && pinUsuario!=pin){
            System.out.println("Introduce tu pin: ");
            pinUsuario = scanner.nextInt();
            intentos--;
            if (intentos == 0 && pinUsuario != pin){
                bloqueado=true;
            }
        }

        if (bloqueado){
            System.out.println("Telefono bloqueadp");
        }else {
            System.out.println("Bienvenido al telefono");
        }
        System.out.println("Sistema detenido");
    }
}
