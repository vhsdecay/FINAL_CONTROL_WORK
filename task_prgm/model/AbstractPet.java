package task_prgm.model;

import java.time.LocalDate;

/**
 * Описывает абстрактное домашнее животное
 */
public abstract class AbstractPet extends AbstractAnimal {
    public AbstractPet(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
