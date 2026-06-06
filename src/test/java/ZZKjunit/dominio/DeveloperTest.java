package ZZKjunit.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperTest {

    /*Pattern Matching for instanceof: Permite verificar o tipo e criar automaticamente uma variável já convertida para esse tipo.
    Antes:
    verifica → faz cast

    Agora:
    verifica e faz cast ao mesmo tempo
    */

    @Test
    public void instanceOf_ExecuteChildClassMethod_WhenObjectIsOfChildType(){
        Employee employeeDeveloper = new Developer("1", "Java");
        //Forma antiga.
        if (employeeDeveloper instanceof Developer){
            Developer developer = (Developer) employeeDeveloper;
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }

        //Forma nova.
        if (employeeDeveloper instanceof Developer developer){
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }
    }
}