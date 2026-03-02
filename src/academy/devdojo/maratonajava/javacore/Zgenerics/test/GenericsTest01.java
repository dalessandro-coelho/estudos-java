package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {

        // Como era criado uma lista antes(podia colocar qualquer coisa na mesma lista - Java 1.4):
//        List lista = new ArrayList();
//        lista.add("Midoriya");
//        lista.add(123L);
//        lista.add(new Consumidor("Goku"));

        // Com a chegada dos Generics (Java 5), foi passado a usar os símbolos < > (chamados de Diamond),
        // para "forçar" o tipo da coleção,onde o compilador garante que apenas o que for determinado no Diamond entra ali, chamado de "Type Safety".
        List<String> lista = new ArrayList<>();
        lista.add("Midoriya");
        lista.add("Midoriya");

        for (String o : lista) {
            System.out.println(o);
        }
        add(lista, new Consumidor("Midoriya"));
    }

    private static void add(List lista, Consumidor consumidor){
        lista.add(consumidor);
    }
}