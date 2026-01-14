package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest01 {
    public static void main(String[] args) {
        String regex = "aba";
        String texto = "abaaba";
        String texto2 = "abababa";
        Pattern pattern = Pattern.compile(regex); //Pattern -> É o padrão (a regra) que define o que será procurado.
        Matcher matcher = pattern.matcher(texto2); //Matcher -> Quem aplica essa regra em um texto específico e faz a busca.
        System.out.println("texto:  "+texto2);
        System.out.println("indice: 0123456789");
        System.out.println("regex: "+regex);
        System.out.println("Posições encontradas:");
        while (matcher.find()){ // Find -> Procura o padrão dentro do texto, pedaço por pedaço(“Existe isso aqui em algum lugar?”).
            System.out.print(matcher.start()+" "); //Onde começa o Match
            System.out.println(matcher.end()+" "); //Onde termina o Match
        }
    }
}
