package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.com.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProducerRepository {
    public static void save(Producer producer) {
        // String sql = "INSERT INTO producer (name) VALUES ('Madhouse');"; // Inserindo o nome Madhouse
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName()); // Inserindo outro nome
        // Sempre que abre uma conexão (Connection) ou um mensageiro (Statement), precisas de fechá-los (Nesse caso usa "try-with-resources", que fecha tudo sozinho, mesmo que dê algum erro.).
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) { // Statement: Envia um comando SQL do Java para o MySQL. A conexão acontece usando a classe ConnectionFactory, que apartir dela gera o Statement.
            int rowsAffected = stmt.executeUpdate(sql); // executeUpdate: Usado para comandos que alteram o banco (inserir, apagar ou atualizar). Ele retorna um número inteiro dizendo quantas linhas foram afetadas.
            System.out.println(rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
