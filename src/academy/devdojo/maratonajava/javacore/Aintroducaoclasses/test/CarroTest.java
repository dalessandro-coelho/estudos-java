package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro c1 = new Carro();
        Carro c2 = new Carro();

        c1.nome = "Fiat";
        c1.modelo = "Uno";
        c1.ano = 2015;

        c2.nome = "G10";
        c2.modelo = "Civic";
        c2.ano  = 2010;

        System.out.println(c1.nome + " " + c1.modelo + " " + c1.ano);
        System.out.println(c2.nome + " " + c2.modelo + " " + c2.ano);
    }
}
