package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassTest02 {

    // Classes locais -> São classes declaradas dentro de um metodo e só podem ser utilizadas dentro do escopo desse metodo.

    private String name = "Midorya";

    // Antes do java 8 era obrigado declarar "final", Agora basta que a variável seja "efetivamente final"(não seja modificada).
    void print(final String param){
        final String lastName = "Izuku";

        // Não aceitam modificador de acesso "public" ou "private".
        class LocalClass{
            public void printLocal(){
                System.out.println(param);
                System.out.println(name + " "+ lastName);
            }
        }
        // Classe Local inicializa dentro do metodo.
        new LocalClass().printLocal();
    }
    public static void main(String[] args) {
        OuterClassTest02 outer = new OuterClassTest02();
//        outer.print();
    }
}
