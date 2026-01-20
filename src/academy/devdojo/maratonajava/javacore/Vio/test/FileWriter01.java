package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        // FileWriter -> Escreve dados de caracteres (texto) em arquivos.
        try (FileWriter fw = new FileWriter(file/*, true*/)) { // Se deixar "true", vai manter o conteúdo antigo e adiciona outro ao final sempre que executar, por conta do "append".
            fw.write("Aprendendo FileWriter\nDando continuidade aprendendo FileWriter\n"); // O que vai ser escrito no arquivo.
            // fw.close(); -> Trabalhando com circuito operacional tem que fechar, mas acima já esta fechando automaticamente (FileWriter fw = new FileWriter(file));
            fw.flush(); // Tudo que estava guardado no buffer, é liberado  imediatamente para o destino.
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
