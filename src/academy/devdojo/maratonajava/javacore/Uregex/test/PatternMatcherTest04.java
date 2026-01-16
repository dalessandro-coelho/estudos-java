package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest04 {
    public static void main(String[] args) {
        // \d -> Vai retornar todos os dígitos.
        // \D -> NÃO vai retornar os digitos.
        // \s -> Vai retornar espaços em branco (Também pode usar "\t","\n","\f" ou "\r" para retornar espaços em branco).
        // \S -> NÃO vai retornar espaços em branco.
        // \w -> Vai retornar tudo de a-z (minusculo),A-Z(maiusculo), dígitos e "_" (Tudo menos os caracteres especiais, incluindo espaço).
        // \W -> Vai retornar tudo que NÃO for incluso no \w.
        // Range -> Representado por colchetes [].
        // Quantificadores (“quantas vezes isso pode aparecer”):
        // ? -> Zero ou uma ocorrência(Ex: a? -> aceita " "(nada) ou a, mas não aceita aa. colou?r -> aceita color ou colour).
        // * -> Zero ou mais ocorrência(Ex: a* -> aceita " "(nada) ou a ou aaaaaa. ba* -> aceita b ou ba ou baaaaa).
        // + -> uma ou mais ocorrências (Ex: a+ -> aceita a ou aaaa, mas não " "(nada). ba+ -> aceita ba ou baaaa, mas não b).
        // {n} -> Exatamente n (Ex: a{3} -> aceita aaa, mas não a ou aa).
        // {n,} -> n ou mais (Ex: a{2,} -> aceita aa ou aaaaaa, mas não a).
        // {n,m} -> Entre n e m (Ex: a{2,4} -> aceita aa ou aaa ou aaaa, mas não a ou aaaaa).
        // () -> Usados para agrupamentos (Ex: (ab)+ -> aceita ab ou abab, mas não a ou b).
        // | -> Funciona como um "OU" lógico (Ex: a|b -> aceita a ou b, mas não ab .(abc|def) -> aceita "abc" ou "def").
        // $ -> Representa o fim da linha (Ex: abc$ -> aceita abc, mas não abcd ou xabc).

        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)"; // No lugar desse "0-9" também poderia colocar "\\d", que daria no mesmo, pois ambos vão utilizar digitos de 0 a 9.
        String texto = "12 0x 0x 0xFFABC 0x10G 0x1";
        Pattern pattern = Pattern.compile(regex); //Pattern -> É o padrão (a regra) que define o que será procurado.
        Matcher matcher = pattern.matcher(texto); //Matcher -> Quem aplica essa regra em um texto específico e faz a busca.
        System.out.println("texto:  " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex: " + regex);
        System.out.println("Posições encontradas:");
        while (matcher.find()) { // Find -> Procura o padrão dentro do texto, pedaço por pedaço(Vai fazer a seguinte perguta: “Existe isso aqui em algum lugar?”).
            System.out.print(matcher.start() + " "); //Onde começa o Match
            //System.out.println(matcher.end()+" "); //Onde termina o Match
            System.out.println(matcher.group() + " "); //Vai juntar os caracteres
        }
    }
}
