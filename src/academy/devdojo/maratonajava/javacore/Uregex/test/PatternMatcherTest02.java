package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {
    public static void main(String[] args) {
        // \d -> Vai retornar todos os dígitos.
        // \D -> NÃO vai retornar os digitos.
        // \s -> Vai retornar espaços em branco (Também pode usar "\t","\n","\f" ou "\r" para retornar espaços em branco).
        // \S -> NÃO vai retornar espaços em branco.
        // \w -> Vai retornar tudo de a-z (minusculo),A-Z(maiusculo), dígitos e "_" (Tudo menos os caracteres especiais, incluindo espaço).
        // \W -> Vai retornar tudo que NÃO for incluso no \w.

        String regex = "\\W";
//        String texto = "abaaba";
        String texto2 = "@t_4 55wg#y";
        Pattern pattern = Pattern.compile(regex); //Pattern -> É o padrão (a regra) que define o que será procurado.
        Matcher matcher = pattern.matcher(texto2); //Matcher -> Quem aplica essa regra em um texto específico e faz a busca.
        System.out.println("texto:  "+texto2);
        System.out.println("indice: 0123456789");
        System.out.println("regex: "+regex);
        System.out.println("Posições encontradas:");
        while (matcher.find()){ // Find -> Procura o padrão dentro do texto, pedaço por pedaço(Vai fazer a seguinte perguta: “Existe isso aqui em algum lugar?”).
            System.out.print(matcher.start()+" "); //Onde começa o Match
            //System.out.println(matcher.end()+" "); //Onde termina o Match
            System.out.println(matcher.group()+" "); //Vai juntar os caracteres
        }
    }
}
