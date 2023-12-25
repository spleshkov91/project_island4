package pleshkov.entities.animals;

import java.util.concurrent.ThreadLocalRandom;

public class Animal extends Entity {
    private static final int MAX_CHANCE = 100;


    public Animal(double weight, int maxOnCell, int speed, double foodForSaturation) {
        super(weight, maxOnCell, speed, foodForSaturation);
    }

    public Action chooseAction() {
        var action = Action.values()[ThreadLocalRandom.current().nextInt(Action.values()
                .length)];
        var isActiveAction = ThreadLocalRandom.current().nextInt(MAX_CHANCE)
                < action.getActionChanceIndex();
        if (isActiveAction) {
            return action;
        } else {
            return Action.SLEEP;
        }
    }

    public Direction chooseDirection() {
        return Direction.values()[ThreadLocalRandom.current()
                .nextInt(Direction.values().length)];
    }

    public Entity reproduce() {
        return new Entity(this.getWeight(), this.getMaxOnCell(), this.
                getSpeed(), this.getFoodForSaturation());
    }

    public void eat(Animal food) {
        setWeight(getWeight() - food.getWeight());
    }

}
