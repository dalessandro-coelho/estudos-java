package academy.devdojo.maratonajava.javacore.Zgenerics.test;

abstract class Animal{
    public abstract void consulta();
}

class Cachorro extends Animal{
    @Override
    public void consulta() {
        System.out.println("Consultando doguinho");
    }
}

class Gato extends Animal{
    @Override
    public void consulta() {
        System.out.println("Consultando Gato");
    }
}
public class WildcardTest01 {

    //Wildcard -> É uma forma flexível de trabalhar com generics quando não sabe o tipo exato.

    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};
        printConsulta(cachorros);
        printConsulta(gatos );
        Animal[] animals = {new Gato(), new Cachorro()};
        printConsulta(animals);
    }

    private static void printConsulta(Animal[] animals){
        for (Animal animal : animals) {
            animal.consulta();
        }
        // Lança uma ArrayStoreException se tentar colocar um gato em um array de cachorros.
//         animals[1] = new Gato();
    }
}