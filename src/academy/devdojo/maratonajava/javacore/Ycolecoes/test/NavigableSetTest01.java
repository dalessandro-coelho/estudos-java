package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneMarcaComparator implements Comparator<Smartphone>{
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

public class NavigableSetTest01 {
    public static void main(String[] args) {

        // TreeSet -> mantem os elementos sempre em ordem, impedindo duplicados (porque é um Set).
        // Mas o grande diferencial, é que os elementos ficam automaticamente ordenados (sempre se reorganiza sozinho.).

        // Se usar TreeSet sem implementar Comparable e sem passar um Comparator, será lançada uma exceção.
//        NavigableSet<Smartphone> set = new TreeSet<>();
//        Smartphone smartphone = new Smartphone("123", "Nokia");
//        set.add(smartphone);
//        System.out.println(set);

        // Agora executando com a classe implementando "Comparable" e passando um "Comparator", vai dar certo.
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
        Smartphone smartphone = new Smartphone("123", "Nokia");
        set.add(smartphone);
        System.out.println(set);

        System.out.println("---------------");

        NavigableSet<Manga> mangas = new TreeSet<>();
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(1L,"Berserk", 9.5, 5));
        mangas.add(new Manga(4L,"Pokemon", 3.2, 0));
        mangas.add(new Manga(3L,"Attack on titan", 11.20, 2));
        mangas.add(new Manga(2L,"Dragon ball Z", 2.99, 0));
        mangas.add(new Manga(10L,"Aaragon", 2.99, 0));
        mangas.add(new Manga(10L,"Aaragon", 10.0, 0));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}