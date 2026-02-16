package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("Berserk");
        mangas.add("Hellsing Ultimate");
        mangas.add("Pokemon");
        mangas.add("ATttack on titan");
        mangas.add("Dragon ball Z");

        Collections.sort(mangas); // .sort() -> Reorganiza a lista original em ordem ascendente (alfabética para Strings ou numérica para números).
        for (String manga : mangas) {
            System.out.println(manga);
        }
        System.out.println(mangas); // Pode imprimir sem o for-each que também da certo.

        System.out.println("---------------");

        List<Double> dinheiros = new ArrayList<>();
        dinheiros.add(100.21);
        dinheiros.add(23.98);
        dinheiros.add(21.21);
        dinheiros.add(98.10);

        Collections.sort(dinheiros);
        for (Double dinheiro : dinheiros) {
            System.out.println(dinheiro);
        }
        System.out.println(dinheiros);

        new Manga(null, null, 0); // Passando como null, lançara uma "NullPointerException".
    }
}