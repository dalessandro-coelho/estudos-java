package academy.devdojo.maratonajava.javacore.Oexception.rumtime.test;

public class RunTimeExceptionTest03 {
    public static void main(String[] args) {
        abreConexao2();
    }

    public static String abreConexao() {
        try {
            System.out.println("Abrindo arquivo");
            System.out.println("Escrevendo dados no arquivo");
            return "conexão aberta";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Fechando recurso liberado pelo Sistema Operacional");
        }
        return null;
    }
    public static String abreConexao2() {
        try {
            System.out.println("Abrindo arquivo");
            System.out.println("Escrevendo dados no arquivo");
            throw new RuntimeException();
        } finally {
            System.out.println("Fechando recurso liberado pelo Sistema Operacional");
        }
    }
}
