package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {
    public static void main(String[] args) {

        //NavigableMap -> Map ordenado que trabalha com "chave → valor", diferente de NavigableSet que trabalha só com valores únicos.
        //TreeMap -> É uma implementação da interface NavigableMap (que estende SortedMap), tendo como objetivo manter as chaves automaticamente ordenadas.

        NavigableMap<String, String> map = new TreeMap<>();
        map.put("A", "Letra A");
        map.put("D", "Letra D");
        map.put("B", "Letra B");
        map.put("C", "Letra C");
        map.put("E", "Letra E");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        // Retorna o que tiver abaixo da chave da letra C.
        System.out.println(map.headMap("C"));
        // Retorna o que tiver abaixo da chave da letra C, incluindo ele mesmo.
        System.out.println(map.headMap("C", true));

        // "TreeMap e TreeSet" usam a mesma lógica de navegação:

        // Menor chave maior OU IGUAL a "C".
        System.out.println(map.ceilingKey("C"));

        // Menor chave maior que "C".
        System.out.println(map.higherKey("C"));

        // Maior chave menor que "C".
        System.out.println(map.lowerKey("C"));

        // Maior chave menor OU IGUAL a "C".
        System.out.println(map.floorKey("C"));
    }
}