package pleshkov.island.services;

import pleshkov.entities.animals.Animal;
import pleshkov.island.IslandMap;
import pleshkov.island.Location;
import pleshkov.simulation.SimulationSetting;

public class StepService {
    private SimulationSetting simulationSetting;
    private IslandMap islandMap = new IslandMap(simulationSetting.getHeight(),
            simulationSetting.getWidth());
    private Location[][] locations;

    public void stepDown(Animal animal, Location location) {
        if (location.getCoordY() < simulationSetting.getWidth() - 1) {
            locations[location.getCoordY() - 1][location.getCoordX()].addEntity(animal);
            location.removeEntity(animal);
        }
    }

    public void stepUp(Animal animal, Location location) {
        if (location.getCoordY() != 0) {
            locations[location.getCoordY() - 1][location.getCoordX()].addEntity(animal);
            location.removeEntity(animal);
        }
    }

    public void stepRight(Animal animal, Location location) {
        if (location.getCoordX() < simulationSetting.getHeight() - 1) {
            locations[location.getCoordY()][location.getCoordX() + 1].addEntity(animal);
            location.removeEntity(animal);
        }
    }

    public void stepLeft(Animal animal, Location location) {
        if (location.getCoordX() != 0) {
            locations[location.getCoordY()][location.getCoordX() - 1].addEntity(animal);
            location.removeEntity(animal);
        }
    }
}
