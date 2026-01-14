package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.DateFormat;
import java.util.Calendar;


public class DateFormatTest01 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateFormat[] df = new DateFormat[8];
        df[0] = DateFormat.getInstance(); // Retorna data e hora padrão
        df[1] = DateFormat.getDateInstance(); // Retorna apenas data
        df[2] = DateFormat.getTimeInstance(); // Retorna apenas hora
        df[3] = DateFormat.getDateTimeInstance(); // Retorna data e hora, aceitando um parâmetro de estilo
        df[4] = DateFormat.getDateInstance(DateFormat.SHORT); // Formato mais conciso (somente números).
        df[5] = DateFormat.getDateInstance(DateFormat.MEDIUM); // Formato um pouco mais legível (abreviado).
        df[6] = DateFormat.getDateInstance(DateFormat.LONG); // Formato mais extenso.
        df[7] = DateFormat.getDateInstance(DateFormat.FULL); // Formato mais completo (incluindo o dia da semana)

        for (DateFormat dateFormat: df){
            System.out.println(dateFormat.format(calendar.getTime()));
        }
    }
}
