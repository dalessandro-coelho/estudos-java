package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {

        //"toArray()" converte uma coleção em array, enquanto "Arrays.asList()" converte um array em lista fixa.
        // Sendo necessário criar uma nova ArrayList para permitir modificações estruturais.

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        Integer[] listToArray = numeros.toArray(new Integer[0]); //Passar um array de tamanho zero é melhor do que passar o tamanho exato da lista, pois o desempenho é mais rápido.
        System.out.println(Arrays.toString(listToArray));

        System.out.println("---------------");
        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;

        List<Integer> arrayToList = Arrays.asList(numerosArray);
        arrayToList.set(0, 12); // Vai adicionar na posição zero, o número doze.
        // arrayToList.add(19); // Não pode adicionar ou remover elementos dessa lista (ela tem tamanho fixo, não pode modificar), caso contrário, receberá uma "UnsupportedOperationException".
        System.out.println(Arrays.toString(numerosArray));
        System.out.println(arrayToList);

        System.out.println("---------------");
        // Para fazer modificações.
        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray));
        numerosList.add(15);
        System.out.println(numerosList);

        // Criar uma lista em uma única linha.
        // Desde versões antigas:
        List<Integer> integers = Arrays.asList(1, 2);
        List<String> strings = Arrays.asList("1","2");
        // A partir do Java 9 (imutavel):
        List.of("1", "2");
    }
}