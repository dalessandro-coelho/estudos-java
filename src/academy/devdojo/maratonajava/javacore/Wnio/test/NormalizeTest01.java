package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeTest01 {
    public static void main(String[] args) {
        //normalize() -> Mostra o caminho direto, removendo voltas inúteis no meio como "." e "..".
        String diretorioProjeto = "home/dale/dev";
        String arquivoTxt = "../../arquivo.txt";
        Path path1 = Paths.get(diretorioProjeto, arquivoTxt);
        System.out.println(path1);
        System.out.println(path1.normalize());

        Path path2 = Paths.get("/home/./dale/./dev/");
        System.out.println(path2);
        System.out.println(path2.normalize());
    }
}