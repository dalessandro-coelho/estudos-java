package academy.devdojo.maratonajava.javacore.ZZFthreads.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {

    /*Só pode chamar "wait", "notify" ou "notifyAll" de dentro de um bloco ou metodo synchronized.
      Caso contrário, lançará uma IllegalMonitorStateException.
     */

    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;

    //Se está aberto algum email.
    public boolean isOpen(){
        return open;
    }

    //Retorna se tem algum email esperando para ser enviado.
    public int pendingEmails(){
        synchronized (emails){
            return emails.size();
        }
    }

    //Adiciona os emails.
    public void addMemberEmail(String email){
        synchronized (this.emails){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adicionou email na lista");
            this.emails.add(email);
            this.emails.notifyAll(); //notifyAll(): Acorda todas as Theread que estão esperando pelo lock do objeto.
        }
    }

    //Pega os emails.
    public String retrieveEmail() throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");
        synchronized (this.emails){
            while (this.emails.size() == 0){
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + " Não tem email disponível na lista, entrando em modo de espera");
                this.emails.wait(); //wait(): Faz a thread atual liberar o Lock do objeto e entrar em estado de espera até que outra thread a notifique.
            }
        }
        return this.emails.poll();
    }

    //Fechando a lista.
    public void close(){
        open = false;
        synchronized (this.emails){
            System.out.println(Thread.currentThread().getName() + " Notificando todo mundo que não estamos mais pegando email");
        }
    }
}
