package academy.devdojo.maratonajava.javacore.Minterface.dominio;

public class FileLoader implements DataLoader, DataRemover{
    @Override
    public void load() {
        System.out.println("Caregandos dados de um arquivo");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados de um arquivo");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checando permissões no arquivo");
    }

    public static void retriMaxDataSize(){
        System.out.println("Dentro do retrieveMaxDataSize na interface");
    }
}
