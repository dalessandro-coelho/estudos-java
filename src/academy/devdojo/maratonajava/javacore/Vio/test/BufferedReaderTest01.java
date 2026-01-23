package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.*;

public class BufferedReaderTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        // BufferedReader -> É como um FileReader turbinado: ele faz a mesma leitura, só que de forma mais eficiente, lendo em blocos usando um buffer na memória.
        try (FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)) {

            //readLine -> Retorna uma String com a linha inteira, enquanto o FileReader lê caractere por caractere e retorna o código numérico (int) de cada caractere.
            String linha;
            while((linha = br.readLine()) != null) { // O fim do arquivo é indicado pelo valor "null", diferente do FileReader que é "-1".
                System.out.println(linha);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
