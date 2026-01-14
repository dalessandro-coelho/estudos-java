package academy.devdojo.maratonajava.introducao;
public class Operadores {
    public static void main(String[] args) {
        double salario = 70000;
        double valor = 0;

        if (salario <= 34712) {
            valor = salario * 9.70;
        } else if (salario >= 34713 && salario < 68507) {
            valor = salario * 37.35;
        } else if (salario >= 68508){
            valor = salario * 49.50;
        }
        System.out.printf("%.2f",valor);
    }
}
