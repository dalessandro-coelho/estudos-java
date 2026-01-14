package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest02 {
    public static void main(String[] args) {
        String nome = "   Luffy   ";
        System.out.println(nome.charAt(0)); // Retorna o caractere (char) na posição (índice) especificada
        System.out.println(nome.length()); // Retorna o tamanho total da string (o número de caracteres).
        System.out.println(nome.replace("f", "l")); // Retorna uma nova string na qual todas as ocorrências do primeiro caractere são substituídas pelo segundo caractere.
        System.out.println(nome.toLowerCase()); // Converte todos os caracteres da string para minúsculas.
        System.out.println(nome.toUpperCase()); // Converte todos os caracteres da string para maiúsculas.
        System.out.println(nome.trim()); // Remove todos os espaços em branco que estão no início e no fim da string.

        System.out.println("-----------------");

        String numeros = "012345";
        System.out.println(numeros.length());
        System.out.println(numeros.substring(2)); // Retorna a porção da string que começa no índice beginIndex (inclusivo) e vai até o final.
        System.out.println(numeros.substring(3, 5)); // Retorna a porção da string que começa no índice beginIndex (inclusivo) e termina no índice endIndex (exclusivo).
        System.out.println(numeros.substring(3, numeros.length()));
    }
}
