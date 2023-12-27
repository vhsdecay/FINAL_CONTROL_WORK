package task_prgm.controller;

import task_prgm.model.AbstractAnimal;
import task_prgm.model.AnimalGenius;
import task_prgm.model.implement.*;
import task_prgm.storage.Storage;

import java.time.LocalDate;
import java.util.List;

/**
 * Отвечает за взаимодействие View и Model
 */
public class KennelAccounting {

    private Storage dbKennel;

    public KennelAccounting(Storage dbKennel) {
        this.dbKennel = dbKennel;
    }

    public List<AbstractAnimal> getAnimals() {
        return dbKennel.getAllAnimals();
    }

    public boolean createAnimal(String name, LocalDate birthDay, AnimalGenius animalGenius) {
        AbstractAnimal animal = switch (animalGenius) {
            case CAT -> new Cat(name, birthDay);
            case DOG -> new Dog(name, birthDay);
            case HAMSTER -> new Hamster(name, birthDay);
            case HORSE -> new Horse(name, birthDay);
            case CAMEL -> new Camel(name, birthDay);
            case DONKEY -> new Donkey(name, birthDay);
        };

        return dbKennel.addAnimal(animal);
    }

    public int removeAnimal(AbstractAnimal animal) {
        if (animal == null) return -1;
        return  dbKennel.removeAnimal(animal);
    }
}
