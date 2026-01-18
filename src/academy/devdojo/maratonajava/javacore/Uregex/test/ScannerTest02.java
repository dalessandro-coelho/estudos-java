package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Scanner;

public class ScannerTest02 {
    public static void main(String[] args) {
        // Delimitador -> É o caractere (ou padrão) usado para separar a informação, ou seja, diz onde cortar (Ex: vírgulas, espaços, dígitos).
        //Token -> É o dado real extraído após aplicar do delimitador, ou seja, é o pedaço cortado (Ex: Em uma string de e-mails separados por vírgula, cada e-mail é um token).

        String texto = "Levi,Eren,Mikasa,true,200";
        Scanner sc = new Scanner(texto);
        sc.useDelimiter(","); //sc.useDelimiter -> Diz ao Scanner qual caractere (ou padrão) será usado para separar os dados da entrada.
        while (sc.hasNext()) { //hasNext -> Verifica se existe um próximo Token.
            if (sc.hasNextInt()) { //hasNextInt -> Captura números inteiros.
                int i = sc.nextInt();
                System.out.println("Int: " + i);
            } else if (sc.hasNextBoolean()) { //hasNextBoolean -> Captura valores verdadeiros ou falsos.
                boolean b = sc.nextBoolean();
                System.out.println("Boolean: " + b);
            } else {
                System.out.println(sc.next());
            }
        }
    }
}
