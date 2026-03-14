package academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

// Lambda -> É uma expressão que representa uma função anônima usada para implementar rapidamente o comportamento de uma interface funcional(só existe com ela).
// Dividida em:
// (parametro) -> <expressao>
// Exemplo:
// (Car car) -> car.getColor().equals("green");

// Interface Funcional -> É uma interface que possui apenas um único metodo abstrato.Pode ter vários métodos, mas somente um metodo abstrato que precisa ser implementado.

@FunctionalInterface
public interface CarPredicate {

    //O Metodo da interface funcional, define o contrato de como a Lambda tem que ser.
    boolean test(Car car);
}