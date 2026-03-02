package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {

        // Queue -> Representa uma fila, seguindo o princípio FIFO: "o primeiro elemento a entrar é o primeiro a sair".
        // PriorityQueue -> Diferente de uma fila comum, organiza os elementos com base em uma prioridade.

        Queue<String> fila = new PriorityQueue<>();
        fila.add("C");
        fila.add("A");
        fila.add("B");

        // add vs offer -> Ambos adicionam elementos.O "add" lança uma exceção se a fila estiver cheia, enquanto o "offer" retorna apenas false.
        // poll -> Retorna o primeiro elemento e o remove da fila.
        // peek -> Retorna o primeiro elemento da fila, mas não o remove.

        while (!fila.isEmpty()){
            System.out.println(fila.poll());
        }
    }
}