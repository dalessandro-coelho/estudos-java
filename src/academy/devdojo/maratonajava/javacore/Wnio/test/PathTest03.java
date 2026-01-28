package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest03 {
    public static void main(String[] args) {
        /***
         * Relativo -> Não começa com "/" ou "C:/"("/home/user"(Linux), "C:/home/user"(Windows)),ele depende de onde está o programa para ser completo.
         * Absoluto -> É só o inverso do relativo, começa com "/" ou "C:/" e é completo.
         * resolve() -> "Junta" dois caminhos para criar um caminho completo.
         */

        Path dir = Paths.get("home/dale");
        Path arquivo = Paths.get("dev/arquivo.txt");
        Path resolve = dir.resolve(arquivo);
        System.out.println(resolve);

        Path absoluto = Paths.get("/home/dale");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("file.txt");

        // Se o segundo for relativo -> junta.
        // Se o segundo for absoluto -> ignora o primeiro.
        System.out.println("1 "+absoluto.resolve(relativo)); // Só vai juntar.
        System.out.println("2 "+absoluto.resolve(file)); // Só vai juntar.
        System.out.println("3 "+relativo.resolve(absoluto)); // Ignora o primeiro, e roda o segundo.
        System.out.println("4 "+relativo.resolve(file)); // Só vai juntar.
        System.out.println("5 "+file.resolve(absoluto)); // Ignora o primeiro, e roda o segundo.
        System.out.println("6 "+file.resolve(relativo)); // Só vai juntar.
    }
}