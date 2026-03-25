package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest03 {
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
        Stream<LightNovel> stream = lightNovels.stream();

        //Pode usar o ".forEach()" diretamente em uma Stream para realizar ações, como imprimir elementos.
        lightNovels.forEach(System.out::println);

        long count = stream
                .distinct() //Essencial para remover duplicatas do fluxo de dados (Para funcionar, deve ter os métodos "equals" e "hashCode" implementados na classe).
                .filter(ln -> ln.getPrice() <= 4)// Filter para pegar animes com preço ≤ 4.
                .count(); //Retorna um long com a quantidade de elementos que chegaram ao final do pipeline.

        System.out.println(count);
    }
}