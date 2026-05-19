package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.com.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    public static void save(Producer producer) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer '{}' in the database, rows affected '{}'", producer.getName(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    // Segue a mesma estrutura anterior, entretando agora vai remover (por id).
    public static void delete(int id) {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id); //Comando para deletar por id
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}' from the database, rows affected '{}'", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }

    //Atualizando o Banco de Dados (por id), onde segue a mesma estrutura, trocando só o comando.
    public static void update(Producer producer) {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s ' WHERE (`id` = '%d');"
                .formatted(producer.getName(), producer.getId()); //Comando para atualizar por id
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Update producer '{}', rows affected '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    public static List<Producer> findAll() {
        log.info("Finding all Producers");
        return findByName("");
    }

    //Filtrando as pesquisas do banco de dados por nome.
    public static List<Producer> findByName(String name) {
        log.info("Finding Producer by name");
        String sql = "SELECT * FROM anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer", e);
        }
        return producers;
    }

    //Descobrindo propriedades de uma tabela.
    public static void showProducerMetaData() {
        log.info("Showing Producer Metadata");
        String sql = "SELECT * FROM anime_store.producer";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            //ResultSetMetaData: Permite obter informações estruturais e metadados de um ResultSet, ou seja, pode descobrir dinamicamente o número de colunas, nomes e tipos de dados.
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            log.info("Columns count '{}'", columnCount); //columnCount: Contagem de colunas.
            for (int i = 1; i <= columnCount; i++) { // No JDBC e no SQL a contagem das colunas começa em 1.
                log.info("Table name '{}'", rsMetaData.getTableName(i)); //getTableName: Nome da tabela.
                log.info("Column name '{}'", rsMetaData.getCatalogName(i)); //getCatalogName: Nome da coluna.
                log.info("Column size '{}'", rsMetaData.getColumnDisplaySize(i)); //getColumnDisplaySize: Tamanho da coluna.
                log.info("Column type '{}'", rsMetaData.getColumnTypeName(i)); //getColumnTypeName: Tipo de coluna.
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer", e);
        }
    }

    // Fazendo teste no Driver.
    public static void showDriveMetaData() {
        log.info("Showing Driver Metadata");
        try (Connection conn = ConnectionFactory.getConnection()){
            //DatabaseMetaData: Serve para perguntar diretamente ao driver se ele suporta determinados recursos avançados do JDBC antes de tentares usá-los e causar um erro no sistema.
             DatabaseMetaData dbMetaData = conn.getMetaData();

             //TYPE_FORWARD_ONLY: Determina que a leitura dos resultados de uma consulta ao banco de dados seja feita exclusivamente para a frente.
             if(dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Supports TYPE_FORWARD_ONLY");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }

             //TYPE_SCROLL_INSENSITIVE: Permite navegar para a frente, para trás, saltar para o final ou ir para uma linha específica.
             if(dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }

             //TYPE_SCROLL_SENSITIVE: Igual ao anterior, mas se outra pessoa alterar um dado no banco de dados enquanto tem ResultSet aberto, é possível conseguir ver a alteração em tempo real sem fazer um novo SELECT.
             if(dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports TYPE_SCROLL_SENSITIVE");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }
        } catch(SQLException e){
            log.error("Error while trying to find all producer", e);
        }
    }

    //Navegando de forma mais avançada no ResultSet
    public static void showTypeScrollWorking() {
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {

            log.info("Last row? '{}'", rs.last()); //.last(): Dá um salto direto para a última linha da tabela.
            log.info("Row number? '{}'", rs.getRow()); //getRow: Devolve o número da linha exata onde o cursor está posicionado naquele momento.
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("First row? '{}'", rs.first()); //.first(): Dá um salto direto para a primeira linha.
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("Row Absolute? '{}'", rs.absolute(2)); //.absolute(int row): Vai para uma linha específica.
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("Row relative? '{}'", rs.relative(-1)); //.relative(int rows): Se move a partir de onde está agora. Ex: Se está na linha 2 e fizer ".relative(-1)", vai voltar para a linha 1.
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("is last? '{}'", rs.isLast()); //.isLast(): Pergunta se está na última linha (Retorna true ou false).
            log.info("Row number '{}'", rs.getRow());

            log.info("is first? '{}'", rs.isFirst()); //.isFirst(): Pergunta se está na primeira linha.
            log.info("Row number '{}'", rs.getRow());

            log.info("Last row? '{}'", rs.last());
            log.info("----------------------------");
            //Para ir de baixo para cima.
            rs.next();
            log.info("After last row? '{}'", rs.isAfterLast());
            while (rs.previous()){
                log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer", e);
        }
    }

    //Encontra um nome e atualiza para Maiuscula diretamente pelo Java com ResultSet (Sem precisar escrever nenhuma linha de comando SQL UPDATE ou DELETE para isso).
    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        log.info("Finding Producer by name");
        String sql = "SELECT * FROM anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                //updateString é usado junto com updateRow
                rs.updateString("name", rs.getString("name").toUpperCase()); // Atualiza o ResultSet, pega a coluna name, pega o nome que tem nessa célula e deixa maiscula.
                rs.updateRow(); //Pega na alteração feita na memória e envia para o MySQL atualizar a linha.
                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer", e);
        }
        return producers;
    }
}
