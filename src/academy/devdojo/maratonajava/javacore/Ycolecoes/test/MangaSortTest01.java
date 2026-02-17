package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MangaSortTest01 {
    public static void main(String[] args) {

        // Comparable -> Define a ordem natural de um objeto por meio do metodo "compareTo".Nesse classe, pode ordenar por "id", "nome" ou preco.

        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L, "Berserk", 19.9));
        mangas.add(new Manga(1L,"Hellsing Ultimate", 9.5));
        mangas.add(new Manga(2L,"Pokemon", 3.2));
        mangas.add(new Manga(3L,"ATttack on titan", 11.20));
        mangas.add(new Manga(4L,"Dragon ball Z", 2.99));
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        Collections.sort(mangas);
        System.out.println("---------------");
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}