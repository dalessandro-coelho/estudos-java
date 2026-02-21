package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {

        //Iterator -> Permite percorrer e remover elementos de uma coleção de forma segura, evitando "ConcurrentModificationException".

        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L, "Berserk", 19.9, 0));
        mangas.add(new Manga(1L,"Hellsing Ultimate", 9.5, 5));
        mangas.add(new Manga(2L,"Pokemon", 3.2, 0));
        mangas.add(new Manga(3L,"Attack on titan", 11.20, 2));
        mangas.add(new Manga(4L,"Dragon ball Z", 2.99, 0));

        // Usar "for-each" não é forma correta para remover valores da lista, pois causa "ConcurrentModificationException".
//        for (Manga manga : mangas){
//            if(manga.getQuantidade() == 0){
//                mangas.remove(manga);
//            }
//        }

        //Usar "Iterator" é a forma mais correta e segura para remover valores da lista.
        Iterator<Manga> mangaIterator = mangas.iterator();
        while (mangaIterator.hasNext()){ // hasNext() -> Verifica se ainda há itens na lista.
            if (mangaIterator.next().getQuantidade() == 0){ // next() -> Pega o próximo objeto da lista.
                mangaIterator.remove(); // remove() -> remove o elemento atual.
            }
        }

        // Outra forma de fazer o mesmo processo e em uma só linha, é usando "removeIf"(mais moderno).
        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        System.out.println(mangas);
    }
}