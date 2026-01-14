package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01 {
    public static void main(String[] args) {
        LocalDateTime aniversario = LocalDateTime.of(2004, Month.OCTOBER, 31, 12, 0,0);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(ChronoUnit.DAYS.between(aniversario, now)); // Contagem de dias.
        System.out.println(ChronoUnit.WEEKS.between(aniversario, now)); // Contagem de semanas.
        System.out.println(ChronoUnit.MONTHS.between(aniversario, now)); // Contagem de meses.
        System.out.println(ChronoUnit.YEARS.between(aniversario, now)); // Contagem de anos.
    }
}
