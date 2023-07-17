import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

import AnimalsReestr.Animal;
import AnimalsReestr.AnimalFactory;

public class Model {
    private static ArrayList<Animal> animals = new ArrayList<>();
    private final static String filename = "reestr.txt";

    protected void add(Animal animal) {
        animals.add(animal);
    }

    protected int searchIndexOfAnimal(String[] data) throws IllegalArgumentException, NotAddedAnimalsException {
        String uuidStr = data[0];
        Boolean itemFound = false;
        int index = 0;

        if (animals.isEmpty()) {
            throw new NotAddedAnimalsException();
        }

        for (int i = 0; i < animals.size(); i++) {

            Animal animal = animals.get(i);
            if (animal.getUuid().toString().equals(uuidStr)) {
                index = i;
                itemFound = true;
            }
        }
        if (!itemFound) {
            throw new IllegalArgumentException("There is no animal with such parameters");
        }
        return index;
    }

    protected void update(Animal animal, String newCommands) {
        String commands = "";

        // Animal animal = animals.get(idx);

        commands = animal.getCommands();
        // Добавить данные новые команды
        commands += " " + newCommands;
        // Сохранить в хранилище
        animal.setCommands(commands);
        // Сохранить file
        // animals.add(animal);
    }

    protected Animal getAnimal(int idx) {
        return animals.get(idx);
    }

    protected ArrayList<Animal> getAnimals() {
        return animals;
    }

    protected void saveToFile() throws NonExistedFileException {
        /* Writing a data to the file */
        try (FileWriter fileWriter = new FileWriter(new File(filename))) {

            for (Animal animal : animals) {
                // Adds data to a file
                //fileWriter.append(animal.toString() + "\n");
                fileWriter.write(animal.toString() + "\n");                
            }
            fileWriter.flush();
            System.out.println("***************************************************************");
            System.out.println("Your data written to the file");

        } catch (IOException e) {
            // Prints an exception message to the console
            throw new NonExistedFileException();
        }
    }

    // try with resorces
    protected void loadDataFromFile() throws NonExistedFileException, NullPointerException {
        /* Load the data from the .txt file */
        final String COLONREGEX = ":";
            
        try (Scanner scanner = new Scanner(new File(filename))) {
            
            while (scanner.hasNext()) {
                // process each line
                String line = scanner.nextLine();
                
                // Splitting a string on a colon
                Pattern spacePattern = Pattern.compile(COLONREGEX);
                String[] data = spacePattern.split(line);
                               
                Animal animal = AnimalFactory.getAnimal(data[0], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                add(animal);
            }
        } catch (IOException e) {
            throw new NonExistedFileException();
        }
    }

}
