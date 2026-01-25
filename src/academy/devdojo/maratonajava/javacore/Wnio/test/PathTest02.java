package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        Path pastaPath = Paths.get("pasta2");

        // Criação de Diretorios (pasta, subpasta...)
        if (Files.notExists(pastaPath)) { // Esse "if" é para tratar a exceção.
            Path pastaDirectory = Files.createDirectory(pastaPath); // Cria apenas o diretório especificado pelo Path (um diretório), e se já existir lança uma exceção (caso não for tratada).
        }
        Path subPastaPath = Paths.get("pasta2/subpasta/subsubpasta");
        Path subPastaDirectories = Files.createDirectories(subPastaPath); // Cria o diretório de destino e todos os diretórios pais inexistentes necessários (pasta2/subpasta/subsubpasta), e não lança exceção.

        // Criação de Arquivo
        Path filePath = Paths.get(subPastaPath.toString(), "file.txt"); // Onde vai ser criado o arquivo (subPastaPath), e o nome do arquivo (file.txt).
        if (Files.notExists(filePath)) { // Esse "if" é para tratar a exceção.
            Path filePathCreated = Files.createFile(filePath); // Criação do arquivo, e se já existir lança uma exceção (caso não for tratada).
        }

        // Cópia de Arquivos
        Path source = filePath;
        // filePath.getParent() -> Pega a pasta onde esse arquivo está.
        // file_renamed.txt -> é o novo nome do arquivo.
        Path target = Paths.get(filePath.getParent().toString(), "file_renamed.txt"); // Está dizendo -> "Onde o arquivo copiado vai ficar e com que nome"
        // Files.copy:
        // source -> origem (de onde o arquivo vem)
        // target -> destino (para onde o arquivo vai)
        // REPLACE_EXISTING -> se já existir um arquivo com esse nome, substitui sem reclamar.
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}