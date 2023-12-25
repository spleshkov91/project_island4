package pleshkov.entities.animals.herbivore;

import lombok.Getter;
import lombok.Setter;
import pleshkov.entities.animals.Animal;

@Getter
@Setter
public class Deer extends Animal {
    public Deer() {
        super(300, 20, 4, 50);
    }
}
