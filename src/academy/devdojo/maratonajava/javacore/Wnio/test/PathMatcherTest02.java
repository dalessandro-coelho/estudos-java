package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* Exercício para percorrer todo o projeto e encontrar apenas os arquivos que atendam a dois critérios específicos:
 * 1 - Conter a palavra "Test" no nome.
 * 2 - Ter a extensão ".java" ou ".class".
 */

class FindAllTestJavaOrClass extends SimpleFileVisitor<Path> {
    // **/* -> Indica que a busca deve ser em todas as pastas e subpastas.
    // {Test*} -> Busca arquivos que comecem ou contenham "Test".
    // .{java,class} -> Utiliza o agrupamento para aceitar qualquer uma das duas extensões.
    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Test*}.{java, class}");

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (matcher.matches(file)){
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}

public class PathMatcherTest02 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get(".");
        Files.walkFileTree(root, new FindAllTestJavaOrClass());
    }
}