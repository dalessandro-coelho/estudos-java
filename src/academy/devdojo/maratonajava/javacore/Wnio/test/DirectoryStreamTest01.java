package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest01 {
    public static void main(String[] args) {

        //DirectoryStream -> Lista apenas os arquivos e pastas que estão diretamente dentro do diretório informado (incluindo os ocultos), sem entrar nas subpastas.

        Path dir = Paths.get("."); // O ponto serve para representa o diretório de trabalho atual da aplicação, mas também pode colocar só o caminho, ou o nome do diretorio.
        // Sempre fechar com try-with-resources.
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) { // (dir, "*.txt") -> Ver só os arquivos do diretorio.
            for (Path path: stream){
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}