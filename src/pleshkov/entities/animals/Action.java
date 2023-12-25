package pleshkov.entities.animals;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Action {
    MOVE(90),
    EAT(100), //100
    REPRODUCE(50), //50
    SLEEP(100); //100
    private final int actionChanceIndex;
}