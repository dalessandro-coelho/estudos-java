package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.com.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducerRepositoryRowSet {
    public static List<Producer> findByNameJdbcRowSet(String name) {
        //JdbcRowSet é um ResultSet “melhorado”, mais fácil de usar e com suporte a eventos e atualização automática, ou seja,
        // ResultSet normal, precisa gerenciar conexão, é um código mais manual e menos flexível. Enquanto o JdbcRowSet,
        // resolve isso encapsulando Connection, Statement e ResultSet.

        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());

            //Passa o comando SQL e os parâmetros (igual ao PreparedStatement)
            jrs.setCommand(sql);
            jrs.setString(1, String.format("%%%s%%", name));

            //Executa a query
            jrs.execute();

            //Percorre os dados exatamente igual a um ResultSet normal
            while (jrs.next()) {
                Producer producer = Producer.builder()
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

//    public static void updateJdbcRowSet(Producer producer) {
//        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
//        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
//            jrs.setCommand(sql);
//            jrs.setString(1, producer.getName());
//            jrs.setInt(2, producer.getId());
//            jrs.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void updateJdbcRowSet(Producer producer) {
        String sql = "SELECT * FROM anime_store.producer WHERE (`id` = ?);";
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("name", producer.getName());
            jrs.updateRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCachedRowSet(Producer producer) {
        //CachedRowSet: Copia os dados do banco para memória e depois fecha a conexão.
        // Faz mudanças localmente (as alterações acontecem só na memória do programa, ainda NÃO foram para o banco) e depois sincroniza.
        // 1. busca dados
        // 2. copia tudo pra memória
        // 3. fecha conexão

        String sql = "SELECT * FROM producer WHERE (`id` = ?);";
        try (CachedRowSet crs = ConnectionFactory.getCachedRowSet();
             Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);
            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(connection); // conecta - pega dados - salva em memória - desconecta
            if (!crs.next()) return;
            crs.updateString("name", producer.getName());
            crs.updateRow();
            TimeUnit.SECONDS.sleep(10);
            crs.acceptChanges(); //Para salvar no banco.
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
