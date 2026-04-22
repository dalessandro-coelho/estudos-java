package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable {
    private final int num;

    public Printer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s inicio: %s%n", Thread.currentThread().getName(), num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s finalizou%n", Thread.currentThread().getName());
    }
}

public class ExecutorsTest01 {
    public static void main(String[] args) {
        //Thread Pool: É um conjunto de threads reutilizáveis para executar tarefas.

//        System.out.println(Runtime.getRuntime().availableProcessors());
//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); //newFixedThreadPool(): Cria um pool com um número fixo de threads.
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); //newSingleThreadExecutor(): Cria um executor com apenas uma thread.
        ExecutorService executorService = Executors.newCachedThreadPool(); //newCachedThreadPool(): Cria threads conforme a necessidade, mas reutiliza as que já foram criadas e estão paradas.
        executorService.execute(new Printer(1));
        executorService.execute(new Printer(2));
        executorService.execute(new Printer(3));
        executorService.execute(new Printer(4));
        executorService.execute(new Printer(5));
        executorService.execute(new Printer(6));
        executorService.shutdown(); //Avisa o executor para não aceitar novas tarefas e desligar assim que as atuais terminarem.
        System.out.println("Programa finalizado");
    }
}
