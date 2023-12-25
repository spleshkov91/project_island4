package pleshkov.entities.animals.predators;

import lombok.Getter;
import lombok.Setter;
import pleshkov.entities.animals.Animal;

@Getter
@Setter
public class Eagle extends Animal {
    public Eagle() {
        super(6, 20, 3, 1);
    }
}
