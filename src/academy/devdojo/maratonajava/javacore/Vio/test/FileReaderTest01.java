package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        // FileReader ->  Fluxo orientado a caracteres usado para ler texto de arquivos.
        try (FileReader fr = new FileReader(file)) {

            /*
            Para ver a letra real no console, é necessário fazer um cast.
            char[] in = new char[30]; // Deve indicar no array até quantos caracteres quer vê do texto.
            fr.read(in);
            for (char c : in) {
                System.out.print(c);
            }
            */

            //Para ler o arquivo completo utiliza-se while, onde "-1" indica o fim.
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
//                System.out.print(i+" "); Assim só trás uma sequência de números, representado pela tabela ASCII.
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
