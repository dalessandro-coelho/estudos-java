package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate nowAfterTwoYears = LocalDate.now().plusYears(2).plusDays(7);
        Period p1 = Period.between(now ,nowAfterTwoYears);
        Period p2 = Period.ofDays(10);
        Period p3 = Period.ofWeeks(58);
        Period p4 = Period.ofMonths(3);
        Period p5 = Period.ofYears(3);

        System.out.println(now);
        System.out.println(nowAfterTwoYears);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p3.getMonths());

        // Vai trazer o valor da variavel p3, de 58 semanas (406 dias) em anos, meses e dias.
        System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(p3.getDays())));
        System.out.println(now.until(now.plusDays(p3.getDays()), ChronoUnit.DAYS));

//        Contagem de quanto tempo eu estou vivo.
//        LocalDate nascimento = LocalDate.of(2004, 10, 31);
//        Period tempoDeVida = Period.between(nascimento, now);
//        System.out.println(tempoDeVida);
    }
}
