package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());
        printConsulta(cachorros);
        printConsulta(gatos);
        List<Animal> animals = new ArrayList<>();
        printConsultaAnimal(animals);
    }

    // ? extends Animal -> Aceita esse tipo OU qualquer FILHO dele, onde pode ler, mas não pode adicionar, pois o compilador não sabe qual subtipo exato é.
    // extends -> Usar quando quer apenas obter itens de uma coleção (Producer Extends).
    private static void printConsulta(List<? extends Animal> animals){
        for (Animal animal : animals) {
            animal.consulta();
        }
    }

    // ? super Animal -> Aceita esse tipo OU qualquer PAI dele, e pode adicionar elementos.
    // super -> Usar quando quer adicionar itens a uma coleção (Consumer Super)
    private static void printConsultaAnimal(List<? super Animal>animals){
        animals.add(new Cachorro());
        animals.add(new Gato());
    }
}