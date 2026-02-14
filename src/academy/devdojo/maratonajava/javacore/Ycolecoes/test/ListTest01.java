package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        // List -> É uma interface que representa uma lista de elementos em sequência.

        // List nomes = new ArrayList(); // Como era feito até a versão 1.4 (aceitavam qualquer tipo de objeto).
        List <String> nomes = new ArrayList<>(16); // Agora com a sintaxe de "Diamante" (<>), permite especificar o tipo de dado que a lista deve conter (ex: List<String>).
        List <String> nomes2 = new ArrayList<>(16);
        nomes.add("Willian"); // .add() -> Adiciona um item ao final da lista.
        nomes.add("DevDojo");
        nomes.add("Suane");
        nomes.add("Academy");

//        System.out.println(nomes.remove("William"));  // remove() -> Pode remover por índice (remove(0)) ou por objeto (remove("William")).

        nomes.addAll(nomes2); // addAll() -> Permite adicionar todos os elementos de uma coleção em outra de uma só vez, evitando loops manuais.

        // Pode ser feito a interação tanto por "for-each" (mais simples e legível), como por "for indexado".
        for (String nome: nomes){
            System.out.println(nome);
        }

        System.out.println("----------");
        int size = nomes.size();
        for (int i = 0; i < size; i++){
            System.out.println(nomes.get(i));
        }

        System.out.println("----------");
        // Lista de Inteiros.
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        System.out.println(numeros);
    }
}