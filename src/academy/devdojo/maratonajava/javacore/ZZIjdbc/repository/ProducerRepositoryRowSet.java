package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.com.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {
    public static List<Producer> findByNameJdbcRowSet(String name) {
        //JdbcRowSet é um ResultSet “melhorado”, mais fácil de usar e com suporte a eventos e atualização automática, ou seja,
        // ResultSet normal, precisa gerenciar conexão, é um código mais manual e menos flexível. Enquanto o JdbcRowSet,
        // resolve isso encapsulando Connection, Statement e ResultSet.

        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
            //Passa o comando SQL e os parâmetros (igual ao PreparedStatement)
            jrs.setCommand(sql);
            jrs.setString(1, String.format("%%%s%%", name));

            //Executa a query
            jrs.execute();

            //Percorre os dados exatamente igual a um ResultSet normal
            while (jrs.next()) {
                Producer producer  = Producer.builder()
                        .id(jrs.getInt("id"))
                        .name(jrs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producers;
    }
}
