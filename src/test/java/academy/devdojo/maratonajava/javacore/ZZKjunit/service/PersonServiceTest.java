package academy.devdojo.maratonajava.javacore.ZZKjunit.service;

import academy.devdojo.maratonajava.javacore.ZZKjunit.dominio.Person;
import academy.devdojo.maratonajava.javacore.ZZKjunit.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonServiceTest {

    @Test
    @DisplayName("A person should be not adult when age is lower than 18") //Metodos longos pode usar esta anotação para escrever uma frase, que será exibida no relatório de testes da IDE.
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        Person person = new Person(15);
        PersonService personService = new PersonService();
        Assertions.assertFalse(personService.isAdult(person));
    }
}