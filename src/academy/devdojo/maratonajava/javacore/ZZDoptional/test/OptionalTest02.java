package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {

        //Onde usar o Optional -> O foco principal deve ser o retorno de métodos de busca/consulta.
        //Onde não usar o Optional -> Como parâmetro de metodo e como atributo de classe.

        // Atualização se existir (ifPresent):
        // Busca um mangá por título e, se encontrar, executa uma Lambda para alterar o título dele.
        Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Boku no Hero");
        mangaByTitle.ifPresent(m -> m.setTitle("Boku no Hero 2"));
        System.out.println(mangaByTitle);

        // Lançar exceção se não existir (orElseThrow):
        // Busca por "id", se não achar vai lançar uma exceção.
        Manga mangaById = MangaRepository.findById(2).orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaById);

        // Criar novo se não existir (orElse / orElseGet):
        // Busca por um título e, se não encontrar, cria um novo Manga.
        Manga newManga = MangaRepository.findByTitle("Drifters").orElseGet(() -> new Manga(3, "Drifters", 20));
        System.out.println(newManga);
    }
}
