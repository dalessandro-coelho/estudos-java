package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

//Reference to a constructor
//Referência a um construtor
public class MethodReferenceTest04 {
    public static void main(String[] args) {

        //Supplier<T> não recebe parâmetros e retorna um objeto do tipo T, ou seja, não recebe nada e só entrega um valor.
        Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new; // Em vez de usar "() -> new AnimeComparatorns", pode usar "AnimeComparators::new".

        // O objeto só é instanciado quando chama o metodo ".get()" do Supplier.
        AnimeComparators animeComparators = newAnimeComparators.get();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Bersek", 43), new Anime("One pience", 900), new Anime("Naruto", 500)));

        animeList.sort(animeComparators::compareByEpisodesNonStatic);

        System.out.println(animeList);

        // BiFunction<T, U, R> recebe dois argumentos (T e U) e retorna um resultado (R).
        BiFunction<String, Integer, Anime> animeBiFunction = (title, episodes) -> new Anime(title, episodes);
        // o Java entende automaticamente que deve procurar um construtor na classe "Anime" que receba exatamente uma "String" e um "Integer".
        BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new;
        System.out.println(animeBiFunction2.apply("Super campeões", 36));// .apply(valor1, valor2) -> cria um novo anime.
    }
}