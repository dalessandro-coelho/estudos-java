package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class ZoneTest01 {
    public static void main(String[] args) {
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        System.out.println(shortIds); // Zonas que o Java oferece suporte
        System.out.println(ZoneId.systemDefault()); // Zona do sistema

        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo"); // Cria uma Zona especifica.
        System.out.println(tokyoZone);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        ZonedDateTime zonedDateTime = now.atZone(tokyoZone);
        System.out.println(zonedDateTime); // Data e Hora de agora, junto com quanto falta para chegar na zona especificada.

        Instant nowInstant = Instant.now();
        System.out.println(nowInstant); //Horário de Zulu Time (Horário Médio de Greenwich).
        ZonedDateTime zonedDateTime2 = nowInstant.atZone(tokyoZone);
        System.out.println(zonedDateTime2); //Traz a Zona que foi especificada,mas já formatado no horário do sistema.

        System.out.println(ZoneOffset.MIN);
        System.out.println(ZoneOffset.MAX);

        ZoneOffset offsetManaus = ZoneOffset.of("-04:00");
        OffsetDateTime offsetDateTime1 = now.atOffset(offsetManaus);
        System.out.println(offsetDateTime1); //Vai trazer data/hora, o Offset(as horas que serão tiradas ou adicionadas), mas sem a zona.
        OffsetDateTime offsetDateTime2 = OffsetDateTime.of(now, offsetManaus);
        System.out.println(offsetDateTime2);

        OffsetDateTime offsetDateTime3 = nowInstant.atOffset(offsetManaus);
        System.out.println(offsetDateTime3); // Vai trazer exatamente o horario de uma zona, nesse caso Manaus(Trouxe Manaus porque foi tirado "-04:00",mas também poderia chamar o próprio Manaus sem tira 4h).

        JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
        System.out.println(japaneseDate); //Essa linha pega a data atual no calendário gregoriano(nosso calendário) e converte para o calendário japonês,
        LocalDate meijiEraLocalDate = LocalDate.of(1900, 2, 1);
        JapaneseDate meijira = JapaneseDate.from(meijiEraLocalDate);
        System.out.println(meijira);
    }
}
