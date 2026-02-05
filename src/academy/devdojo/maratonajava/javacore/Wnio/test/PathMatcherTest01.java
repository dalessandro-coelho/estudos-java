package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest01 {
    public static void main(String[] args) {

        // PathMatcher -> Serve para verificar se um "Path" corresponde ao padrão definido depois de "glob:".

        Path path1 = Paths.get("pasta/subpasta/file.bkp");
        Path path2 = Paths.get("pasta/subpasta/file.txt");
        Path path3 = Paths.get("pasta/subpasta/file.java");

        matches(path1, "glob:*.bkp"); // Qualquer arquivo que termine com ".bkp", mas não considera diretorios(não entra).
        matches(path1, "glob:**/*.bkp"); // Qualquer arquivo que termine com ".bkp", em qualquer pasta.
        matches(path1, "glob:**/*.{bkp,txt,java}"); // O arquivo ".bkp" OU ".txt" OU ".java" em qualquer pasta.
        matches(path2, "glob:**/*.{bkp,txt,java}");
        matches(path3, "glob:**/*.{bkp,txt,java}");
        matches(path1, "glob:**/*.???"); // Esse arquivo tem extensão com exatamente 3 caracteres(cada interrogação equivale a um caractere), em qualquer pasta.
        matches(path2, "glob:**/*.???");
        matches(path3, "glob:**/*.???");
        matches(path3, "glob:**/file.????"); // Esse arquivo "file" e 4 caracteres depois dele, em qualquer pasta.
    }

    private static void matches(Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}