package pleshkov.entities.animals.herbivore;

import lombok.Getter;
import lombok.Setter;
import pleshkov.entities.animals.Animal;

@Getter
@Setter
public class Rabbit extends Animal {
    public Rabbit() {
        super(2, 150, 2, 0.45);
    }
}
