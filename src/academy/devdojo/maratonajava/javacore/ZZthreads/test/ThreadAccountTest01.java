package academy.devdojo.maratonajava.javacore.ZZthreads.test;

import academy.devdojo.maratonajava.javacore.ZZthreads.dominio.Account;

public class ThreadAccountTest01 implements Runnable {
    //O objeto usado como Lock deve ser, preferencialmente, definido como "final".
    private final Account account = new Account();

    public static void main(String[] args) {

        //Programação concorrente: a Race Condition (Condição de Corrida) -> O problema surge porque ambas as
        //threads estão compartilhando o mesmo objeto na memória, levando a resultados inconsistentes e imprevisíveis.
        //Mas lembrando que o erro pode não acontecer em todas as execuções.

        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
        Thread t1 = new Thread(threadAccountTest01, "Hestia");
        Thread t2 = new Thread(threadAccountTest01, "Bell Cranel");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("FODEO");
            }
        }
    }

    //synchronized na assinatura do metodo garante que o metodo inteiro seja executado de forma atômica.
    private /*synchronized*/ void withdrawal(int amount) {
        System.out.println(getTheadName() + "#### fora do synchronized");
        synchronized (account) { // Para não sincronizar o metodo todo, apenas um trecho especifico .
            System.out.println(getTheadName() + "**** dentro do synchronized");
            if (account.getBalance() >= amount) {
                System.out.println(getTheadName() + " está indo sacar dinheiro");
                account.withdrawal(amount);
                System.out.println(getTheadName() + " completou o saque, valor atual da conta " + account.getBalance());
            } else {
                System.out.println("Sem dinheiro para " + getTheadName() + "efetuar o saque " + account.getBalance());
            }
        }
    }

    private String getTheadName() {
        return Thread.currentThread().getName();
    }
}