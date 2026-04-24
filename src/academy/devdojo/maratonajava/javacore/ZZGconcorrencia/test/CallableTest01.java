package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String>{

    //call():Retorna um valor e permite lançar exceções.
    @Override
    public String call() throws Exception {
        int num = ThreadLocalRandom.current().nextInt(1, 11); //Cada thread gera o seu próprio gerador de números, evitando bloqueios desnecessários.
        for (int i = 0; i < num; i++){
            System.out.printf("%s executando uma tarefa callable...%n", Thread.currentThread().getName());
        }
        return String.format("%s finished and the random number is %d", Thread.currentThread().getName(), num);
    }
}

public class CallableTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Callable: Função que roda em thread e devolve algo.

        //Future: É como um "comprovante" de que a tarefa está a ser processada.
        RandomNumberCallable randomNumberCallable = new RandomNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(randomNumberCallable);
        String s = future.get(); //Usado para obter o resultado final.
        System.out.printf("Program finished %s", s);
        executorService.shutdown();
    }
}
