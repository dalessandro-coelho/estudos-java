package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyOnWhriteTest01 {
    public static void main(String[] args) {

        //CopyOnWriteArrayList: É uma lista segura para threads onde, ao modificar, ela cria uma cópia da lista

        //Criação da lista.
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 2000; i++){
            list.add(i); //Cada add() cria uma nova cópia interna da lista.
        }

        //Cria um iterator (pega uma cópia da lista naquele momento).
        Runnable runnableIterator = () -> {
            Iterator<Integer> iterator = list.iterator();
            try {
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println); //imprime todos os valores da lista
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //NÃO está removendo da lista de verdade, só está imprimindo.
        Runnable runnableRemover = () -> {
            for (int i = 0; i < 500; i++){
                System.out.printf("%s removed %d%n" , Thread.currentThread().getName(), i);
            }
        };

        new Thread(runnableIterator).start();
        new Thread(runnableIterator).start();
        new Thread(runnableRemover).start();
    }
}
