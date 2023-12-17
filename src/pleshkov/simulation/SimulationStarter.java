package pleshkov.simulation;

import pleshkov.entities.animals.Action;
import pleshkov.entities.animals.Animal;
import pleshkov.entities.animals.Direction;
import pleshkov.island.IslandMap;
import pleshkov.island.Location;
import pleshkov.island.services.StepService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


public class SimulationStarter {
    private static final int CHANCE_TO_REPRODUCE = 50;
    public SimulationSetting simulationSetting = new SimulationSetting(20, 100,
            100, 50);
    public IslandMap islandMap = new IslandMap(simulationSetting.getHeight(), simulationSetting
            .getWidth());
    public int cycles = simulationSetting.getCycles();

    public Map<String, Integer> percentOfEating = simulationSetting.getPercentOfEating();
    public StepService stepService = new StepService();


    public void start() {
        userDialog();
        islandMap.initialize();
        islandMap.fill(simulationSetting.getMaxEntityCount());
        islandMap.printLocation();
        System.out.println("---------------------------------------------");

        while (cycles > 0) {
            for (int coordY = 0; coordY < islandMap.getHeight(); coordY++) {
                for (int coordX = 0; coordX < islandMap.getWidht(); coordX++) {
                    Location location = islandMap.getLocations()[coordY][coordX];
                    List<Animal> animals = new ArrayList<>(location.getAnimals());
                    for (Animal animal : animals) {
                        Action action = animal.chooseAction();
                        switch (action) {
                            case EAT -> doEat(animals, animal, location);
                            case MOVE -> doMove(animal, location);
                            case REPRODUCE -> doReproduce(coordY, coordX, animal);
                        }
                    }
                }
            }
            cycles--;
            islandMap.printLocation();
            System.out.println("---------------------------------------------");
        }

    }

    private void doReproduce(int coordY, int coordX, Animal animal) {
        int sumEtityMaxOnCell = Integer.parseInt(islandMap.getLocations()[coordY][coordX].
                getEntitiesCount().getClass().
                getSimpleName());
        if (sumEtityMaxOnCell > 2 && getRandomReproduce()) {
            islandMap.getLocations()[coordY][coordX].addEntity(animal.reproduce());
        }
    }

    private boolean getRandomReproduce() {
        int MAX_CHANCE = 100;
        return ThreadLocalRandom.current().nextInt(MAX_CHANCE) < CHANCE_TO_REPRODUCE;
    }

    private void doMove(Animal animal, Location location) {
        Direction[] directions = Direction.values();
        for (Direction direction : directions) {
            switch (direction) {
                case UP -> stepService.stepUp(animal, location);
                case DOWN -> stepService.stepDown(animal, location);
                case LEFT -> stepService.stepLeft(animal, location);
                case RIGHT -> stepService.stepRight(animal, location);
            }
        }

    }

    private void doEat(List<Animal> animals, Animal animal, Location location) {
        if (animal.getFoodForSaturation() > 0) {
            Animal food = animals.get(ThreadLocalRandom.current().nextInt(animals.size()));
            animal.eat(food);
            location.removeEntity(food);
        }
    }

    private void userDialog() {
        System.out.println("Start of the programm");
        System.out.println("Height = " + simulationSetting.getHeight());
        System.out.println("Width = " + simulationSetting.getWidth());
        System.out.println("The numbers of cycles = " + cycles);
        System.out.println();
    }

}
