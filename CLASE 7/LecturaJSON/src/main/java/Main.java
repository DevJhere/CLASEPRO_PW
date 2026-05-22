import controller.APIController;

public class Main {
    public static void main(String[] args) {
        //Instanciamos objeto API
        APIController controller = new APIController();

        System.out.println("Ligas en Competición:");
        controller.obtenerLigas();

        System.out.println("----------------------------------");

        System.out.println("Clasificación: ");
        controller.obtenerClasificacion("4328");

        System.out.println("Clasificación Completa: ");
        controller.obtenerClasificacionCompleta("4334");
    }
}
