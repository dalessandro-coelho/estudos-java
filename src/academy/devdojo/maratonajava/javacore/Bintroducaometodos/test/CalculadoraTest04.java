package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Calculadora;

public class CalculadoraTest04 {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        int num1 = 1;
        int num2 = 2;
        c.alteraDoisNumeros(num1, num2);
        System.out.println("Dentro da CalculadoraTest04");
        System.out.println(num1);
        System.out.println(num2);
    }
}
