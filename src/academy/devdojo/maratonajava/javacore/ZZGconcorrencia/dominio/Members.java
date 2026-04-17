package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {

    /*Só pode chamar "wait", "notify" ou "notifyAll" de dentro de um bloco ou metodo synchronized.
      Caso contrário, lançará uma IllegalMonitorStateException.
     */

    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean open = true;

    //Se está aberto algum email.
    public boolean isOpen(){
        return open;
    }

    //Retorna se tem algum email esperando para ser enviado.
    public int pendingEmails(){
        lock.lock();
        try {
            return emails.size();
        } finally {
            lock.unlock();
        }
    }

    //Adiciona os emails.
    public void addMemberEmail(String email){
        lock.lock();
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adicionou email na lista");
            this.emails.add(email);
            condition.signalAll(); //Acorda todas as threads que aguardam por esta condição.
        } finally {
            lock.lock();
        }
    }

    //Pega os emails.
    public String retrieveEmail() throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");
        lock.lock();
        try {
            while (this.emails.size() == 0){
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + " Não tem email disponível na lista, entrando em modo de espera");
                condition.await(); //Faz a thread esperar pela condição.
            }
            return this.emails.poll();
        } finally {
            lock.lock();
        }
    }

    //Fechando a lista.
    public void close(){
        open = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Notificando todo mundo que não estamos mais pegando email");
            condition.signalAll(); //Acorda todas as threads que aguardam por esta condição.
        } finally {
            lock.unlock();
        }
    }
}
