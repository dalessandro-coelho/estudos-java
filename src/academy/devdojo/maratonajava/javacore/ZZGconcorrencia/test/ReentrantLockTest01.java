package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable{
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            System.out.printf("Thread %s entrou em uma sessão crítica%n", name);
            System.out.printf("%d Threads esperando na fila%n", lock.getQueueLength()); //getQueueLength(): Retorna uma estimativa do número de threads à espera do lock.
            System.out.printf("Thread %s vai esperar 2s%n", name);
            Thread.sleep(2000);
            System.out.printf("Thread %s finalizou a espera%n", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //Sempre colocar o unlock() dentro de um bloco finally para garantir que o recurso seja libertado independentemente do que aconteça.
        }
    }
}

public class ReentrantLockTest01 {
    public static void main(String[] args) {
        //ReentrantLock: Faz a mesma função do synchronized (controle de acesso), só que com mais controle manual,
        //com isso pode fazer coisas que o synchronized NÃO faz.

        ReentrantLock lock = new ReentrantLock(true);
        new Thread(new Worker("A", lock)).start();
        new Thread(new Worker("B", lock)).start();
        new Thread(new Worker("C", lock)).start();
        new Thread(new Worker("D", lock)).start();
        new Thread(new Worker("E", lock)).start();
        new Thread(new Worker("F", lock)).start();
        new Thread(new Worker("G", lock)).start();
    }
}