package academy.devdojo.maratonajava.javacore.ZZthreads.test;

public class DeadLockTest01 {
    public static void main(String[] args) {

        //Deadlock ocorre quando duas ou mais threads ficam bloqueadas para sempre,
        //cada uma à espera de um recurso (Lock) que está a ser segurado pela outra.

        Object lock1 = new Object();
        Object lock2 = new Object();

        //Segura o Lock 1 e tenta aceder ao Lock 2.
        Runnable r1 = () -> {
            synchronized (lock1){
                System.out.println("Thread 1: Segurando lock 1");
                System.out.println("Thread 1: Esperando lock 2");
                synchronized (lock2){
                    System.out.println("Thread 1: Segurando lock 2");
                }
            }
        };

        //Segura o Lock 2 e tenta aceder ao Lock 1.
        Runnable r2 = () -> {
            synchronized (lock2){
                System.out.println("Thread 2: Segurando lock 2");
                System.out.println("Thread 2: Esperando lock 1");
                synchronized (lock1){
                    System.out.println("Thread 2: Segurando lock 1");
                }
            }
        };

        //A forma mais simples de evitar um deadlock é garantir que todas as threads adquiram os locks na mesma ordem.
//        Runnable r2 = () -> {
//            synchronized (lock1){
//                System.out.println("Thread 2: Segurando lock 2");
//                System.out.println("Thread 2: Esperando lock 1");
//                synchronized (lock2){
//                    System.out.println("Thread 2: Segurando lock 1");
//                }
//            }
//        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}