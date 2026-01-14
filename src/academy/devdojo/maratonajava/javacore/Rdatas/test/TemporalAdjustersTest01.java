package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        now = now.with(ChronoField.DAY_OF_MONTH, 3);
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        System.out.println("=====================================");
        now = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)); // Se quiser encontrar o próximo dia da semana especificado ou o próprio dia.
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        System.out.println("=====================================");
        now = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.THURSDAY)); // Se quiser saber quando é a proxima quinta, ou outro dia.
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        System.out.println("=====================================");
        now = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)); // Se quiser saber quando foi a última quinta, ou outro dia.
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        System.out.println("=====================================");
        now = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()); // Ajusta para o dia 1 do mês atual.
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        System.out.println("=====================================");
        now = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()); // Calcula automaticamente se o último dia é 28, 29, 30 ou 31.
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        System.out.println("=====================================");
        now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear()); // Move a data para o primeiro dia do próximo ano.
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        System.out.println("=====================================");
        now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()); // Move a data para o primeiro dia do mês seguinte.
        System.out.println(now);
        System.out.println(now.getDayOfWeek());
    }
}
