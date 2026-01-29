package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest01 {
    public static void main(String[] args) throws IOException {

        // BasicFileAttributes -> Serve pra saber coisas básicas sobre um arquivo ou pasta, sem mexer nela.

        //Utilizando pacote java.io.File para alterar data de modificação (Forma Antiga).
        LocalDateTime date = LocalDateTime.now().minusDays(10);
        File file = new File("pasta2/novo.txt");
        boolean isCreated = file.createNewFile();
        boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());

        //Utilizando pacote java.nio.file.Files para alterar data de modificação (Forma Nova).
        Path path = Paths.get("pasta2/novo_path.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
        Files.setLastModifiedTime(path, fileTime);

        // Metodos da classe "Files" para checar propridades básicas de forma direta.
        System.out.println(Files.isWritable(path)); // “Eu consigo ler esse arquivo?”
        System.out.println(Files.isReadable(path)); // “Eu consigo escrever nesse arquivo?”
        System.out.println(Files.isExecutable(path)); // “Eu consigo executar esse arquivo?”
    }
}