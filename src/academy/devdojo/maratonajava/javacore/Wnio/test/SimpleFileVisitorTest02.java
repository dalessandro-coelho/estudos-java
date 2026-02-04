package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file.getFileName());
        return FileVisitResult.SKIP_SIBLINGS;
    }

    //preVisitDirectory -> Invocado antes de entrar em um diretório/pasta.
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("pre visit :"+dir.getFileName());
        return FileVisitResult.CONTINUE; // preVisitDirectory em "CONTINUE" e visitFile em "SKIP_SIBLINGS",vai ignorar os outros arquivos que estão no mesmo nível de diretório.
    }

    // visitFileFailed -> Invocado quando um arquivo não pode ser acessado.
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }

    // postVisitDirectory -> Invocado após todos os arquivos e subpastas de um diretório terem sido visitados.
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("post visit :"+dir.getFileName());
        return FileVisitResult.SKIP_SUBTREE;
    }
}

public class SimpleFileVisitorTest02 {
    public static void main(String[] args) throws IOException {

        Path root = Paths.get("pasta");
        Files.walkFileTree(root, new ListAllFiles());
    }
}