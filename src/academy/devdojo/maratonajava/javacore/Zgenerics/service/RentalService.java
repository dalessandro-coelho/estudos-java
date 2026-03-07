package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import java.util.List;

// Antes existia o tipo específico como Carro ou Barco, agora utiliza-se o "T", onde vai indicar que
// essa classe vai trabalhar com algum tipo, mas que será especificado quando for usado,ou seja, pode
// ser String na primeira que instaciar e Integer na segunda, por exemplo.
public class RentalService<T> {
    private List<T> objetosDisponiveis;

    public RentalService(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }

    public T buscarObjetoDisponivel() {
        System.out.println("Buscando objeto disponivel...");
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando Objeto: " + t);
        System.out.println("Objetos disponiveis para alugar");
        System.out.println(objetosDisponiveis);
        return t;
    }

    public void retornarObjetoAlugado(T t) {
        System.out.println("Devolvendo objetos" + t);
        objetosDisponiveis.add(t);
        System.out.println("Objetos disponiveis para alugar: ");
        System.out.println(objetosDisponiveis);
    }
}