package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    public static void main(String[] args) {

        //Como lidar com situações em que uma única chave possui múltiplos valores associados:

        Consumidor consumidor1 = new Consumidor("Willian Suane");
        Consumidor consumidor2 = new Consumidor("DevDojo Academy");

        Manga manga1 = new Manga(5L, "Hellsing Ultimate", 19.9);
        Manga manga2 = new Manga(1L, "Berserk", 9.5);
        Manga manga3 = new Manga(4L, "Pokemon", 3.2);
        Manga manga4 = new Manga(3L, "Attack on titan", 11.20);
        Manga manga5 = new Manga(2L, "Dragon ball Z", 2.99);

        // Primeiro, criam-se as listas individuais de mangás para cada consumidor.
        List<Manga> mangaConsumidor1List = List.of(manga1, manga2, manga3);
        List<Manga> mangaConsumidor2List = List.of(manga3, manga4);

        // O Valor passa a ser uma coleção (List<Manga>), permitindo agrupar diversos produtos sob o mesmo comprador.
        Map<Consumidor, List<Manga>> consumidorMangaMap = new HashMap<>();

        // Vincula o objeto consumidor à sua respectiva lista de compras.
        consumidorMangaMap.put(consumidor1, mangaConsumidor1List);
        consumidorMangaMap.put(consumidor2, mangaConsumidor2List);

        // Primeiro Nível: Itera sobre o entrySet() do Map para identificar o consumidor (a chave)
        for (Map.Entry<Consumidor, List<Manga>> entry : consumidorMangaMap.entrySet()) {
            System.out.println("-----" + entry.getKey().getNome());
            // Segundo Nível: Faz-se um novo for-each para percorrer a lista de mangás que foi retornada por entry.getValue().
            for (Manga manga : entry.getValue()) {
                System.out.println("----------" + manga.getNome());
            }
        }
    }
}