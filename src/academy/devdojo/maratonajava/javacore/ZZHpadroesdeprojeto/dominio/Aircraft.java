package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public final class Aircraft {
    private final Set<String> avaStringSets = new HashSet<>();
    private final String name;

    public Aircraft(String name) {
        this.name = name;
    }

    {
        avaStringSets.add("1A");
        avaStringSets.add("1B");
    }

    public boolean bookSeat(String seat){
        return avaStringSets.remove(seat);
    }
}