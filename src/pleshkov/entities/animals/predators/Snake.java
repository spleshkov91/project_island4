package pleshkov.entities.animals.predators;

import lombok.Getter;
import lombok.Setter;
import pleshkov.entities.animals.Animal;

@Getter
@Setter
public class Snake extends Animal {
    public Snake() {
        super(15, 30, 1, 3);
    }
}
