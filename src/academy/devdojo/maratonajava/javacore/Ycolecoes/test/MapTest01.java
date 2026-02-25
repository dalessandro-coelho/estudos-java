package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {

        // Map<chave, valor> -> Estrutura para buscar valores rapidamente usando uma chave única(não pode ter chaves duplicadas, mas valores sim).

//        Map<String, String> map = new LinkedHashMap<>(); // LinkedHashMap -> Para manter a ordem de inserção.
        Map<String, String> map = new HashMap<>();
        map.put("teklado", "teclado");
        map.put("mouze", "mouse");
        map.put("vc", "você");
        // map.put("vc", "você"); // put -> Adiciona mesmo que já exista a chave (sobrescreve).
        map.putIfAbsent("vc2", "você2");// putIfAbsent -> Só adiciona se não existir a chave.
        System.out.println(map);

        // KeySet -> Mostra só as chaves.
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key)); // .get(chave) -> Busca o valor da chave, se não existir retorna "null".
        }

        System.out.println("-----------------");

        // values -> Mostra só os valores.
        for (String value : map.values()) {
            System.out.println(value);
        }

        System.out.println("-----------------");

        // entrySet -> Mostra chaves e valores.
        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() +" - "+entry.getValue());
        }
    }
}