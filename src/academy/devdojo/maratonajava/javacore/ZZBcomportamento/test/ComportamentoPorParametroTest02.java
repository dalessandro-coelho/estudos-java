package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;
import academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {

    private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

    public static void main(String[] args) {

        // Filtrando da lista "cars" apenas os carros que são verdes.
//        List<Car> greenCars = filter(cars, new CarPredicate() {
//            @Override
//            public boolean test(Car car) {
//                return car.getColor().equals("green");
//            }
//        });
        // Outra forma de fazer, mas  resumido:
        List<Car> greenCars = filter(cars, car -> car.getColor().equals("green"));
        System.out.println(greenCars);

        // Filtrando da lista "cars" apenas os carros que são vermelhas.
        List<Car> redCars = filter(cars, car -> car.getColor().equals("red"));
        System.out.println(redCars);

        // Filtrando carros antes de 2015.
        List<Car> yearBeforeCars = filter(cars, car -> car.getYear() < 2015);
        System.out.println(yearBeforeCars);
    }

    //Filtro -> É uma regra aplicada a um conjunto de dados para selecionar apenas os elementos que atendem a determinada condição.

    //Percorre uma lista de carros e retorna apenas os carros que passam na regra definida pelo CarPredicate.
    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car)) {
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }
}