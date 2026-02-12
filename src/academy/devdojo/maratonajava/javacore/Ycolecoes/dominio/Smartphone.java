package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

public class Smartphone {
    private String serialNumber;
    private String marca;

    public Smartphone(String marca, String serialNumber) {
        this.marca = marca;
        this.serialNumber = serialNumber;
    }

    // Para que o Java aceite a implementação como válida, deve seguir estes princípios:
    // Reflexivo -> x.equals(x) tem que ser "true" para tudo que for diferente de "null".
    // Simetrico -> Para x e y diferentes de null, se x.equals(y) == true logo, y.equals(x) == true.
    // Transitividade -> Para x,y,z diferentes de null, se x.equals(y) == true, e x.equals(z) == "true" logo, y.equals(z) == true.
    // Consistente -> x.equals(x) sempre retorna "true" se x for diferente de null.
    // Comparação com "null" -> x.equals(null) deve retornar sempre false.
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false; // Comparação com null - Nenhum objeto pode ser igual a null.
        if (this == obj) return true; // Reflexivo - Os dois apontam para o mesmo objeto na memória.
        if (this.getClass() != obj.getClass()) return false; // Simetria - Só compara Smartphone com Smartphone.
        // Implementam a lógica que garante a "Transitividade" e a "Consistência".
        Smartphone smartphone = (Smartphone) obj;
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber); // Parte essencial dessa garantia.
    }

    // hasCode() -> É um método que retorna um número inteiro representando o objeto.

    // Dois objetos iguais pelo "equals()", eles DEVEM ter o mesmo "hashCode()".
    // Dois objetos iguais pelo "hashCode", podem ser ou não iguais, por isso usa "equals()" para diferenciar(Chamado de colisão de hash).
    // Dois objetos diferentes pelo "equals()", podem ou não ter o mesmo "hashCode()".
    // Dois objetos diferentes pelo "hashCode", o "equals()" é diferente.
    // hashCode() filtra e equals() confirma.
    @Override
    public int hashCode() {
        // return serialNumber == null ? 0 : this.serialNumber.hashCode(); // É bom verificar se é nulo antes de chamar o hasCode(), para evitar NullPointException.
        return this.serialNumber.hashCode();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}