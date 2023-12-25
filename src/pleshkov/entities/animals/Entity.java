package pleshkov.entities.animals;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entity {
    private double weight;
    private int maxOnCell;
    private int speed;
    private double foodForSaturation;

    public Entity(double weight, int maxOnCell, int speed, double foodForSaturation) {
        this.weight = weight;
        this.maxOnCell = maxOnCell;
        this.speed = speed;
        this.foodForSaturation = foodForSaturation;
    }
}
