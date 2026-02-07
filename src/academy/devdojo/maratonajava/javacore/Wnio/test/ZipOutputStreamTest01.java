package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTest01 {
    public static void main(String[] args) {
        Path arquivoZip = Paths.get("pasta/arquivo.zip");
        Path arquivosParaZipar = Paths.get("pasta/subpasta1/subsubpasta1");
        zip(arquivoZip, arquivosParaZipar); // Mostra quais arquivos serão usados para a compactação (É bom olhar, para saber se são os arquivos certos).
    }

    private static void zip(Path arquivoZip, Path arquivoParaZipar) {

         /*ZipOutputStream -> Escreve dados em um fluxo de saída, compactando-os no formato ZIP.
           ✔️ Cria um arquivo .zip
           ✔️ Coloca arquivos dentro do .zip
           ✔️ Compacta os arquivos
           ❌ Não lê zip
           ❌ Não extrai zip
         */

        // Sempre usar "try", pois garante que tanto o "ZipOutputStream" quanto o "DirectoryStream" (ou a lista de arquivos) sejam fechados corretamente,
        try (ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
             DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivoParaZipar)) {
            for (Path file : directoryStream) { // Pega arquivo por arquivo.
                // Para zipar tem 3 Etapas
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString()); // 1 - ZipEntry -> Diz o que vai entrar no zip.
                zipStream.putNextEntry(zipEntry); // 2 - putNextEntry -> Prepara o "ZipOutputStream" para receber os dados da entrada especificada.
                Files.copy(file, zipStream); // 3 - copy -> Copia os dados para dentro do zip.
                zipStream.closeEntry(); // Após copiar os dados de um arquivo, utiliza-se "closeEntry()" para finalizar (Sempre fechar).
            }
            System.out.println("Arquivo criado com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}