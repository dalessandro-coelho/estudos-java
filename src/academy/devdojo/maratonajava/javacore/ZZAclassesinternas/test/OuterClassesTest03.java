package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest03 {

    // Classe aninhadas estáticas ->

    private String name = "William";

    static class Nested {
        private String lastName = "Suane";

        void print() {
            // Não pode acessar a variavel "name", pois ela não é estatica e está chamando ela dentro da classe estatica.
//            System.out.println(name);

            // Para acessar a variavel, primeiro teria que usar "new", e depois chamar a classe externa e a variavel.
//            System.out.println(new OuterClassesTest03().name);

            System.out.println(new OuterClassesTest03().name + " " + lastName);
        }
    }

    public static void main(String[] args) {
        //Forma de acessar.
        Nested nested = new Nested();
        nested.print();

        // Outra forma de acessar, mas não é preciso.
//        OuterClassesTest03.Nested nested = new OuterClassesTest03.Nested();
    }
}