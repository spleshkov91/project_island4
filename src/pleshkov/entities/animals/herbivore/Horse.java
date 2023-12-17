package pleshkov.entities.animals.herbivore;

import lombok.Getter;
import lombok.Setter;
import pleshkov.entities.animals.Animal;


@Getter
@Setter
public class Horse extends Animal {
    public Horse() {
        super(400, 20, 4, 60);
    }
}
