package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.com.ConnectionFactory;

public class ConnectionFactoryTest {
    public static void main(String[] args) {
        //Se o código rodar sem lançar exceções, a conexão foi estabelecida com sucesso do Java ao MySQL.
        ConnectionFactory.getConnection();
    }
}
