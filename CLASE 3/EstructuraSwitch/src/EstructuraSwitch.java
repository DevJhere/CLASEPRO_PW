import java.util.Scanner;

public class EstructuraSwitch {
    // Switch -> Evalúa un valor determinado y dependiendo de este se ejecutará un cao u otro -> Se evalúan char/string/int
    // Estructura de Switch que ejecuta el código según el valor que se le pase. Devuelve un resultado en función del valor
    // La estructura tradicional no es la más óptima.
    // Si se declaran variables dentro de la estructura, siempre deben tener diferentes nombres, ya que su ámbito es el mismo (scope)
    public void estructuraTradicional(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce tú nota: ");
        int nota = scanner.nextInt();

        // En caso de que sea > 5 (estudia este caso), en caso de ser la nota <7 (estudia este caso)
        switch (nota){
            case 1:
                String nombre = "Hola";
                System.out.println("La nota vale 1, Has suspendido!!");
                break;
            case 5:
                String apellido = "";
                System.out.println("Has aprobado raspado");
                break;
            case 8:
                System.out.println("Has aprobado muy bien!!");
                break;
            case 10:
                System.out.println("Matricula!!!!! Genial!!");
                break;
            default:
                System.out.println("La nota introducida no es válida");
        }

        System.out.println("Notas Analizadas Correctamente.");
    }

    // La estructura Lambda te permite declarar mayor variedad de variables, ya que tienen diferentes ámbitos(scope)
    public void  estructuraLambda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        String nombre =  scanner.next();

        switch (nombre.toLowerCase()) {
            case "alex" -> {
                System.out.println("Nombre Introducido Alex");

            }
            case  "carlos" -> {
                System.out.println("Nombre Introducido Carlos");
            }
            case "juan" -> {
                System.out.println("Nombre Introducido Juan");
            }
            case "ana" -> {
                System.out.println("Nombre Introducido Ana");
            }
            default -> {
                String apellido = "Lopez";
                System.out.println("Nombre no reconocido");
            }
        }
    }

    public void estructuraChar() {

        char letra = 'b';
        switch (letra){
            case 'a':
                System.out.println("Letra Introducida es una Vocal (a)");
                break;
            case 'e':
                System.out.println("Letra Introducida es una Vocal (e)");
                break;
            case 'i':
                System.out.println("Letra Introducida es una Vocal (i)");
                break;
            case 'o':
                System.out.println("Letra Introducida es una Vocal (o)");
                break;
            case 'u':
                System.out.println("Letra Introducida es una Vocal (u)");
                break;
            default:
                System.out.println("La letra introducida es una Consonante");
        }
    }

    public void menuOpciones () {
        Scanner scanner = new Scanner(System.in);
        int operando1 =0, operando2=0;


        System.out.println("Por favor selecciona la opcion a realizar");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Modulo");
        System.out.println("6. Salir");
        System.out.println("Que quieres hacer: ");
        int opcion = scanner.nextInt();

        if (opcion >=1 && opcion<6) {
            System.out.println("Introduce operando 1");
            operando1 = scanner.nextInt();
            System.out.println("Introduce operando 2");
            operando2 = scanner.nextInt();
        }

        double resultado = 0;
        switch (opcion){
            case 1 -> {
                System.out.println("Vas a sumar");
                resultado = operando1 + operando2;


            }
            case 2 -> {
                System.out.println("Vas a restar");
                resultado = operando1 - operando2;
            }
            case 3 -> {
                System.out.println("Vas a multiplicar");
                resultado = operando1 * operando2;
            }
            case 4 -> {
                System.out.println("Vas a dividir");
                if (operando2 !=0){
                resultado = (double) operando1 / operando2;
                }
            }
            case 5 -> {
                System.out.println("Vas a hacer el modulo");
                resultado = operando1 % operando2;
            }
            case 6 -> {
                System.out.println("Saliste del menú");
            }
            default -> {
                System.out.println("Opción no disponible");
            }
        }

        System.out.println("El resultado es: " + resultado);
    }
}
