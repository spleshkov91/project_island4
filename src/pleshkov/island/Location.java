package pleshkov.island;

import lombok.Getter;
import pleshkov.entities.animals.Animal;
import pleshkov.entities.animals.Entity;
import pleshkov.entities.plants.Plant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Location {
    private final int coordY;
    private final int coordX;
    private final List<Entity> entities;
    private final Map<String, Integer> entitiesCount;

    public Location(int coordY, int coordX) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.entities = new ArrayList<>();
        this.entitiesCount = new HashMap<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
        addToStatistic(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
        removeToStatistic(entity);
    }

    public List<Animal> getAnimals() {
        return entities.stream()
                .filter(entity -> entity instanceof Animal)
                .map(entity -> (Animal) entity)
                .toList();
    }

    public List<Plant> getPlants() {
        return entities.stream()
                .filter(entity -> entity instanceof Plant)
                .map(entity -> (Plant) entity)
                .toList();
    }

    private void removeToStatistic(Entity entity) {
        var entityString = getEntityName(entity);
        entitiesCount.merge(entityString, 1, (oldValue, newValue) -> {
            int newCount = oldValue - 1;
            if (newCount <= 0) {
                return null;
            }
            return newCount;
        });
    }

    private void addToStatistic(Entity entity) {
        var entityAsString = getEntityName(entity);
        entitiesCount.merge(entityAsString, 1, (oldValue, newValue) -> oldValue + 1);
    }

    private String getEntityName(Entity entity) {
        return entity.getClass().getSimpleName();
    }

}
