package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// Sempre criar uma classe que estenda "SimpleFileVisitor<Path>".
class ListAllFile extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE; // Tem que indicar se o Java deve continuar a busca (CONTINUE), parar (TERMINATE) ou pular algo.
    }

//    Para encontrar algo especifico do diretório. Nesse caso é todo arquivo que termina em ".java".
//    @Override
//    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//        if (file.getFileName().toString().endsWith(".java")) // endsWith() -> Verifica se uma string termina com um determinado sufixo.
//            System.out.println(file.getFileName());
//        }
//        return FileVisitResult.CONTINUE;
//    }
}

public class SimpleFileVisitorTest01 {
    public static void main(String[] args) throws IOException {

        //SimpleFileVisitor -> Ele basicamente vai mostrar tudo que tiver no diretório, como pastas, subpastas e arquivos.

        Path root = Paths.get(".");
        Files.walkFileTree(root, new ListAllFile()); // Files.walkFileTree() -> Recebe o caminho inicial e um objeto que define o que fazer em cada arquivo encontrado.
    }
}