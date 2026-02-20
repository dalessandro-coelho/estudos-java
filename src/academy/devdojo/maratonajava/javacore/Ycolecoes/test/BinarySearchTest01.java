package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
    public static void main(String[] args) {

        //binarySearch -> É um algoritmo de busca que divide o problema pela metade a cada passo, mas só funciona em lista ORDENADA (sort).

        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);

        Collections.sort(numeros);

        // Resultado POSITIVO, retorna a posição onde foi encontrada.
        System.out.println(Collections.binarySearch(numeros,2));

        // Resultado NEGATIVO, retorna negativo, pois não existe na lista.
        // Cálculo para caso o retorno seja NEGATIVO:
        // (-(ponto de inserção) -1)
        // Esse cálculo serve para mostrar onde o elemento deveria ser inserido para manter a ordem, ou seja, se tivesse ele na lista, qual seria a posição dele.
        System.out.println(Collections.binarySearch(numeros,1));
    }
}