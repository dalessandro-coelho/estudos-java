package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("pasta2/new.txt");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class); // readAttributes() -> Lê os dados dos arquivos.
        FileTime creationTime = basicFileAttributes.creationTime(); // creationTime() -> Data da Criação.
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime(); // lastModifiedTime() -> Data da última modificação.
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime(); // lastAccessTime() -> Data do último acesso (quando abriu ou leu).

        System.out.println("creationTime: "+creationTime);
        System.out.println("lastModifiedTime: "+lastModifiedTime);
        System.out.println("lastAccessTime: "+lastAccessTime);

        System.out.println("-------------------------------");

        // BasicFileAttributeView -> Pode acessar tudo o que "BasicFileAttributes" acessa e, além disso, pode modificar alguns atributos (exclusivamente as datas).
        // Tudo que tiver "View", pode fazer modificação.

        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        FileTime newCreationTime = FileTime.fromMillis(System.currentTimeMillis());
        fileAttributeView.setTimes(lastModifiedTime, newCreationTime,creationTime);

        creationTime = fileAttributeView.readAttributes().creationTime();
        lastModifiedTime = fileAttributeView.readAttributes().lastModifiedTime();
        lastAccessTime = fileAttributeView.readAttributes().lastAccessTime();

        System.out.println("creationTime: "+creationTime);
        System.out.println("lastModifiedTime: "+lastModifiedTime);
        System.out.println("lastAccessTime: "+lastAccessTime);

    }
}