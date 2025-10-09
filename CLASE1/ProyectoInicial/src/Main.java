import java.sql.SQLOutput;
public class Main {


    //Variable global
    int edadGlobal = 15;
    // TODO me falta esto
    public static void main(String[] args){
        System.out.println("Primer Programa en Java");

        //Tipos de Variables -- Datos

        // String
        String miNombre = "Jheremi"; // El valor cuando no se define es null
        miNombre = "Jheremi Lema"; // Cuando queremos cambiar el valor de la variable solo se llama a la variable no definimos el tipo


        //char - Valor definido entre ''. char tambien recoge elementos de la tabla ASCII, por lo tanto almacena números
        char letraDni = 'E';
        Character letraCompleja = 'A';

        //int -> Son números si decimales
        int edad = 41;
        Integer edadCompleja = 35;

        //float -> Número con decimales sin precision. Termina con una f
        float peso = 69.533f;
        Float pesoCompleja = 22.23f;

        //double -> Numero con decimales con precision
        double altura = 1.71;
        Double alturaCompleja = 1.65;

        //booleano -> Solo almacena dos valores true o false. Tomamos decisiones con este tipo de variables
        boolean experiencia = true;
        Boolean experienciaCompleja = false;

        //Constantes
        final String DNI = "0215454A";


        System.out.println("Mi nombre es: " + miNombre  + " , la letra de mi DNI es: " + letraDni + " y mi edad: " + edad);
        System.out.println("Mi peso es: " + peso + " y mi altura es: " + altura);
        System.out.println("Experiencia: " + experiencia);
        System.out.println("Mi DNI es: " + DNI);
        System.out.println("El valor de nuúmero Pi es: " + Math.E);
        System.out.println("El valor Maximo de un numero es " + Integer.MAX_VALUE + "El valor minimo de un numero es " + Integer.MIN_VALUE);


        //Clasificación de Variables -- Nombre de las Clases simpre tiene que ir en Mayuscula la primera letra
        /*
        * Variables según su forma de crearse
        *
        * Variables envolventes -> Variable que se crea a partir de una clase. Pueden ejecutar sus métodos específicos
        * Variables primitivas -> Aquellas que no se crean a partir de una clase, solo almacenan un dato.
        *
        * Variables seg´´un su forma de asignar el valor
        *
        * Variables que pueden cambiar su valor en cualquier momento -> Variable mutables
        * No pueden cambiar su valor en ningún momento. Se escriben en mayusculas -> Variable no mutable
        *
        *
        *
        *Variables según el ambito que tienen: Sitios donde una variable es visible
        * clase-global: Definida en un ambito grande para que pueda ser accedidad desde muchos sitios
        *  variable-bloque : Definida en un ambito pequeño para que solo acceda desde el mismo sitio.
        * */

    }

    public void nombreMétodo() {
        System.out.println(edadGlobal);

    }

    public void nombreMetodo() {
        int edadGlobal = 1212121;
        int edadMetodo = 123;

        System.out.println(edadMetodo);
        System.out.println(this.edadGlobal);
    }

}
