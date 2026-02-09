package academy.devdojo.maratonajava.javacore.Xserializacao.test;

import academy.devdojo.maratonajava.javacore.Xserializacao.dominio.Aluno;
import academy.devdojo.maratonajava.javacore.Xserializacao.dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializacaoTest01 {
    static void main(String[] args) {

        //Serialization -> Converte um objeto Java em bytes para armazenamento ou transmissão.

        Aluno aluno = new Aluno(1L,"Dalessandro Coelho", "123456789");
        Turma turma = new Turma("Maratona Java Virado no Jiraya em Breve Ricos");
        aluno.setTurma(turma);
        serializar(aluno);
        deserializar();
    }

    // Transformar Objetos em bytes.
    private static void serializar(Aluno aluno){
        Path path = Paths.get("pasta/aluno.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){
            oos.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Transformar bytes em Objetos.
    private static void deserializar(){
        Path path = Paths.get("pasta/aluno.ser");
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))){
            //É necessario um "casting".
            Aluno aluno = (Aluno) ois.readObject();
            System.out.println(aluno);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}