package pleshkov.simulation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import pleshkov.island.EatingMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class SimulationSetting {
    private int height; // высота
    private int width; // ширина
    private int maxEntityCount; // количество сущностей в локации
    private int cycles; // количество циклов программы

    public Map<String, Integer> getPercentOfEating() {
        Map<String, Integer> percentOfEating = new HashMap<>();
        try {
            ObjectMapper mapper = new YAMLMapper();
            EatingMap prop = mapper.readValue(new FileReader("pleshkov/resources/" +
                    "eating-chance-data.yaml"), EatingMap.class);
            percentOfEating = prop.getPercentOfEating();
        } catch (IOException e) {
            System.out.println("Ошибка в файле или файл не найден");
        }
        return percentOfEating;
    }
}


