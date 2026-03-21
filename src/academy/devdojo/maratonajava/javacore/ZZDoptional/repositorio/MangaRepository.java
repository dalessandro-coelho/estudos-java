package academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    private static List<Manga> mangas = List.of(new Manga(1, "Boku no Hero", 50), new Manga(2, "Overlord", 25));

    // Em vez de ter um metodo "findByTitle" e outro "findById" com códigos quase idênticos,
    // é aconselhavel criar um metodo privado "findBy" que aceita um Predicate<Manga>, e com isso
    // O metodo percorre a lista e, se o predicado der true, retorna um Optional.of(manga).
    // Se não encontrar nada, retorna Optional.empty()

    public static Optional<Manga> findById(Integer id) {
        return findBy(m -> m.getId().equals(id));
    }

    public static Optional<Manga> findByTitle(String title) {
        return findBy(m -> m.getTitle().equals(title));
    }

    private static Optional<Manga> findBy(Predicate<Manga> predicate) {
        Manga found = null;
        for (Manga manga : mangas) {
            if (predicate.test(manga)) {
                found = manga;
            }
        }
        return Optional.ofNullable(found);
    }
}
