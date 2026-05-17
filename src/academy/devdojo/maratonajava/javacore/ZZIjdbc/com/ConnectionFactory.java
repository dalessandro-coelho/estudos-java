package academy.devdojo.maratonajava.javacore.ZZIjdbc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //java.sql = Connection, Statement, ResultSet, DriverManager
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store"; //URL de Conexão (Segue o padrão jdbc:mysql://[host]:[porta]/[nome_do_banco]).
        String username = "root"; //O utilizador do banco
        String password = "root"; //A senha definida na instalação ou no Docker

        return DriverManager.getConnection(url, username, password);
    }
}