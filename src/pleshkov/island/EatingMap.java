package pleshkov.island;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class EatingMap {
    private final Map<String, Integer> percentOfEating = new HashMap<>();
}
