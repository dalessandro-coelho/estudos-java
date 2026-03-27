package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest05 {
    public static void main(String[] args) {

        //Como obter uma única lista contendo cada letra da lista separadamente:

        // Só faz com uma String.
        List<String> words = List.of("Gomu", "Gomu", "No", "Mi");
        String[] letters = words.get(0).split(""); //
        System.out.println(Arrays.toString(letters));

        List<String[]> collect = words.stream().map(w -> w.split("")).collect(Collectors.toList());
        Stream<String> stream = Arrays.stream(letters);

        // Com todas as Strings.
        List<String> letters2 = words.stream()
                .map(w -> w.split("")) // .split() quebra uma String em um Array de Strings (letras).
                .flatMap(Arrays::stream) //Transforma cada array gerado pelo split em uma Stream individual.
                .collect(Collectors.toList());
        System.out.println(letters2);
    }
}
