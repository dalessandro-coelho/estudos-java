package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {

        // Criando Diretorio (Pasta).
        File fileDiretorio = new File("pasta"); // Retorna "false" se já existir.
        boolean isDiretorioCreated = fileDiretorio.mkdir();
        System.out.println("Pasta criada? "+isDiretorioCreated);

        // Criando arquivo dentro do Diretorio.
        //File fileArquivoDiretorio = new File(C:\Users\dales\IdeaProjects\maratona-java\pasta); -> Também é possível criar só colocando o caminho.
        File fileArquivoDiretorio = new File(fileDiretorio,"arquivo.txt"); // Com a variável "fileDiretorio", já está dando referência onde vai ser criada.
        boolean isFileCreated = fileArquivoDiretorio.createNewFile();
        System.out.println("arquivo.txt criado? "+isFileCreated);

        // Renomeando Arquivos.
        File fileRenamed = new File(fileDiretorio,"arquivo_renomeado.txt"); // Se quer especificar o arquivo de qual pasta vai ser renomeada, tem que trazer o nome da pasta.
        boolean isRenamed = fileArquivoDiretorio.renameTo(fileRenamed);
        System.out.println("arquivo.txt' renomeado? "+isRenamed);

        // Renomeando Diretorio (Semelhante a renomear arquivo).
        File diretorioRenamed = new File("pasta2");
        boolean isDiretorioRenomeado = fileDiretorio.renameTo(diretorioRenamed);
        System.out.println("Diretorio 'pasta' renomeado?"+isDiretorioRenomeado);

    }
}