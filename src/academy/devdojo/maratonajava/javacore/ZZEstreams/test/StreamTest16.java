package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest16 {
    public static void main(String[] args) {
        //Quantos núcleos o computador tem disponivel.
        System.out.println(Runtime.getRuntime().availableProcessors());

        long num = 100_000_000;
        sumFor(num);
        sumStreamIterate(num);
        sumParallelStreamIterate(num);
        sumLongStreamIterate(num);
        sumParallelLongStreamIterate(num);
    }
    //Somando números de 1 a 100_000_000:

    //Utilizando "For".
    private static void sumFor(long num){
        System.out.println("Sum for");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1; i <= num; i++){
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    //Utilizando "Stream.iterate".
    //O metodo iterate deixa mais lento, pois gera números um por um, o que torna difícil
    // para o Java saber como dividir esse trabalho entre as threads antes de ele estar pronto.
    private static void sumStreamIterate(long num){
        System.out.println("Sum sumStreamIterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    //Utilizando "Stream.iterate + paralled" (Fica mais lento).
    private static void sumParallelStreamIterate(long num){
        System.out.println("Sum sumStreamIterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum); //parallel(): Faz a stream rodar varios núcleos ao mesmo tempo.
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    // Utilizando "LongStream.rangeClosed"
    private static void sumLongStreamIterate(long num){
        System.out.println("Sum sumLongStreamIterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    // Utilizando "LongStream.rangeClosed + paralled" (Pode ficar até mais rapido que o "for")
    private static void sumParallelLongStreamIterate(long num){
        System.out.println("Sum sumParallelLongStreamIterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }
}