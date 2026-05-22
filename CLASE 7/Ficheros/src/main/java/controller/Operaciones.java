package controller;

import model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operaciones {

    public void leerFichero(String path) {
        File file = new File(path);
        System.out.println(file.getName());
        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                leerFichero(item.getAbsolutePath());
            }
        }
    }

    public void leerFicherosASCII(File file) {
        FileReader fileReader = null;//Controlamos el problema con el try - catch
        BufferedReader bufferedReader = null;
        // Para leer caracteres ASCII uno a uno
        /*try {
            fileReader = new FileReader(file);
            //Lectura de un caracter
            try {
                int codigo = -1;
                while ((codigo = fileReader.read()) != -1){ //Si la lectura es distinto de -1, ya que los caracteres ASCII van desde 0 - 255, se asigna el valor.
                    System.out.println(codigo);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileReader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Erro a la hora de cerrar la lectura");
            }
        }*/

        //Leer caracteres ASCII por lineas
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            //int codigo;
            String palabra;
            while ((palabra = bufferedReader.readLine()) != null) {
                //String linea = bufferedReader.readLine();

                String[] arrayPalabras = palabra.split(" ");
                for (String item : arrayPalabras) {
                    System.out.println(Character.toChars(Integer.valueOf(item)));
                }

                //int codigoLeido = Integer.valueOf(palabra);
                //System.out.println((char)codigoLeido);
                //System.out.println(Character.toChars(codigo));
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de lectura de fichero");
        } finally {
            try {

                assert fileReader != null;
                fileReader.close();
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar la lectura");

            }
        }
    }

    public void leerContenidoFichero(String path) {
        // File -> FileReader
        File file = new File(path);
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            int codigo;
            while ((codigo = fileReader.read()) != -1) {
                // mientras la lectura sea != -1 -> muestra
                // System.out.print(codigo);
                // System.out.print(" - ");
                System.out.print((char) codigo);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero que intentas leer no existe");
            // prueba con otra ruta
            // leerContenidoFichero();
        } catch (IOException e) {
            System.out.println("No cuentas con los permisos suficientes");
            System.out.println("Ponte en contacto con tu administrador");
        } finally {
            try {
                fileReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    public void leerContenidoFicheroLineas(String path) {
        // File -> FileReader -> BufferedReader
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            // fileReader = ;
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                // linea = bufferedReader.readLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("La ruta es incorrecta");
        } catch (IOException e) {
            System.out.println("No cuentas con los permisos suficientes");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }

    }

    public void descifrarContenido(String path) {
        File file = new File(path);
        Scanner scanner = new Scanner(System.in);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            try {
                System.out.println("Dime cual es la clave de cifrado");
                int clave = scanner.nextInt();
                String linea = reader.readLine();
                String[] numeros = linea.split(" ");
                for (String item : numeros) {
                    int codigo = Integer.parseInt(item);
                    System.out.print((char) (codigo / clave));
                }
            } catch (FileNotFoundException e) {
                System.out.println("El fichero no es valido");
            } catch (IOException e) {
                System.out.println("Error en la lectura del fichero, sin permisos");
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Error en el cerrado");
        }

    }

    public void escrituraFichero(String path) {
        File file = new File(path);
        Scanner scanner = new Scanner(System.in);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            try {
                System.out.println("Dime como quieres cifrar el mensaje");
                int clave = scanner.nextInt();
                scanner = new Scanner(System.in);
                System.out.println("Dime que quieres guardar en el fichero");
                String mensaje = scanner.nextLine();

                for (int i = 0; i < mensaje.length(); i++) {
                    char letra = mensaje.charAt(i);
                    int codigo = (int) letra;
                    fileWriter.write(String.valueOf(codigo * clave));
                    fileWriter.write(" ");
                }

            } catch (IOException e) {
                System.out.println("error en la escritura del fichero");
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Error en el cerrado");
        }

    }

    public void escrituraSalto(String path) {
        //PrintWriter -> Usa la gestión de memoria con mayor efectividad y tiene el mismo uso que BufferedWriter
        //PrintWriter printWriter = null; // Con este flujo no es obligatorio el cerrado de Captura como con BufferedWriter con el Finally

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path))) {

            printWriter.println("1Me imprime la linea dentro del fichero y luego salto de linea");
            printWriter.println("2Me imprime la linea dentro del fichero y luego salto de linea");
            printWriter.println("3Me imprime la linea dentro del fichero y luego salto de linea");

        } catch (IOException | NullPointerException e) {
            System.out.println("Fallo en el proceso de escritura");
        } catch (Exception e) {
            System.out.printf("Fallo en el proceso de cerrado con error %s", e.getMessage());
        }


    }

    public void exportarUsuario(Usuario usuario) {
        //Me das un usuario y lo escribo en la ruta de exportación
        File file = new File("src/main/java/resources/usuarios.csv");
        //PrintWriter printWriter = null;

        boolean archivoYaExiste = file.exists();

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file, true))) {

            //Si el fichero no existe, lo creas y escribes una línea y escribe el usuario.
            if (!archivoYaExiste) {
                printWriter.println("nombre,apellido,dni");
            }

            String lineaCSV = usuario.getNombre() + "," + usuario.getApellido() + "," + usuario.getDni();
            printWriter.println(lineaCSV);

        } catch (IOException | NullPointerException e) {
            System.out.println("Error en la creación del fichero.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*try{
            if (!file.exists()){
                file.createNewFile();
                printWriter = new PrintWriter(new FileWriter(file,true));
                printWriter.println("nombre,apellido,dni"); // TODO el primero que pasa con el??
                exportarUsuario(usuario);
            }else {
                printWriter = new PrintWriter(new FileWriter(file,true));
                printWriter.println(usuario);
            }
        }catch (IOException e){
            System.out.println("Error en la creación del fichero.");
        }finally {
            try {
                printWriter.close();
            }catch (Exception e){
                System.out.println("Fallo en el cerrado");
                System.out.println(e.getMessage());
            }
        }*/
    }

    public List<Usuario> importarUsuarios() {
        File file = new File("src/main/java/resources/usuarios.csv");

        List<Usuario> lista = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String linea = bufferedReader.readLine();
            while ((linea = bufferedReader.readLine()) != null) {
                String[] lineaLimpia = linea.split(",");
                Usuario usuario = new Usuario(lineaLimpia[0], lineaLimpia[1], lineaLimpia[2]);
                lista.add(usuario);
            }
        }catch (FileNotFoundException e){
            System.out.println("No hay dator previos. Empezando una lista vacía");
        }catch (IOException e) {
            System.out.println("Error de importación.");
        }

        return lista;
    }

    public void escribirObjeto(String path){
        File file = new File(path);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){

            //objectOutputStream.writeInt(76); //Modo Objeto
            objectOutputStream.writeObject(new Usuario("Maria","Martin","0090902A"));

        }catch (IOException e){
            System.out.println("Error en la escritura del fichero." + e.getMessage());
        }
    }

    public void leerObjeto(String path){
        File file = new File(path);

        // Usamos ObjectInputStream envuelto en un FileInputStream
        /*try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){

            // Descongelamos el objeto. (Hay que hacer "casting" para decirle a Java que es un Usuario)
            Usuario usuarioRecuperado = (Usuario) objectInputStream.readObject();

            System.out.println("¡Objeto recuperado con éxito!");
            System.out.println("Nombre: " + usuarioRecuperado.getNombre());
            System.out.println("Apellido: " + usuarioRecuperado.getApellido());

        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("La clase del objeto que intentas leer no existe en tu programa.");
        }*/

        ObjectInputStream objectInputStream= null;

        try {
            objectInputStream =  new ObjectInputStream(new FileInputStream(file));
            try {
                List<Usuario> lista = (List<Usuario>) objectInputStream.readObject();
                lista.forEach(Usuario::mostrarDatos);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            System.out.println("Fichero no encontrado.");

        } catch (ClassCastException e) {
            System.out.println("Tipos incompatibles ");
        }

    }
}
