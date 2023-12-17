package pleshkov.entities.animals.predators;

import lombok.Getter;
import lombok.Setter;
import pleshkov.entities.animals.Animal;

@Getter
@Setter
public class Fox extends Animal {
    public Fox() {
        super(8, 30, 2, 2);
    }
}
