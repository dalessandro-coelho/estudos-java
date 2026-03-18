package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

// Reference to an instance method of an arbitrary object of a particular type.
// Referencia um metodo de instância através do nome da classe.
public class MethodReferenceTest03 {
    public static void main(String[] args) {

        // Ordena uma lista de Strings (Usando String::compareTo)
        List<String> list = new ArrayList<>(List.of("Rimuru", "Veldora", "Hikimaru"));
        list.sort(String::compareTo);

        // Converte uma String em Integer (Usando Integer::parseInt)
        Function<String, Integer> numStringToInteger = Integer::parseInt;
        Integer num = numStringToInteger.apply("10");
        System.out.println(num);

        // Verifica se um nome existe em uma lista (Usando List::contains)
        BiPredicate<List<String>, String> checkNam  = List::contains;
        System.out.println(checkNam.test(list, "Rimuru"));
    }
}
