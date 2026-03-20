package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {

        //Optional<T> é uma forma de evitar "null", evitar erro e trabalhar com valores que podem ou não existir.

        //Optional.of() -> Só usa se tiver certeza que o valor é nulo.
        Optional<String> o1 = Optional.of("Aha uhu o DevDojo é foda");
        System.out.println(o1);

        //Optional.ofNullable() -> Pode ser nulo ou não.
        Optional<String> o2 = Optional.ofNullable(null);
        System.out.println(o2);

        //Optional.empty() -> Cria um Optional vazio direto.
        Optional<String> o3 = Optional.empty();
        System.out.println(o3);

        System.out.println("------------");

        Optional<String> nameOptional = findName("Willian");

        //orElse() -> Se tiver valor usa ele, se não tiver usa o que é declarado dentro dele.
        String empty = nameOptional.orElse("EMPTY");
        System.out.println(empty);

        // ifPresent() -> Executa uma ação apenas se o valor existir dentro.
        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));
    }

    private static Optional<String> findName(String name){
        List<String> list = List.of("William", "DevDojo");
        int i = list.indexOf(name);
        if (i != 1){
            return Optional.of(list.get(i));
        }
        return Optional.empty();
    }
}