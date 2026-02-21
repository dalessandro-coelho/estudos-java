package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

import java.util.Objects;

//Ao implementar essa interface, é obrigatorio sobrescrever o metodo "compareTo".
public class Manga implements Comparable<Manga>{
        private Long id;
        private String nome;
        private double preco;
        private int quantidade;

    public Manga(Long id, String nome, double preco) {
        Objects.requireNonNull(id, "Id não pode ser null"); // Valida se um objeto passado como argumento não é null.
        Objects.requireNonNull(nome, "Nome não pode ser null");
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Manga(Long id, String nome, double preco, int quantidade) {
        this(id, nome, preco);
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Double.compare(preco, manga.preco) == 0 && Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco);
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Manga outroManga) {
        // compareTo retorna 3 opções:
        // 1 - Negativo se o this < outroManga
        // 2 - Se this == outroManga, return 0
        // 3 - Negativo se o this > outroManga

        // Forma de fazer Manualmente utilizando "if-else" (Não é aconselhavel fazer dessa forma).
//        if (this.id < outroManga.getId()){
//            return -1;
//        } else if (this.id.equals(outroManga.getId())) {
//            return 0;
//        } else {
//            return 1;
//        }
        //Outra forma de fazer, pois como é um tipo Long (Wrappers), já vem o "compareTo" implementado nele.
//        return this.id.compareTo(outroManga.getId());

        // Para tipos primitivos como double (que não têm métodos),pode usar o metodo estático da classe Wrapper (Duas formas de fazer).
//        return Double.compare(preco , outroManga.getPreco());
//        return Double.valueOf(preco).compareTo(outroManga.getPreco());

        // Para tipos "String".
        return this.nome.compareTo(outroManga.getNome());
    }
}