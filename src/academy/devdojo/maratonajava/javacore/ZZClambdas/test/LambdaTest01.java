package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {
    public static void main(String[] args) {

        //Consumer -> É uma interface funcional que recebe um valor e não retorna nada.

        List<String> strings = List.of("Willian", "Suane", "Luffy", "Zoro");
        //Imprime lista de nomes
        forEach(strings, (String s) -> System.out.println(s));

        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        //Imprime lista de numeros
        forEach(integers, (Integer i) -> System.out.println(i));

        // Forma simplificada
//        forEach(strings, s -> System.out.println(s));
//        forEach(integers, i -> System.out.println(i));
    }

    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T e : list) {
            consumer.accept(e);
        }
    }
}
