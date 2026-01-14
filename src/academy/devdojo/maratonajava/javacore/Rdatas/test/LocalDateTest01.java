package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocalDateTest01 {
    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(Calendar.getInstance());
        System.out.println(Month.JANUARY.getValue());

        LocalDate date = LocalDate.of(2022, Month.JANUARY, 27);
        LocalDate agora = LocalDate.now(); //  Cria uma instância com a data atual do sistema.
        agora = agora.plusWeeks(4); //  Retorna uma nova data adicionando dias ou semanas
        System.out.println(date.getYear()); //  Retorna o ano
        System.out.println(date.getMonth()); //  Retorna o enum do mês
        System.out.println(date.getMonthValue()); //  Retorna o valor numérico do mês
        System.out.println(date.getDayOfWeek()); //  Retorna o dia da semana
        System.out.println(date.getDayOfMonth()); //  Retorna o dia do mês
        System.out.println(date.lengthOfMonth()); //  Retorna quantos dias o mês possui
        System.out.println(date.isLeapYear()); //  Retorna um booleano indicando se o ano é bissexto
        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);

        System.out.println(date);
        System.out.println(agora);

    }
}
