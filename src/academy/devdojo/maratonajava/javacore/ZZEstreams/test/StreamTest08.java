package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest08 {
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

        //Soma os preços de todos os animes que custam mais de 3:

        //Redução com Objetos
        lightNovels.stream()
                .map(LightNovel::getPrice) //Extrai apenas o atributo price (Double) de cada objeto, transformando a Stream<LightNovel> em uma Stream<Double>.
                .filter(price -> price > 3) //Filtra os objetos LightNovel com preço > 3
                .reduce(Double::sum) //Realiza a soma dos valores extraídos
                .ifPresent(System.out::println);

        //Otimização com Streams de Primitivos
        double sum = lightNovels.stream()
                .mapToDouble(LightNovel::getPrice) // Em vez do map comum, usa esse metodo para converter o fluxo diretamente em um DoubleStream.
                .filter(price -> price > 3)
                .sum();
        System.out.println(sum);

        /*
        * Enquanto o reduce em uma stream de objetos costuma retornar um Optional,
        * o metodo .sum() de um DoubleStream retorna o valor primitivo diretamente
        * (0 se a stream estiver vazia), facilitando o uso imediato do resultado.
        * */
    }
}