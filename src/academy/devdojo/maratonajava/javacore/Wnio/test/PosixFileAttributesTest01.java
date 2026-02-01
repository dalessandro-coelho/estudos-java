package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        //Se estiver no Windows, as APIs POSIX (PosixFileAttributes e PosixFileAttributeView) NÃO funcionam.

        //PosixFileAttributes -> Tem a mesma finalidade que "BasicFileAttributes", porém fornece atributos adicionais específicos de sistemas POSIX (Linux/macOS), como dono, grupo e permissões.

        Path path = Paths.get("/home/dale/dev/file.txt");
        PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println(posixFileAttributes);

        //PosixFileAttributeView -> Estende o "BasicFileAttributeView", permitindo a modificação de atributos específicos de sistemas POSIX (Linux/macOS), além dos tempos (datas) do arquivo.

        //PosixFilePermissions traduz permissões POSIX, e fromString transforma a representação textual de 9 caracteres (rwx) em permissões utilizáveis pelo Java.
        PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString("rw-rw-rw-");
        /**
         * Os símbolos "r", "w" e "x" representam permissões de leitura, escrita e execução, respectivamente,
         * enquanto "-" indica a ausência da permissão no modelo POSIX.
         */
        fileAttributeView.setPermissions(posixFilePermissions);
        System.out.println(fileAttributeView.readAttributes().permissions());
    }
}