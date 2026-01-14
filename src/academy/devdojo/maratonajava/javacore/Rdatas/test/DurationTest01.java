package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DurationTest01 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowAfterTwoYears = LocalDateTime.now().plusYears(2).plusMinutes(8);
        LocalTime timeNow = LocalTime.now();
        LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);
        Duration d1 = Duration.between(now, nowAfterTwoYears);
        Duration d2 = Duration.between(timeNow, timeMinus7Hours);
        Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));
        Duration d4 = Duration.ofDays(20); //Vai trazer a quantidade de dias em horas.
        Duration d5 = Duration.ofMinutes(3);
        Duration d6 = Duration.of(3, ChronoUnit.HOURS);

        //Eu coloquei separado assim, para ver a diferença de tempo de um para o outro.
        System.out.println("====================");
        System.out.println(now);
        System.out.println(nowAfterTwoYears);
        System.out.println(d1);

        System.out.println("====================");
        System.out.println(timeNow);
        System.out.println(timeMinus7Hours);
        System.out.println(d2);

        System.out.println("====================");
        System.out.println(Instant.now());
        System.out.println(Instant.now().plusSeconds(1000));
        System.out.println(d3);

        System.out.println("====================");
        System.out.println(d4);

        System.out.println("====================");
        System.out.println(d5);

        System.out.println("====================");
        System.out.println(d6);
    }
}
