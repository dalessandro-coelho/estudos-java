package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

public class EqualsTest01 {
    public static void main(String[] args) {
        /**
         * == -> Verifica se duas variáveis apontam para o mesmo objeto na memória.
         * equals() -> Se não tiver trabalhando com objeto,só vai comparar os valores (conteúdo);
         * caso contrário, seu comportamento é o mesmo do operador "==".
         */

        Smartphone s1 = new Smartphone("1ABC1", "iPhone");
        Smartphone s2 = new Smartphone("1ABC1", "iPhone");
        System.out.println(s1.equals(s2)); // false

        Smartphone s3 = new Smartphone("1ABC1", "iPhone");
        Smartphone s4 = s3;
        System.out.println(s3.equals(s4)); // true

        String nome = "Dalessandro Coelho";
        String nome2 = "Dalessandro Coelho";
        System.out.println(nome == nome2); // true

        String nome3 = "Dalessandro Coelho";
        String nome4 = new String("Dalessandro Coelho");
        System.out.println(nome3 == nome4); // false
        System.out.println(nome3.equals(nome4)); // true
    }
}