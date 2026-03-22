package academy.devdojo.maratonajava.javacore.ZZEstreams.test;


import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//1. Order LightNovel by title.
//2. Retrieve the first 3 light novels with price less than 4.
public class StreamTest01 {

    //Stream -> É um jeito de pegar uma lista e fazer várias coisas nela de forma simples.
    // É como escrever SQL. Em vez de dizer ao Java "como" fazer (percorrer, verificar, contar, parar),
    // é só diz "o que" quer (Filtrar preço < 4, Pegar 3, Mostrar nomes).

    private static List<LightNovel> lightNovels = new  ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));
    public static void main(String[] args) {

        // Faz um "for" clássico, adicionando manualmente um if para o preço,
        // um add para o nome na lista nova e outro if com um break para parar quando atingir 3 itens.
        // O código funciona, mas é "poluído" com variáveis de controle e lógica manual de interrupção.
        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));
        List<String> titles = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels){
            if (lightNovel.getPrice() <= 4){
                titles.add(lightNovel.getTitle());
            }
            if (titles.size() >= 3){
                break;
            }
        }

        System.out.println(lightNovels);
        System.out.println(titles);
    }
}