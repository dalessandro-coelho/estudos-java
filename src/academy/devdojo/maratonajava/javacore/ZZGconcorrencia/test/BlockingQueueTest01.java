package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest01 {
    public static void main(String[] args) throws InterruptedException {

        //ArrayBlockingQueue: É uma fila com tamanho fixo, segura para threads, que bloqueia quando está cheia ou vazia.

        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        bq.put("Willian"); //put(E e): Insere um elemento. Se a fila estiver cheia, a thread espera até haver espaço.
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());
        System.out.println("Trying to add another value");
        new Thread(new RemoveFromQueue(bq)).start();
        bq.put("Suane"); //thread MAIN fica BLOQUEADA aqui, pois está cheia(já tem ["Willian"]).
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek()); //peek(): Apenas observa o primeiro elemento sem removê-lo (não bloqueia).
    }

    static class RemoveFromQueue implements Runnable{
        private final BlockingQueue<String> bq;

        public RemoveFromQueue(BlockingQueue<String> bq){
            this.bq = bq;
        }

        @Override
        public void run() {
            System.out.printf("%s going to sleep for 5s %n", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.printf("%s removing value from queue %s%n", Thread.currentThread().getName(), bq.take()); //take(): Remove e retorna o primeiro elemento. Se a fila estiver vazia, a thread espera até haver um dado disponível.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        /*Linha do tempo:
        1. main adiciona "Willian"
        2. fila cheia
        3. main tenta adicionar "Suane" → BLOQUEIA
        4. Thread-0 dorme 5s
        5. Thread-0 remove "Willian"
        6. main desbloqueia
        7. main adiciona "Suane"*/
    }
}
