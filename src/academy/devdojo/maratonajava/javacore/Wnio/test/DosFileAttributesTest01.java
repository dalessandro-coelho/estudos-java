package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta/teste.txt");
        if (Files.notExists(path)) Files.createFile(path);

//        Deixar o arquivo oculto:
//        Files.setAttribute(path, "dos:hidden", true);
//        Files.setAttribute(path, "dos:readonly", true);
//        Tirar o arquivo do oculto:
//        Files.setAttribute(path, "dos:hidden", false);
//        Files.setAttribute(path, "dos:readonly", false);

        //DosFileAttributes -> Mesma finalidade do BasicFileAttributes, só que com campos extras que só existem no Windows.

        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isHidden()); // Define se o arquivo está oculto ou não no explorador.
        System.out.println(dosFileAttributes.isReadOnly()); // Define se o arquivo pode ser editado (lido).

        // DosFileAttributeView -> Estende o "BasicFileAttributeView", permitindo a modificação de atributos específicos do sistema DOS/Windows, além dos tempos(datas) do arquivo.

        DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        fileAttributeView.setHidden(true);
        fileAttributeView.setReadOnly(true);
        System.out.println(fileAttributeView.readAttributes().isHidden());
        System.out.println(fileAttributeView.readAttributes().isReadOnly());
    }
}