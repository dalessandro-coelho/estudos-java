package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonLazy {
    private static AircraftSingletonLazy INSTANCE;
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    private AircraftSingletonLazy(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }

    //Técnica Double-Checked Locking: Chama o getInstance() no exato milésimo de segundo em que o objeto ainda é nulo,
    // ambas podem passar pelo teste if (instance == null) e criar dois objetos diferentes.

    //Double-Checked Locking
    public static AircraftSingletonLazy getINSTANCE(){
        if (INSTANCE == null){ // Verifica se é nulo.
            synchronized (AircraftSingletonLazy.class){ // Se for, trava o acesso (sincroniza).
                if (INSTANCE == null){ // Verifica de novo se é nulo (para garantir que outra thread não criou enquanto esperava o cadeado abrir).
                    INSTANCE = new AircraftSingletonLazy("787-900"); //Cria o objeto.
                }
            }
        }
        return INSTANCE;
    }
}
