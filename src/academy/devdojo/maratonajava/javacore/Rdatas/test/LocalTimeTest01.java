package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class LocalTimeTest01 {
    public static void main(String[] args) {
       LocalTime time = LocalTime.of(23, 32, 12); // Cria um horário específico.
       LocalTime timeNow = LocalTime.now(); // Captura o horário atual do sistema
        System.out.println(time);
        System.out.println(timeNow);
        System.out.println(time.getHour()); // Obtém a hora.
        System.out.println(time.getMinute()); // Obtém os minutos.
        System.out.println(time.getSecond()); // Obtém os segundos.
        System.out.println(time.getNano()); // Obtém os nanossegundos.
        System.out.println(time.get(ChronoField.CLOCK_HOUR_OF_AMPM)); // Aqui é caso for 23h, vai dizer que é 11h da noite.
        System.out.println(LocalTime.MIN); // Representa o início do dia (00:00:00).
        System.out.println(LocalTime.MAX); // Representa o último instante do dia (23:59:59.999999999).
    }
}
