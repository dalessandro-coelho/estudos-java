package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
    public static void main(String[] args) {

        //Streams de Intervalos Numéricos (IntStream):

        //IntStream.range(1, 50): Gera números de 1 a 49 (o último é exclusivo)
        IntStream.rangeClosed(1,50).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();
        //IntStream.rangeClosed(1, 50): Gera de 1 a 50 (o último é inclusivo)
        IntStream.range(1,50).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("-----------");

        //Streams de Valores (Stream.of):

        //Cria uma Stream passando os elementos diretamente como argumentos.
        Stream.of("Eleve", "O ", "Cosmo", "no seu coração")
                .map(String::toUpperCase)
                .forEach(s -> System.out.println(s + " "));

        System.out.println("-----------");

        //Streams de Arrays (Arrays.stream):

        //Se o array for de tipos primitivos (como int[]),retorna um IntStream, permitindo usar métodos como .sum(), .average() e .max().
        int num[] = {1, 2, 3, 4, 5};
        Arrays.stream(num)
                .average()
                .ifPresent(System.out::println);

        System.out.println("-----------");

        //Streams de Arquivos (Files.lines):
        //Por envolver leitura de arquivos, essa operação deve ser tratada com try-with-resources.

        //Lê um arquivo .txt
        try(Stream<String> lines = Files.lines(Paths.get("file.txt"))){
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-----------");

        //Lê um arquivo .txt e usa o .filter() para encontrar e imprimir apenas as linhas que contêm a palavra "Java".
        try(Stream<String> lines = Files.lines(Paths.get("file.txt"))){
            lines.filter(l -> l.contains("Java")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
