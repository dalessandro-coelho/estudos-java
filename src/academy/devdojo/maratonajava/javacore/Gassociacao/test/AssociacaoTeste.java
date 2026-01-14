package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Aluno;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Local;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Professor;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Seminario;

public class AssociacaoTeste {
    public static void main(String[] args) {
        Local local = new Local("Rua dos Milagres");

        Aluno aluno = new Aluno("João", 15);

        Professor professor = new Professor("Danilo", "Matemática");

        Aluno[] alunoSeminario = {aluno};
        Seminario seminario = new Seminario("Funções", alunoSeminario, local);
        Seminario[] seminarioDisponivel = {seminario};

        professor.setSeminario(seminarioDisponivel);

        professor.imprime();
    }
}
