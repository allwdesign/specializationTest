package AnimalsReestr;

import java.util.UUID;

public class AnimalFactory {

    public static Animal getAnimal(String uuid, String animalClass, String name, String commands, String birthday,
            String gender,
            String size, String ownerFio) {
        if ("Horse".equalsIgnoreCase(animalClass)) {
            return new Horse(UUID.fromString(uuid), name, commands, birthday, gender, size, ownerFio);
        } else if ("Camel".equalsIgnoreCase(animalClass)) {
            return new Camel(UUID.fromString(uuid), name, commands, birthday, gender, size, ownerFio);
        } else if ("Donkey".equalsIgnoreCase(animalClass)) {
            return new Donkey(UUID.fromString(uuid), name, commands, birthday, gender, size, ownerFio);
            
        } else if ("Cat".equalsIgnoreCase(animalClass)) {
            return new Cat(UUID.fromString(uuid), name, commands, birthday, gender, size, ownerFio);
        } else if ("Dog".equalsIgnoreCase(animalClass)) {
            return new Dog(UUID.fromString(uuid), name, commands, birthday, gender, size, ownerFio);
        } else if ("Hamster".equalsIgnoreCase(animalClass)) {
            return new Hamster(UUID.fromString(uuid), name, commands, birthday, gender, size, ownerFio);
        }
        return null;
    }

}
