package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest01 {
    //ScheduledExecutorService:Esta inteface executa após um determinado atraso.

    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1); // Para obter uma instância.
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static void beeper(){
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(formatter) + " beep");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //ScheduledFuture<?> : Representa o resultado de uma tarefa agendada.

//        executor.schedule(r,5, TimeUnit.SECONDS); // Executa uma vez após definir o tempo.
        //Só dispara a cada tempo que foi definido (nesse caso 5s), mesmo que o tempo da tarefa demore.
//        ScheduledFuture<?> scheduledWithFixedDelay = executor.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS);
        //Só começa a contar tempo de espera após a tarefa anterior terminar.
        ScheduledFuture<?> scheduledWithFixedDelay = executor.scheduleAtFixedRate(r, 1, 5, TimeUnit.SECONDS);
        executor.schedule(() ->{
            System.out.println("Cancelando o scheduleWithFixedDelay");
            scheduledWithFixedDelay.cancel(false);
            executor.shutdown();
        }, 20, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter));
        beeper();
    }
}