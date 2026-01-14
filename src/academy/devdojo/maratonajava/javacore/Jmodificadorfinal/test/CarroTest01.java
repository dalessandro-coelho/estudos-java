package academy.devdojo.maratonajava.javacore.Jmodificadorfinal.test;

import academy.devdojo.maratonajava.javacore.Jmodificadorfinal.dominio.Carro;
import academy.devdojo.maratonajava.javacore.Jmodificadorfinal.dominio.Ferrari;

public class CarroTest01 {
    public static void main(String[] args) {
        Carro carro = new Carro();

        System.out.println(Carro.VELOCIDADE_LIMITE);
        System.out.println(carro.COMPRAD0R);

        carro.COMPRAD0R.setNome("João");
        System.out.println(carro.COMPRAD0R);

        Ferrari ferrari = new Ferrari();
        ferrari.setNome("Mário");
        ferrari.imprime();

    }
}
