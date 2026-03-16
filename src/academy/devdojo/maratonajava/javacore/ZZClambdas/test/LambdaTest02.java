package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
    public static void main(String[] args) {
        List<String> strings = List.of("Natsu", "Allucard");

        // Quantidade de caracteres em cada String.
        List<Integer> integers = map(strings, (String s) -> s.length());
        System.out.println(integers);

        // Strings em caixa alta.
        List<String> map = map(strings, s -> s.toUpperCase());
        System.out.println(map);
    }

    //Function -> Pega um valor, faz alguma coisa com ele e devolve outro valor.
    // T = O tipo do objeto que a função RECEBE.
    // R = O tipo do objeto que a função RETORNA.

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T e : list) {
            R r = function.apply(e); // apply -> É o metodo abstrato que implementa. Ele recebe T e devolve R.
            result.add(r);
        }
        return result;
    }
}