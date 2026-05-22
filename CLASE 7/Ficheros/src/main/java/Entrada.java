import model.Usuario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Entrada {

    public static void main(String[] args) {
        //File -> Objet OutputStream
        File file =  new File("src/main/java/resources/objetos.obj");

        ObjectOutputStream objectOutputStream = null; //Para poder manejar desde el try-cath y que sea accesible desde el finally

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            //Creamos Objeto Usuario para escribir
            objectOutputStream.writeObject(new Usuario("Adrian", "Perez", "adraianp@gmail.com", 655897431));
        } catch (IOException e) {
            System.out.println("Fallo en la creación del Objeto");
        }finally {
            try {
                assert objectOutputStream != null;
                objectOutputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error a la hora de cerrar ");
            }
        }
    }
}
