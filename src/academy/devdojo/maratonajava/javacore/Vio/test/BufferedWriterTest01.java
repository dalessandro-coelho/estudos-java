package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        //BufferedWriter -> Escreve texto em arquivos de forma mais rápida, guardando temporariamente na memória antes de salvar no disco.
        try (FileWriter fw = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fw)) {

            br.write("Aprendendo BufferedWriter");
            br.newLine(); // Substitui usar o "\n", pois pode não funcionar em todos os sistemas operacionais.
            br.flush();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
