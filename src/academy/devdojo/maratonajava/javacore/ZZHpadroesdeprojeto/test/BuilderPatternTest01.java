package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {

        // Em vez de passar tudo de uma vez no construtor, sem saber se está passando o nome ou o sobrenome de uma pessoa:
        // Pessoa p = new Pessoa("William", "Suane", "ViradoNoJiraya", "William.suane@devdojo.academy");

        // Pode chamar métodos que dizem exatamente o que estás a definir:
        Person build = new Person.PersonBuilder()
                .firstName("William")
                .lastName("Suane")
                .lastName("ViradoNoJiraya")
                .email("William.suane@devdojo.academy")
                .build(); // Aqui o objeto nasce.
        System.out.println(build);
    }
}
