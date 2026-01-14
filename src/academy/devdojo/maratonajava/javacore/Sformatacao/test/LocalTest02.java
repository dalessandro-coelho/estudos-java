package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.util.Locale;

public class LocalTest02 {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault()); // Qual lingua está configurado no computador
        String[] isoCountries = Locale.getISOCountries();
        String[] isoLanguages = Locale.getISOLanguages();

        for (String isoLanguage : isoLanguages) {
            System.out.print(isoLanguage+" ");
        }
        System.out.println();

        for (String isoCountry : isoCountries) {
            System.out.print(isoCountry+" ");
        }

    }
}
