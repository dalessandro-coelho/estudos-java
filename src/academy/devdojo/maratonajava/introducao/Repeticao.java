package academy.devdojo.maratonajava.introducao;
//Dado o valor de um carro, descubra em quantas vezes ele pode ser parcelado
//Condição valorParcela >= 1000
public class Repeticao {
    public static void main(String[] args) {
        int valor = 30000;
        int parcelas = 0;
        int i = 0;

        while(true){
            i++;
            parcelas = valor / i;
            if (parcelas < 1000){
                break;
            }
            System.out.println(i);
        }
    }
}
