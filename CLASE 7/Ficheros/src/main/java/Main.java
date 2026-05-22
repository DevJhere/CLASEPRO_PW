import controller.Operaciones;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /** File fichero = new File("src/main/resource/analisis-secundario.txt");
         //Rutas absolutas no es recomendables trabajar con ellos, ya que si el proyecto esta en otro ordenador no se podria acceder a este fichero
         //Ruta relativa es recomendable ya que accede desde esta ruta src/main/resources/analisis.txt

         // ¿Cómo sabemos si es un fichero Lógico o Físico?
         System.out.println("Información del fichero");
         System.out.println(fichero.exists());

         if (fichero.exists()){
         System.out.println("Ruta Absoluta es: " + fichero.getAbsolutePath());
         System.out.println("Se puede escribir: " + fichero.canWrite());
         System.out.println("Tamaño: " + fichero.length());
         System.out.println("Es un directorio: " + fichero.isDirectory());
         System.out.println("Es un fichero " + fichero.isFile());
         }else {
         try{
         fichero.createNewFile();
         System.out.println("Fichero creado correctamente");
         }catch (IOException e){
         System.out.println("Error en la creación del fichero");
         System.out.println(e.getMessage());
         //Solucion -> indica otra ruta pra crar el fichero
         //Pongase en contacto con el admin para solucionar los permisos
         }
         }**/

        //Flujos I O
        //Entrada
        InputStream inputStream;

        //Salida
        OutputStream outputStream;

        //Lectura
        FileReader fileReader;

        //Escritura
        FileWriter fileWriter;

        //File carpeta = new File("src/main/resources/carpeta1");
        //System.out.println("Existe: " + carpeta.exists());
        //System.out.println("Carpeta: "  + carpeta.isDirectory());


        /*if (carpeta.isDirectory()){
            /**for (String item: carpeta.list()){
                System.out.println(item);
            }**/

        /*for (File item : carpeta.listFiles()) {
            System.out.println(item.getName());
            System.out.println(item.isDirectory());

            //sacar ficheros de una subcarpeta
            if (item.isDirectory()) {
                for (File data : item.listFiles()) {
                    System.out.println("\t" + data.getName());
                }
                if (item.isDirectory()) {
                    for (File data1 : item.listFiles()) {
                        System.out.println("\t\t" + data1.getName());
                    }
                }
            }
        }*/

        File file = new File("src/main/java/resources/analisis/escritura.txt");

        Operaciones operaciones = new Operaciones();
        //operaciones.leerFicheros("src/main/java/resources/analisis/escritura.txt");


        //operaciones.leerFicherosASCII(file);
        operaciones.escribirObjeto("src/main/java/resources/objetos.bin");
        operaciones.leerObjeto("src/main/java/resources/objetos.bin");


    }
        //mkdir -> creación de directorio
        //carpeta.mkdirs(); // Crea directorio con todo una ruta pero no crea ficheros.
}
