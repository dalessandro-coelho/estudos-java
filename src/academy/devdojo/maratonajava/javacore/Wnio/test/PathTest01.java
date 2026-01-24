package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
        //Path -> O caminho até algo no sistema (Ela não cria arquivo/diretorio, não lê, não escreve, só aponta onde o arquivo/diretorio está).
        //Paths -> Ela existe basicamente pra criar objetos Path.

        Path p1 = Paths.get("C:\\Users\\dales\\IdeaProjects\\maratona-java\\file.txt");

        // NÃO precisa ficar usando "\\", pois o Java se encarrega de colocar as barras corretamente de acordo com o sistema operacional.
        Path p2 = Paths.get("C:\\Users\\dales\\IdeaProjects\\maratona-java", "file.txt");
        Path p3 = Paths.get("C:", "Users\\dales\\IdeaProjects\\maratona-java", "file.txt");
        Path p4 = Paths.get("C:", "Users", "dales", "IdeaProjects", "maratona-java", "file.txt");
        System.out.println(p1.getFileName());
        System.out.println(p2.getFileName());
        System.out.println(p3.getFileName());
        System.out.println(p4.getFileName());
    }
}
