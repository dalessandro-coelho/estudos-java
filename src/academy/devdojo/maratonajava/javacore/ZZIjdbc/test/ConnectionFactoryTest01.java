package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.com.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Deen").build();
        ProducerRepository.save(producer);

        /*
        * Log4j2: É um sistema de Logs profissional.
        * Já que usar "System.out.println" acaba sendo peso, e não guarda
        * informações importantes como a data, a hora ou o nível do erro num ficheiro.
        * É possivel categorizar as mensagens usando "log":
        * */
//        log.info("info"); // INFO: Apenas avisando que algo aconteceu.
//        log.debug("debug"); // DEBUG: Registra informações detalhadas sobre a execução.
//        log.warn("warn"); // WARN: Indica situações inesperadas
//        log.error("error"); // ERROR: Indica problemas sérios que impedem a execução
//        log.trace("trace"); // TRACE: Nível mais detalhado de registro de eventos
    }
}
