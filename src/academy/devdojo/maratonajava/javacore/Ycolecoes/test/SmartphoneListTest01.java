package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;
import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1", "iPhone");
        Smartphone s2 = new Smartphone("22222", "Pixel");
        Smartphone s3 = new Smartphone("33333", "Samsung");
        List<Smartphone> smartphones = new ArrayList<>(6);
        smartphones.add(s1);
        smartphones.add(s2);
        // add(index, elemento) -> Permite inserir um objeto em uma posição específica.
        smartphones.add(0,s3);

        // smartphones.clear(); // clear() -> Limpa todos os elementos de uma lista sem perder a variável de referência.

        for (Smartphone smartphone: smartphones){
            System.out.println(smartphone);
        }

        Smartphone s4 = new Smartphone("22222", "Pixel");

        // contains() -> Retorna "true" ou "false" se o objeto existir na lista.
        System.out.println(smartphones.contains(s4));

        // indexOf() -> Retorna o índice (posição) do objeto na lista. Se não encontrar, retorna -1.
        int indexSmartphone4 = smartphones.indexOf(s4);
        System.out.println(indexSmartphone4);

        //get(index) -> Recupera o objeto em uma posição exata.
        System.out.println(smartphones.get(indexSmartphone4));
    }
}