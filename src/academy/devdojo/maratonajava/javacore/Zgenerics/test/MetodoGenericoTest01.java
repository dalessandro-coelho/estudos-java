package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.Comparator;
import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {

        //Metodo Generico -> É quando cria um metodo que usa tipos genéricos sem precisar que a classe seja genérica, onde
        // a diferença principal é que o tipo vem antes do retorno do metodo.

//        criarArrayComUmObjeto(new Barco("Canoa Marota"));

        // Forma de retornar
//        List<Barco> barcoList = criarArrayComUmObjeto(new Barco("Canoa Marota"));
//        System.out.println(barcoList);



    }

    // Metodo genérico segue uma ordem específica:
    // 1 - Modificador de acesso (ex: public, static).
    // 2 - Parâmetro de tipo entre diamantes (<T>).
    // 3 - Tipo de retorno (pode ser o próprio T, uma List<T>, ou void).
    // 4 - Nome do metodo e parâmetros formais.

    private static <T> void criarArrayComUmObjeto(T t){
        List<T> list = List.of(t);
        System.out.println(list);
    }

    // Para retornar o metodo.
//    private static <T> List<T> criarArrayComUmObjeto(T t){
//        return List.of(t);
//    }

    // Recebe objetos somente do tipo Comparable.
//    private static <T extends Comparable<T>> List<T> criarArrayComUmObjeto(T t){
//        return List.of(t);
//    }
}