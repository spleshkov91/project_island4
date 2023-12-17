package pleshkov.entities;

import pleshkov.entities.animals.Entity;
import pleshkov.entities.animals.herbivore.Deer;
import pleshkov.entities.animals.herbivore.Horse;
import pleshkov.entities.animals.herbivore.Rabbit;
import pleshkov.entities.animals.herbivore.Sheep;
import pleshkov.entities.animals.predators.*;
import pleshkov.entities.plants.Plant;

public class EntitiesFactory {
    public Entity createEntity(EntityType entityType) {
        return switch (entityType) {
            case WOLF -> new Wolf();
            case SNAKE -> new Snake();
            case FOX -> new Fox();
            case DEER -> new Deer();
            case SHEEP -> new Sheep();
            case HORSE -> new Horse();
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case RABBIT -> new Rabbit();

            case PLANT -> new Plant();
        };
    }
}
