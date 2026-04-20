package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.Objects;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException{
        /*LinkedTransferQueue é basicamente uma classe que juntou a funcionalidade de outras 3 classes:
          - ConcurrentLinkedQueue: Alta performance para operações não bloqueantes.
          - SynchronousQueue: Onde um produtor espera até que um consumidor pegue o item.
          - LinkedBlockingQueue: Uma fila encadeada com capacidades de bloqueio.
        * */

        TransferQueue<Object> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("william")); // Vai inserir um elemento, e se não tiver espaço vai lançar a exceção "IllegalStateException".
        System.out.println(tq.offer("william")); // Faz o mesmo que o "add", só que lança "false" caso não tiver espaço.
        System.out.println(tq.offer("william", 10, TimeUnit.SECONDS)); // Invés de inserir imediatamente, vai esperar um determinado tempo (nesse caso 10 segundos).
        tq.put("DevDojo");
        if (tq.hasWaitingConsumer()){
            tq.transfer("Devdojo"); //Fica bloqueada até que outra thread consumidora venha e pegue esse elemento específico.
        }
        System.out.println(tq.tryTransfer("Academy")); // Tenta transferir imediatamente, caso não houver nenhum consumidor à espera no exato momento, ele retorna "false" e não adiciona nada à fila.
        System.out.println(tq.tryTransfer("Academy", 5, TimeUnit.SECONDS)); // Espera um consumidor por um tempo determinado antes de desistir.
        System.out.println(tq.element()); // Exibe o primeiro elemento da fila, mas não vai remover.E se não tiver nada, lança exceção.
        System.out.println(tq.peek());
        System.out.println(tq.poll());
        System.out.println(tq.remove());
        System.out.println(tq.take());
        System.out.println(tq.remainingCapacity()); // Capacidade de elementos que pode colocar dentro.
    }
}
