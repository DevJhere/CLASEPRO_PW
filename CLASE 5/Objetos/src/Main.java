import model.Coche;

public class Main {

    static void main(String[] args) {

        //Instanciamos la clase Coche - Mi tipo de dato es coche.

        //1er constructor sin nada
        Coche coche =  new Coche(); //Constructor.
        //marca, modelo, color, numeroPuertas, cv, precio

        //Segundo cosntructor con valores definidos
        Coche mercedes =  new Coche("Mercedes", "ClaseC","Rojo", 5, 300, 70000);
        //marca, modelo, color, numeroPuertas, cv, precio

        //3 constructor con atributos reducidos
        Coche mondeo = new Coche("Ford", "Focus", 5, 20000);
        mondeo.setPrecio(10000);

        System.out.println("El precio del Mercedes es " + mondeo.getPrecio());
    }
}
