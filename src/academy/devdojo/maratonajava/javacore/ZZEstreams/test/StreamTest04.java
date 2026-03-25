package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamTest04 {
    public static void main(String[] args) {
        List<List<String>> devdojo = new ArrayList<>();

        List<String> graphicDesignes = List.of("Wildnei Suane", "Catarina Santos", "Sandy Carolina");
        List<String> developers = List.of("William", "David", "Harisson");
        List<String> students = List.of("Édipo", "Gustavo Lima", "Gustavo Mendes", "Guilherme");
        devdojo.add(graphicDesignes);
        devdojo.add(developers);
        devdojo.add(students);

        // Antes do Java 8, a forma comum de acessar todos os nomes dentro dessas sublistas era utilizando loops "for" aninhados.
        // Embora funcional, esse código é verboso e menos expressivo.
        for (List<String> people : devdojo){
            for (String person : people){
                System.out.println(person);
            }
        }

        System.out.println("---------");
        //flatMap é usado quando o resultado da transformação gera algo dentro de outra coisa (ex: lista dentro de lista)

        // Agora com flatMap,torna o código muito mais limpo, permitindo aplicar outros filtros ou transformações diretamente em todos os nomes.
        devdojo.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}