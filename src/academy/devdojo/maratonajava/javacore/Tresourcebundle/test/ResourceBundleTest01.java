package academy.devdojo.maratonajava.javacore.Tresourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("en", "US")); // Carrega as mensagens declaradas para serem usadas.
        boolean teste = bundle.containsKey("teste");
        System.out.println(teste); //Verifica se a chave existe.
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));
        System.out.println(bundle.getString("hi"));

        bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(bundle.getString("hello")); // Chama a chave declarada.
        System.out.println(bundle.getString("good.morning"));

        // Ordem que o java segue, caso não encontre o arquivo exato.
        //Locale("fr", "CA");
        //messages_fr_CA.properties -> Procura o arquivo com lingua e país (_fr_CA).
        //messages_fr.properties -> Procura apenas pela lingua (_fr).
        //messages_pt_BR.properties -> Procura pelo LOCALE padrão do sistema operacional.
        //messages_pt.properties -> Procura pela lingua do sistema.
        //messages.properties -> Procura pelo nome base, se não der certo lança uma exceção.

        System.out.println(bundle.getString("hi"));
    }
}