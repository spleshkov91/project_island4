package pleshkov.entities.animals.predators;

import lombok.Getter;
import lombok.Setter;
import pleshkov.entities.animals.Animal;

@Getter
@Setter
public class Bear extends Animal {
    public Bear() {
        super(500, 5, 2, 80);
    }
}
