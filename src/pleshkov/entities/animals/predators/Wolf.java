package pleshkov.entities.animals.predators;

import lombok.Getter;
import lombok.Setter;
import pleshkov.entities.animals.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Wolf extends Animal {
    public Wolf() {
        super(50, 30, 3, 8);
    }

}
