package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

class Animal {
    public void walk(){
        System.out.println("Animal walking");
    }
}

public class AnonymousClassesTest01 {
    public static void main(String[] args) {

        // Classes Anônimas -> São classes sem nome criadas no momento da execução,
        // normalmente para implementar uma interface ou estender uma classe.

        //Não tem nome e são declaradas e instanciadas ao mesmo tempo( Animal animal = new Animal(){} ).
        Animal animal = new Animal(){
            @Override
            public void walk() {
                System.out.println("Walking in the shadows");
            }
        };
        animal.walk();
    }
}