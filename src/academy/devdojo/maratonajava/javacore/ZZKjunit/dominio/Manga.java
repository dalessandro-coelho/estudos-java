package ZZKjunit.dominio;

import java.util.Objects;

// Record: É um tipo especial de classe no Java cuja única finalidade é ser um portador de dados imutáveis.
// Em vez de escrever dezenas de linhas, pode definir a classe em apenas uma linha.
// O Java gera automaticamente:
//  construtor
//  getters
//  toString()
//  equals()
//  hashCode()

public record Manga(String name, int episodes) {
    public Manga {
        Objects.requireNonNull(name);
    }
}