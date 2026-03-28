package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.List;

public class StreamTest07 {
    public static void main(String[] args) {

        // .reduce(): Serve pra pegar vários valores e virar UM só.
        // ESTRUTURA: .reduce(Valor Inicial, Operação)
        // Valor Inicial: Onde começa.
        // Operação: O que fazer com os valores.

        List<Integer> integers = List.of(1,2,3,4,5,6);

        //Soma valores
        integers.stream().reduce((x,y) -> x + y).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(0, (x,y) -> x + y)); //Com valor inicial.
        //Mais outra forma, mas utilizando Method Reference(Integer::sum).
        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(0, Integer::sum));

        System.out.println("---------------");

        //Multiplicação de valores
        integers.stream().reduce((x,y) -> x * y).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(1, (x,y) -> x * y));
        System.out.println(integers.stream().reduce(0, (x,y) -> x * y)); //Valor inicial zero, resultara em zero (Obvio).

        System.out.println("---------------");

        //Maior valor
        integers.stream().reduce((x,y) -> x > y ? x : y).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(0, Integer::max));
    }
}