package academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio;

import lombok.Builder;
import lombok.Value;

import java.util.Objects;

@Value
@Builder
public final class Producer {
    /*
    * Lombok: É uma biblioteca que serve para limpar o código Java.
    * Quando cria uma classe precisa escrever Getters, Setters, toString...e isso ocupa muita linha.
    * Agora, com apenas uma linha como @Builder em cima da classe, o Lombok gera tudo isso "por baixo dos panos" na hora de compilar.
    * */

    private final Integer id;
    private final String name;
}
