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

class MangaPrecoComparator implements  Comparator<Manga>{
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
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

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(1L,"Berserk", 9.5, 5));
        mangas.add(new Manga(4L,"Pokemon", 3.2, 0));
        mangas.add(new Manga(3L,"Attack on titan", 11.20, 2));
        mangas.add(new Manga(2L,"Dragon ball Z", 2.99, 0));
        mangas.add(new Manga(10L,"Aaragon", 2.99, 0));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

//        for (Manga manga : mangas.descendingSet()) { // descendingSet -> Retorna a coleção em ordem decrescente.
//            System.out.println(manga);
//        }

        System.out.println("---------------");

        Manga yuyu = new Manga(21L, "Yuyu Hakusho", 3.2, 5);

        // Esses métodos servem para buscar elementos próximos de um valor:
        // lower(E e) -> Retorna o maior elemento que é estritamente MENOR que "e".
        // floor(E e) -> Retorna o maior elemento que é MENOR OU IGUAL ao "e".
        // higher(E e) -> Retorna o menor elemento que é estritamente MAIOR que o "e".
        // ceiling(E e) -> Retorna o menor elemento que é MAIOR OU IGUAL ao "e".

        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));

        System.out.println("---------------");

        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst()); // pollFirst() -> Remove e retorna o primeiro (menor) elemento.
        System.out.println(mangas.pollLast()); // pollLast() -> Remove e retorna o último (maior) elemento.
        System.out.println(mangas.size());
    }
}