package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

// Classe Externa
public class OuterClassesTest01 {

    // Classes internas -> São classes declaradas dentro de outra classe, tendo o "poder" de acessar todos os atributos e
    // métodos da classe externa, inclusive os privados.

    private String name = "Monkey D.Luffy";

    // Classe Interna
    class Inner {
        public void printOuterClassAttribute() {
            System.out.println(name);

            //"this" fazendo referencia a classe interna.
            System.out.println(this);

            //"this" fazendo referencia a classe externa.
            System.out.println(OuterClassesTest01.this);
        }
    }

    public static void main(String[] args) {
        // Para criar um objeto da classe interna, é obrigatorio uma instância da classe externa.
        OuterClassesTest01 outerClass = new OuterClassesTest01();
        Inner inner = outerClass.new Inner();
        inner.printOuterClassAttribute();

        // Também pode instanciar tudo em uma única linha.
//        Inner inner2 = new OuterClassesTest01().new Inner();
//        inner2.printOuterClassAttribute();
    }
}