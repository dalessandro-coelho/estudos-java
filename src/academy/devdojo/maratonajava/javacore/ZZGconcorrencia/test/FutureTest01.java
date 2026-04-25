package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

public class FutureTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        /*
          ExecutionException: Erro dentro da tarefa
          InterruptedException: Thread interrompida
          TimeoutException: Demorou demais
        */

        //Enviando a tarefa (Callable)
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarRequest = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(15);
            return 4.35D;
        });

        //Enquanto a outra thread trabalha, main continua executando (Future permite execução assíncrona).
        System.out.println(doingSomething());
        Double dollarResponse = dollarRequest.get(3, TimeUnit.SECONDS); //Se não terminar no tempo, da exceção (Usar a versão com time-out).
        System.out.println("Dollar: "+ dollarResponse);
        executorService.shutdown();
    }

    private static long doingSomething(){
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0;i < 1_000_000;i++){
            sum += i;
        }
        return sum;
    }

    /*
    * Linha do tempo real:
        0s → tarefa começa (15s)
        0s → main continua
        1s → doingSomething termina
        3s → get() tenta pegar resultado
        3s → ainda não terminou → TimeoutException
    * */
}
