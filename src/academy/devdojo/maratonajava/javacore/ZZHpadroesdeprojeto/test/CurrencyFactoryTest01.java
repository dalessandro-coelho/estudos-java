package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Country;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Currency;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {

        //Factory é um padrão para criar objetos sem expor diretamente o new, ou seja,
        //em vez de usar new, pode usar um metodo que cria o objeto. E isso ajuda caso for mudar em um lugar (factory),
        //não precisa mudar o restante do código (Em vez de concertar 10, concerta só 1).

        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
