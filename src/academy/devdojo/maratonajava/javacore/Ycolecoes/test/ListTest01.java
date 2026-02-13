package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        // List -> É uma interface que representa uma lista de elementos em sequência.

        // List nomes = new ArrayList(); // Como era feito até a versão 1.4 (aceitavam qualquer tipo de objeto).
        List <String> nomes = new ArrayList<>(16); // Agora com a sintaxe de "Diamante" (<>), permite especificar o tipo de dado que a lista deve conter (ex: List<String>).
        nomes.add("Willian"); // .add() -> Adiciona um item ao final da lista.
        nomes.add("DevDojo Academy");

        // Pode ser feito a interação tanto por "for-each" (mais simples e legível), como por "for indexado".
        for (String nome: nomes){
            System.out.println(nome);
        }

        System.out.println("----------");

        nomes.add("Suane");
        for (int i = 0; i < nomes.size(); i++){ // size() -> Retorna a quantidade de elementos (diferente de "length" em arrays).
            System.out.println(nomes.get(i));
        }
    }
}