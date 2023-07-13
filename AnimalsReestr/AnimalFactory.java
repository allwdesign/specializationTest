package AnimalsReestr;

public class AnimalFactory {
    
    public static Animal getAnimal(String animalClass, String name, String commands, String birthday, String gender,
            String size, String ownerFio) {
        if ("Horse".equalsIgnoreCase(animalClass)) {
            return new Horse(name, commands, birthday, gender, size, ownerFio);
        } else if ("Camel".equalsIgnoreCase(animalClass)) {
            return new Camel(name, commands, birthday, gender, size, ownerFio);
        } else if ("Donkey".equalsIgnoreCase(animalClass)) {
            return new Donkey(name, commands, birthday, gender, size, ownerFio);
        } else if ("Cat".equalsIgnoreCase(animalClass)) {
            return new Cat(name, commands, birthday, gender, size, ownerFio);
        } else if ("Dog".equalsIgnoreCase(animalClass)){
            return new Dog(name, commands, birthday, gender, size, ownerFio);
        } else if ("Hamster".equalsIgnoreCase(animalClass)){
            return new Hamster(name, commands, birthday, gender, size, ownerFio);
        }
        return null;
    }

}
