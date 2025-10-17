public class MainMetodo {

    public  static void main(String[] args){
        System.out.println("Main para probar métodos y variables");
        String nombre = "Jheremi";

        saludar(nombre);
        saludar("Laura");
        despedir();

    }

    //Método Saludar
    static void saludar(String data){
        System.out.println("La llamada al primer método " + data);
    }

    //Método Despedir
    static  void  despedir(){
        System.out.println("Hasta luego, hemos terminado");
    }
}
