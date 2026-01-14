package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest01 {
    public static void main(String[] args) {

        /*
        Aspas simples serve para deixar ignorado o que estiver dentro delas,ou seja,
        vai imprimir exatamente o que tiver dentro dela.
        */
        String pattern01 = "yyy.MM.dd G 'at' HH:mm:ss z"; // Pode usar outras estruturas além dessas("yyy.MM.dd G 'at' HH:mm:ss z").
        String pattern02 = "'Amsterdam' dd 'de' MMMM 'de' yyyy";

        SimpleDateFormat sdf1 = new SimpleDateFormat(pattern01);
        SimpleDateFormat sdf2 = new SimpleDateFormat(pattern02);
        System.out.println(sdf1.format(new Date()));
        System.out.println(sdf2.format(new Date()));

        try {
            System.out.println(sdf2.parse("Amsterdam 19 de dezembro de 2025"));//Aqui ("Amsterdam 19 de dezembro de 2025") tem que estar do mesmo que la encima, se não da erro.
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
