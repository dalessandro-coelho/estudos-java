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