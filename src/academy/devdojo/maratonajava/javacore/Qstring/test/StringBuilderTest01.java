package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringBuilderTest01 {
    public static void main(String[] args) {
        String nome = "William Suane";
        nome.concat(" DevDojo");
        nome.substring(0,3); // Retorna uma sub-string da sequência.
        System.out.println(nome);


        StringBuilder sb = new StringBuilder("William Suane");
        sb.append(" DevDojo").append(" Academy"); // Adiciona o argumento ao final da sequência.
        sb.reverse(); //Inverte a ordem dos caracteres na sequência.
        sb.reverse(); // Se usou duas vezes, vai retornar o mesmo valor de antes.
        sb.delete(0,3); // Remove os caracteres no intervalo especificado.
        System.out.println(sb);
    }
}
