package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest01 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE); // Formata a data sem separadores (20210215).
        String s2 = date.format(DateTimeFormatter.ISO_DATE); // Formata tanto o ano,mês e dia (2021-02-15),como também trás OffSet SE tiver (2021-02-15+01:00).
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE); // Lida apenas com a data local, sem informações de fuso horário (offset).
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        LocalDate parse1 = LocalDate.parse("20260108", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parse2 = LocalDate.parse("2026-01-08+05:00", DateTimeFormatter.ISO_DATE);
        LocalDate parse3 = LocalDate.parse("2026-01-08", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(parse1);
        System.out.println(parse2);
        System.out.println(parse3);

        LocalDateTime now = LocalDateTime.now();
        String s4 = now.format(DateTimeFormatter.ISO_DATE_TIME); // Vai trazer Data/Hora, e trazer OffSet (+01:00) ou Zona ([Europe/Paris]) se tiver.
        System.out.println(s4);
        LocalDateTime parse4 = LocalDateTime.parse("2026-01-08T23:02:53.9214681", DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(parse4);

        // dd/MM/yyyy -> Brasil
        // MM/dd/yyyy -> EUA
        // yyyy/MM/dd -> Japão
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatBR = LocalDate.now().format(formatterBR);
        System.out.println(formatBR);
        LocalDate parseBR = LocalDate.parse("08/01/2026", formatterBR);
        System.out.println(parseBR);

        DateTimeFormatter formatterGR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN);
        String formatGR = LocalDate.now().format(formatterGR);
        System.out.println(formatGR);
        LocalDate parseGR = LocalDate.parse("08.Januar.2026", formatterGR);
        System.out.println(parseGR);
    }
}
