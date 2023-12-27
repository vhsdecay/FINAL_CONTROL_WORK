package task_prgm.model.implement;

import task_prgm.model.AbstractPackAnimal;
import task_prgm.model.AnimalGenius;

import java.time.LocalDate;

public class Horse extends AbstractPackAnimal {
    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalGenius.HORSE);
    }
}
