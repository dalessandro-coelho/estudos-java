package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest06 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 10.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));
    public static void main(String[] args) {

        //anyMatch: Verifica se pelo menos um elemento atende ao critério.
        //allMatch: Verifica se todos os elementos da lista atendem ao critério.
        //noneMatch: O inverso do allMatch, verifica se nenhum elemento atende ao critério.

        //Verifica se existe algum anime com preço maior que 9
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() > 9));

        //Verifica se todos os preços são maiores que zero.
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));

        //Verifica se nenhum preço é menor que zero.
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() < 0));

        //findAny: Retorna qualquer elemento que satisfaça o filtro. É útil em processamentos paralelos onde a ordem não importa.
        //findFirst: Retorna especificamente o primeiro elemento encontrado que atenda ao critério, respeitando a ordem de encontro na Stream.

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .findAny()
                .ifPresent(System.out::println);

        lightNovels
                .stream()
                .filter(ln -> ln.getPrice() > 3)
                .sorted(Comparator.comparing(LightNovel::getPrice).reversed())
                .findFirst()
                .ifPresent(System.out::println);

        lightNovels
                .stream()
                .filter(ln -> ln.getPrice() > 3)
                .max(Comparator.comparing(LightNovel::getPrice))
                .ifPresent(System.out::println);

    }
}