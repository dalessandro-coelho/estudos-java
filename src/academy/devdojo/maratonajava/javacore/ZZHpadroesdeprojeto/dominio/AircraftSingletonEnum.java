package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

// Usar "Enums" é mais limpo e mais seguro para garantir objeto único.
public enum AircraftSingletonEnum {
    INSTANCE; // Instância única.
    private final Set<String> avaStringSet;

    // Construtor de enum é privado por padrão.
    AircraftSingletonEnum(){
        this.avaStringSet = new HashSet<>();
        this.avaStringSet.add("1A");
        this.avaStringSet.add("1B");
    }

    public boolean bookSeat(String seat){
        return avaStringSet.remove(seat);
    }
}