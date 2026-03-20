package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

// Reference to an instance method of a particular object
// Referência a um metodo de instância de um objeto específico.
public class MethodReferenceTest02 {
    public static void main(String[] args) {

        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Bersek", 43), new Anime("One pience", 900), new Anime("Naruto", 500)));

        //Chamando atraves de um objeto, invés de chamar diretamente do nome da classe.
        animeList.sort(animeComparators::compareByEpisodesNonStatic);
        System.out.println(animeList);

        //Atraves de um Lambda
        animeList.sort((a1, a2) -> animeComparators.compareByEpisodesNonStatic(a1, a2));
    }
}
