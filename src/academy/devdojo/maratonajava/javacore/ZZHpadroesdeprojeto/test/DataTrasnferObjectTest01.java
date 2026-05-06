package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.*;

import java.util.ArrayList;

public class DataTrasnferObjectTest01 {
    public static void main(String[] args) {

        /*
        * O DTO (Data Trasnfer Object) é como se fosse uma caixa,onde só serve para transportar dados entre diferentes partes do sistema
        * (como do Banco de Dados para a tela do usuário) sem carregar peso desnecessário.
        * */

        Aircraft aircraft = new Aircraft("777");
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);

        Person person = Person.PersonBuilder
                .builder()
                .firstName("William")
                .lastName("Suane")
                .build();

        ReportDto reportDto = ReportDto.ReportDtoBuilder.builder()
                .aircrafName(aircraft.getName())
                .country(country)
                .currency(currency)
                .personName(person.getFirstName())
                .build();

        System.out.println(reportDto);
    }
}
