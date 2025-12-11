import java.util.Scanner;

public class MainFor {

    public void main (String[] args){
        // Estructura de bucle for -> Es una estructura de repetición que se repite en un rango determinado. Cuando finaliza
        // el rango continúa el código.

        //Entrada -> Pedir 10 numeros y mostrar cuantos son pares, cuantos son impares y cuál es el número medio introducido
        Scanner scanner = new Scanner(System.in);
//        // Calcular que número es el más grande y cuál es el más pequeño introducido.
        int contadorPares = 0, contadorImpares = 0;
        int sumatorio = 0;
        double numeroMedio = 0;
        int contadorMin = 0 , contadorMax = 0;



//        for (int i=0; i<5; i++) {
//            System.out.printf("Introduce numero %d: ", i);
//            int numero = scanner.nextInt();
//
//            if (numero%2 ==0){
//                contadorPares ++;
//
//            }else {
//                contadorImpares ++;
//            }
//
//            if (numero > contadorMax) {
//                contadorMax = numero;
//            }
//
//            if (numero < contadorMin){
//                contadorMin = numero;
//            }
//
//            sumatorio += numero;
//
//        }
//
//        numeroMedio = (double) sumatorio/5;
//
//        System.out.println("Los numeros pares introducidos" + contadorPares);
//        System.out.println("Los numeros impares introducidos" + contadorImpares);
//        System.out.println("Numero medio introducidos: " + numeroMedio);
//        System.out.println("El número maximo introducido es: "+ contadorMax);
//        System.out.println("El número minimo introducido es: "+ contadorMin);
//        System.out.println("Saliste del bucle For");
//
//        int multi5 = 0;
//        // Tablas de multiplicar
//        for (int i=0 ; i <=10 ; i++){
//            System.out.printf("****** Tabla de Multiplicar del %d *******%n", i);
//            System.out.printf("%d * %d = %d%n" ,0, i, 0 * i);
//            System.out.printf("%d * %d = %d%n" ,1, i, 1 * i);
//            System.out.printf("%d * %d = %d%n" ,2, i, 2 * i);
//            System.out.printf("%d * %d = %d%n" ,3, i, 3 * i);
//            System.out.printf("%d * %d = %d%n" ,4, i, 4 * i);
//            System.out.printf("%d * %d = %d%n" ,5, i, 5 * i);
//            System.out.printf("%d * %d = %d%n" ,6, i, 6 * i);
//            System.out.printf("%d * %d = %d%n" ,7, i, 7 * i);
//            System.out.printf("%d * %d = %d%n" ,8, i, 8 * i);
//            System.out.printf("%d * %d = %d%n" ,9, i, 9 * i);
//            System.out.printf("%d * %d = %d%n" ,10, i, 10 * i);
//            System.out.println(" ");
//
//
//        }
//
//        for (int i = 0; i <= 10; i++) {
//            System.out.printf("****** Tabla de multiplicar del %d ******%n" , i);
//            for (int j = 0; j <= 10; j++) {
//                System.out.printf("%2d x %2d = %d%n", i, j, i * j);
//
//            }
//        }

        // Pintar cuadrado
        System.out.println("Indica tamaño del cuadrado");
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i==0 || i == size -1 ){
                    System.out.print(" * ");
                }else if (j==0 || j==size -1){
                    System.out.print(" * ");
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        //Factorial de un número 4! -> 4 * 3 * 2 *1 -> factorial 4! = 24
        long factorial = 1;
        for (int i = 1; i <4 ; i++) {
            factorial *=i;
        }

        System.out.println("El factorial del número es: " + factorial);

        //Una palabra es palindroma. Se lee igual de izq a dch
        String palabra = "allivesevill";
        boolean esPalindromo = true;

        for (int i = 0; i < palabra.length()/2; i++){
            //En caso de no ser iguales no es Palindromo
            // i=0 -> a != a
            // i=1 -> l != l
            if (palabra.charAt(i) != palabra.charAt(palabra.length() -1 -i)){
                esPalindromo = false;
                break;
            }
        }

        if(esPalindromo) {
            System.out.println("La palabra es palindromo");
        }else {
            System.out.println("La palabra no es palindromo");
        }


        //Introducción Estruturas de variables Recorriendo las estructuras con un for -> recorrer, preguntar y modificar
        String[] diasSemana = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        for (int i = 0; i <7 ; i++) {
            if (i%2 == 0){
                System.out.println( diasSemana[i]);;
            }
        }

        //Foreach -> para recorrer y preguntar
        for (String item : diasSemana) {
            System.out.println(item);
        }
    }
}
