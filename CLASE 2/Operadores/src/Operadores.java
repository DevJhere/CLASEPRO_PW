import java.util.Scanner;

public class Operadores {
    //Operaciones que se pueden realizar con los operandos

    public void operadoresAritmeticos(){
        System.out.println("Explicación de los operadores Aritmeticos");

        //Unarios -> Solo necesitan un operando
        int operando1 = 7;
        operando1++; // operando1 = operando1 + 1
        operando1++;
        operando1++;
        System.out.println(operando1);

        operando1 --; // operando1 = opernado1 - 1
        operando1 --;
        System.out.println("Decremento: " + operando1 );

        operando1 =-operando1; // Calculando su inverso -7

        //Binarios
        int operando2 = 3;

        int suma = operando1 + operando2;
        System.out.println("Resultado suma: " + suma);

        //Otra forma de realizar una suma u operacion mediante parentesis
        System.out.println((operando1 + operando2));

        int resta = operando1 - operando2;
        System.out.println("Resultado resta: " + resta);

        int mulplicacion = operando1 - operando2;
        System.out.println("Resultado multiplicacion: " + mulplicacion);

        //Para obtener una diviosn real hay que pasar temporalmente uno de los operando a double
        // Casting -> cambia temporalmente el tipo de valor
        double division = (double) operando1 / operando2;
        System.out.printf("Resultado division: %.2f \n" ,division); // Devuelve 2 decimales

        int modulo = operando1%operando2;

        System.out.println("El modulo de operando: " + modulo);
    }

    public void operadoresAsignacion(){
        int operando1 = 6;  //Asigancion
        operando1 += 10; // 6 + 10 = 16
        operando1 -=3; //13
        operando1 *=2; // 26
        operando1 /= 2; // 13
        operando1 %=3; // 1
    }

    public void operadoresComparadores(){

        int operando1 = 6;
        int operando2 = 4;

        // Mayor que > Devuelve true
        boolean res1 = operando1 > operando2;
        System.out.println(res1); //True

        //Menor que < Devuelve true
        res1 = operando1 < operando2; // False
        System.out.println(res1);
        // Igualdad == Devuelve true
        res1 = operando1 == operando2; // False
        System.out.println(res1);
        // Mayor o igual >=
        res1 = operando1 >= operando2; // True
        System.out.println(res1);

        // Menor o igual <=
        res1 = operando1 <= operando2; //False
        System.out.println(res1);

        // Distinti !=
        res1 = operando1 != operando2; // True

        System.out.println(res1);
    }

    public void operadoresLogicos(){
        int numeroUno = 4;
        int numeroDos = 10;
        int numeroTres = 17;

        boolean resultadoLogicoAnd = numeroUno > 1 && numeroDos<11 && numeroDos != numeroTres  && numeroTres%2 !=0;
            // true && false && true && true -> true
        resultadoLogicoAnd = numeroUno > 1 && numeroDos<11 && numeroDos != numeroTres  && numeroTres%2 ==0;
        // true && false && true && false -> false

        System.out.println("Resultado Logico AND: " + resultadoLogicoAnd);

        boolean resultadoLogicoOr = numeroUno > 1 || numeroDos<11 || numeroDos != numeroTres  || numeroTres%2 !=0;
        System.out.println("Resultado Logico OR: " + resultadoLogicoOr); // true

        boolean resultadoCombinado = numeroUno<10 || numeroTres>0 || numeroDos!=9 && numeroUno>0;
        System.out.println("Resultado logico de OR y AND: " + resultadoCombinado);

        numeroTres = 20;
        numeroDos = 10;

        boolean resultadoTotal = numeroUno>=0 && numeroDos<30&&false; //false
        boolean resultadoInverso = !resultadoTotal; //true ! al principio de la variable devuelve el resultado inverso.

        System.out.println("Resultado Inverso: " + resultadoInverso);

    }

    public void evaluarCandidato () {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime tu nombre y apellido: ");
        String nombre = sc.nextLine();

        System.out.println("Dime tu edad: ");
        int edad = sc.nextInt();

        System.out.println("Dime salario estimado: ");
        double salario = sc.nextDouble();

        System.out.println("Tienes experiencia: ");
        boolean experiencia = sc.hasNextBoolean();

        // edad inferior a 40 y sueldo < 40000 y experiencia true
        boolean resultadoEvaluar = edad<40 && salario<40000 && experiencia;
        System.out.println("Resultado debe cumplir estos requisitos: " + resultadoEvaluar);

        sc.close();
    }

    public void cambiosTipo(){

        //int letraAscii = 115;
        // Casteo -> Un tipo de dato cambia momentaneamente- Solo se puede aplicar a tipos que estan dentro de otros.
        char letra = 'w';

        System.out.println((int)letra);

        //Parse -> Cambio de tipo de dato Momentaneo- Tanto si el origen esta inluido en el destino como si no.
        // Hay probabilidad de fallo. Con variable envolventes.
        // Tipos de Parseo -> String -> int, double, boolean, char, float
        // Parseo Boolean -> siempre va a ser false salvo que tu entrada de datos sea "true"

        String palabra = "Hola";
        String numero = "7";
        // No puede cambiar la palabra hola a número
        //System.out.println(Integer.parseInt(palabra)); // Va dar error
        System.out.println(Integer.parseInt(numero) + 10);

        // Caso inverso  a String
        int numeros = 123;
        System.out.println(String.valueOf(numeros) + 1);

        boolean acierto = true;
        System.out.println(String.valueOf(acierto) + "awd");

        char word = 'a';
        System.out.println(String.valueOf(word) + "pwd");

    }
}
