import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        //Creamos un array "constante" con final. Lo que indica esto es que no podemos modificar el número de elementos
        // que hay dentro del array, pero sí podemos modificar el valor de los elementos.
        //final int[] numbers = new int[]{2 ,5 ,8, 12 , 20};

        //Para guardar varios elementos de distintos tipos empleamos Object -> Es la clase padre que engobla todos los tipos
        Object[] cosas = new Object[]{"Borja", 2, true, "jhere@gmail.com", 'A'}; //[ null, null, null, null, null]

        int[] numeros = new int[]{8, 12, 5, 45, 2};
        String[] palabras = new String[]{"palabra1","hola","adios","juego","programacion"};
        /*
        Arrays.sort -> ordena numeros de menor a mayor y lo ordena alfabéticamente.

        Arrays.sort(palabras, new Comparator<String>() { //Compara de 2 en dos los elementos
            @Override -> Es un método que ya esta creado
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length){
                    return 1; Ordena de forma ascendente

                } else if (o1.length() > o2.length){
                    return -1; //Ordena de forma descendete.
                }
                return 0;
            }
        });*/
        // numeros = Arrays.copyOf(numeros,10); //Crea un array exacto de numeros
        for (int numero: numeros) {
            System.out.println(numero);
        }
        /*
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random()*21);
        }
        for (int item: numeros) {
            System.out.println(item);
        }

         */

    }
}