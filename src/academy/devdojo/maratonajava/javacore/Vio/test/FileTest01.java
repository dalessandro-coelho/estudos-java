package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class FileTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt"); // Não cria um arquivo automaticamente ao ser instanciada, somente uma referência.
        try {
            boolean isCreated = file.createNewFile(); // Cria um arquivo fisicamente(caso não tenha outro),retornando um booleano e lançando uma IOException que precisa ser tratada.
            System.out.println("created: "+isCreated);
            System.out.println("path: "+file.getPath()); // Retorna o caminho fornecido na criação.
            System.out.println("path absolute: "+file.getAbsolutePath()); // Retorna o caminho completo desde a raiz do sistema.
            System.out.println("is directory: "+file.isDirectory()); // Verifica se é uma pasta.
            System.out.println("is file: "+file.isFile()); // Verifica se é um arquivo.
            System.out.println("is hidden: "+file.isHidden()); // Verifica se o arquivo está marcado como oculto.
            System.out.println("last modified: "+file.lastModified()); // Verifica quando foi modificado, mas retorna em "Long".
            System.out.println("last modified: "+new Date(file.lastModified())); // Verifica quando foi modificada, deixando mais facil compreender com as Datas.
            System.out.println("last modified: "+ Instant.ofEpochMilli(file.lastModified())); // Verifica quando foi modificada, juntamente com Zulu time.
            System.out.println("last modified: "+ Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault())); // Verifica quando foi modificada, juntamente com Zoneld.
            boolean exists = file.exists(); // Verifica se o arquivo ou diretorio já existe.
            if (exists){
                System.out.println("Deleted: "+file.delete()); // Remove o arquivo (Mas é bom sempre verificar se ele existe antes de deletar).
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
