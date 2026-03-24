package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


// Desafio da aula anterior, mas desta vez utilizando as Streams.
public class StreamTest02 {
        private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
                new LightNovel("Tensei Shittara", 8.99),
                new LightNovel("Overlord", 3.99),
                new LightNovel("Violet Evergarden", 5.99),
                new LightNovel("No Game no life", 2.99),
                new LightNovel("Fullmetal Alchemist", 5.99),
                new LightNovel("Kumo desuga", 1.99),
                new LightNovel("Monogatari", 4.00)
        ));
    public static void main(String[] args) {
        //stream(): Abre a sequência de elementos a partir da lista.
        List<String> titles = lightNovels.stream()
                //sorted(): Ordena os elementos usando um Comparator (neste caso, pelo título).
                .sorted(Comparator.comparing(LightNovel::getTitle))
                //filter(): Filtra os elementos que atendem à condição (preço <= 4) usando um Predicate.
                .filter(ln -> ln.getPrice() <= 4)
                //limit(): Garante que apenas os 3 primeiros elementos que passarem pelo filtro sigam adiante.
                .limit(3)
                //map(): Transforma cada objeto LightNovel em apenas uma String (o título), usando uma Function ou Method Reference.
                .map(LightNovel::getTitle)
                //collect(Collectors.toList()): A operação terminal que agrupa esses títulos de volta em uma List.
                .collect(Collectors.toList());
        System.out.println(titles);
    }
}