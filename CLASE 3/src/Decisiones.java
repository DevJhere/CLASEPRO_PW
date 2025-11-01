public class Decisiones {

    public void estructuraIF (int nota){
        // Explicacion de estructura if
        // Es una estructura de selección que codigo tengo que ejecutar dependiendo de una condición logica (true - false).
        // si (condicion) {cuerpo(se ejecuta esto) }


        if (nota >= 5) {
            System.out.println("Aprobado");
        }else {
            System.out.println("Suspenso");
        }
        System.out.println("Evaluación terminada");

    }

    public void estructuraIfElseIf (double nota){

        //0 -> Fatal

        //1-3 -> mal

        //4 -> raspado

        //5-7 -> bien

        // 8 - 8.99 - notable

        // 9 - 10 -> sobresaliente

        System.out.println("Inicia Evaluacion del Examen");
        if (nota >= 0 && nota <= 10) {

            if( nota < 1 ) {
                System.out.println("Examen fatal");
            } else if (nota<4) {
                System.out.println("Examen mal");
            } else if (nota<5) {
                System.out.println("Examen suspenso raspado");
            } else if (nota <8) {
                System.out.println("Examen bien");

            }else if (nota <9) {
                System.out.println("Examen Sobre!!");
            }else if (nota<10) {
                System.out.println("Examen sobresaliente");
            }else {
                System.out.println("Examen MH");
            }
        }else {
            System.out.println("Rango Incorrecto");
        }

    }
}
