package academy.devdojo.maratonajava.javacore.Xserializacao.dominio;

import java.io.*;

public class Aluno implements Serializable {
    // serialVersionUID -> Garante a compatibilidade entre versões da classe serializada.
    @Serial
    private static final long serialVersionUID = 739959230178355186L;
    private Long id;
    private String nome;
    private transient String password;
    //Campos estáticos não são serializados.
    private static final String NOME_ESCOLA = "DevDojo Viradão no Jiraya";
    // transient -> Modificador que indica a um atributo que não deve ser incluído no processo de serialização.
    private transient Turma turma;

    public Aluno(Long id, String nome, String password) {
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    //
    @Serial
    private void writeObject(ObjectOutputStream oos){
        try {
            oos.defaultWriteObject();
            oos.writeUTF(turma.getNome());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Serial
    private void readObject(ObjectInputStream ois){
        try {
            ois.defaultReadObject();
            String nomeTurmna = ois.readUTF();
            turma = new Turma(nomeTurmna);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", NOME_ESCOLA='" + NOME_ESCOLA + '\'' +
                ", Turma='" + turma + '\'' +
                '}';
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}