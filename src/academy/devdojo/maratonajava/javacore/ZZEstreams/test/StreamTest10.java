package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {

        //Stream.iterate(): Cria uma sequência baseada em um valor inicial (semente) e uma função que
        //define como o próximo elemento será gerado a partir do anterior.E como é infinito deve usar um .limit().
        //Stream.generate(): Fica gerando valores sem depender do anterior.Novamente, precisa do .limit().

        //Gera 10 valores começando de 1, e somando n + 2.
        Stream.iterate(1, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("--------------------");

        //Agrupa pela regra de Fibonacci.
        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .forEach(a -> System.out.println(Arrays.toString(a)));

        System.out.println("--------------------");

        //Regra de Fibobacci.
        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(a -> a[0])
                .forEach(System.out::println);

        System.out.println("--------------------");

        //Gera 10 valores aleatorios de 1 a 500.
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate(() -> random.nextInt(1,500))
                .limit(10)
                .forEach(System.out::println);
    }
}