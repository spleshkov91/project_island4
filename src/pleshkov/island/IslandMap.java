package pleshkov.island;

import lombok.Getter;
import pleshkov.entities.EntitiesFactory;
import pleshkov.entities.EntityType;
import pleshkov.entities.animals.Entity;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class IslandMap {
    private final EntitiesFactory entitiesFactory;
    private final int height;
    private final int widht;
    private final Location[][] locations;

    public IslandMap(int height, int widht) {
        this.height = height;
        this.widht = widht;
        this.entitiesFactory = new EntitiesFactory();
        this.locations = new Location[height][widht];
    }

    public void initialize() {
        for (int coordY = 0; coordY < height; coordY++) {
            for (int coordX = 0; coordX < widht; coordX++) {
                locations[coordY][coordX] = new Location(coordY, coordX);
            }
        }
    }

    public void fill(int maxEntityCount) {
        for (int coordY = 0; coordY < height; coordY++) {
            for (int coordX = 0; coordX < widht; coordX++) {
                for (int i = 0; i < maxEntityCount; i++) {
                    Entity entity = getRandomEntity();
                    var entityAsString = entity.getClass().getSimpleName();
                    var entityCountOnLocation = locations[coordY][coordX].getEntitiesCount()
                            .getOrDefault(entityAsString, 0);
                    if (entityCountOnLocation >= entity.getMaxOnCell()) {
                        continue;
                    }
                    locations[coordY][coordX].addEntity(entity);
                }
            }
        }
    }

    public void printLocation() {
        for (int coordY = 0; coordY < height; coordY++) {
            for (int coordX = 0; coordX < widht; coordX++) {
                Location location = locations[coordY][coordX];
                List<Entity> entities = location.getEntities();
                System.out.println(location.getEntitiesCount());
            }
        }
    }

    private Entity getRandomEntity() {
        var entityTypes = EntityType.values();
        var entityType = entityTypes[ThreadLocalRandom.current().nextInt(entityTypes.length)];
        return entitiesFactory.createEntity(entityType);
    }


}
