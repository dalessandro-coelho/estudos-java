package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonEager;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AircraftSingletonLazyTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //Lazy: O objeto só é criado no momento em que chama o getInstance() pela primeira vez, se não pedir o objeto, ele nunca gasta memória.

        bookSeat("1A");
        bookSeat("1A");
        System.out.println(AircraftSingletonLazy.getINSTANCE());
        System.out.println(AircraftSingletonLazy.getINSTANCE());
        Constructor<AircraftSingletonLazy> constructor = AircraftSingletonLazy.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        AircraftSingletonLazy aircraftSingletonLazy = constructor.newInstance("787-900");
        System.out.println(aircraftSingletonLazy);
    }

    private static void bookSeat(String seat){
        System.out.println(AircraftSingletonEager.getINSTANCE());
        AircraftSingletonEager aircraft = AircraftSingletonEager.getINSTANCE();
        System.out.println(aircraft.bookSeat(seat));
    }
}
