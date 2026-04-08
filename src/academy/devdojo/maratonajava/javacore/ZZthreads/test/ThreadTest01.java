package academy.devdojo.maratonajava.javacore.ZZthreads.test;

//Extensão da classe Thread: Não é o ideal pois consome a única herança que o Java permite.
class ThreadExample extends Thread{
    private final char c;

    public ThreadExample(char c){
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++){
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
        }
    }
}

//Implementação de Runnable (Recomendado): Isto separa a tarefa (o código) do trabalhador (a Thread)
class ThreadExampleRunnable implements Runnable{
    private final char c;

    public ThreadExampleRunnable(char c){
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++){
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
        }
    }
}

public class ThreadTest01 {
    public static void main(String[] args) {
        //Thread: É uma linha de execução independente dentro de um programa. Um único processo pode ter várias threads a trabalhar em simultâneo para dividir a carga de tarefas
        //Thread Daemom: O programa Java só termina quando todas as threads de utilizador forem finalizadas.
        //Thread User: São threads de serviço. O Java encerra o programa mesmo que elas ainda estejam a correr, desde que todas as User Threads tenham terminado.

//        ThreadExample t1 = new ThreadExample('A');
//        ThreadExample t2 = new ThreadExample('B');
//        ThreadExample t3 = new ThreadExample('C');
//        ThreadExample t4 = new ThreadExample('D');

        Thread t1 = new Thread (new ThreadExampleRunnable('A'));
        Thread t2 = new Thread (new ThreadExampleRunnable('B'));
        Thread t3 = new Thread (new ThreadExampleRunnable('C'));
        Thread t4 = new Thread (new ThreadExampleRunnable('D'));

        //Se chamar o metodo run() diretamente, o código será executado de forma sequencial pela thread principal (main), sem paralelismo.
//        t1.run();
//        t2.run();
//        t3.run();
//        t4.run();

        //Com o metodo start() o código corre verdadeiramente em paralelo.
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}