package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Aircraft;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonEager;

public class AircraftSingletonEagerTest01 {
    public static void main(String[] args) {
        //Singleton: É um padrão que garante que uma classe tenha apenas um único objeto no sistema.

        bookSeat("1A");
        bookSeat("1A");
        AircraftTest01.bookSeat("1A");
    }

    private static void bookSeat(String seat){
        System.out.println(AircraftSingletonEager.getINSTANCE());
        AircraftSingletonEager aircraft = AircraftSingletonEager.getINSTANCE();
        System.out.println(aircraft.bookSeat(seat));
    }

    /*
    * Agora, se chamar "getInstance()" em dez lugares diferentes no código,
    * todos estarão a mexer no mesmo avião. Se o primeiro usuário reservar o lugar "1A",
    * o segundo usuário vai receber um false ao tentar reservar o mesmo lugar,
    * porque o assento sumiu do único objeto que existe.
    * */
}
