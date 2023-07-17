import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import AnimalsReestr.Animal;
import AnimalsReestr.AnimalFactory;

public class Controller {

    /*
     * This is the Controller class.
     * 
     * Accepts user input commands and delegates the presentation of the data
     * to the view, and the handling of the data to the model.
     */
    private final String[] COMMANDS = new String[] { "add", "comm", "train", "list", "exit" };
    private final String[] NEEDANIMALS = new String[] { "comm", "train", "list" };
    private final String[] NEEDID = new String[] { "comm", "train" };
    String[] validData = new String[6];
    String[] loadedData = new String[9];

    private static View consoleView = new View();
    private static Model model = new Model();
    private Validator validator = new Validator();

    protected void run() {
        /* Run interaction with user */

        // Getting data from file
        try {
            model.loadDataFromFile();
            System.out.println("Animals: ");
            for (Animal an : model.getAnimals()) {
                System.out.println(an);
            }
        } catch (NonExistedFileException e) {
            System.out.println("Haven't added any animals yet. You can add an animal");
        } catch (NullPointerException e) {
            System.out.println("Failed to load data");
        }

        // menu
        consoleView.view();
        while (true) {
            try {
                String command = consoleView.getCommandView();

                // Validate entered data(command)
                if (Arrays.asList(COMMANDS).contains(command)) {
                    // execute command
                    executeCommand(command);
                } else {
                    throw new IllegalArgumentException("Invalid command");
                }
            } catch (NotAddedAnimalsException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    private void executeCommand(String command) throws NotAddedAnimalsException {
        // Animal animal;

        int choiceNum;
        String animalClass = "";
        String additionalCommands = "";

        String[] data = new String[3];

        if (Arrays.asList(NEEDANIMALS).contains(command)) {
            if (model.getAnimals().isEmpty()) {
                throw new NotAddedAnimalsException();
            }
        }

        if (Arrays.asList(NEEDID).contains(command)) {
            
            String rawUuid = consoleView.getAnimalUuidView();
            // Get animal name
            String name = consoleView.getAnimalNameView();
            // Validate name
            validator.validateAnimalName(name.trim());
            data[0] = rawUuid;
            data[1] = name;
            data[2] = animalClass;

            
        }

        switch (command) {
            case "exit":
                // Terminate JVM
                if (model.getAnimals().isEmpty()) {
                    System.exit(0);
                } else {
                    try {
                        model.saveToFile();
                        System.exit(0);
                    } catch (NonExistedFileException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case "list":
                // List of animals
                consoleView.animalsView(model.getAnimals());
                break;
            case "add":
                try {
                    String choice = consoleView.choiceOfAnimalTypeView();
                    choiceNum = Integer.parseInt(choice);
                    animalClass = checkAnimalClass(choiceNum);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid type of animal");
                }
                // Need params name, birthday, commands etc.
                String rawData = consoleView.getParamsView();
                try {
                    validData = validator.verifyData(rawData.trim());

                    createAnimal(animalClass, validData);
                    consoleView.successfullyAddAnimalView();
                    model.saveToFile();

                } catch (WrongAmountOfDataException e) {
                    System.out.println("You entered less or more data than required!");
                } catch (NotClearDataException e) {
                    System.out.println("The entered data was incorrect. Try again.\n");
                } catch (NonExistedFileException e) {
                    System.out.println(e.getMessage());
                } catch (NullPointerException e){
                    System.out.println("Failed to create registry entry");
                }
                break;
            case "train":
                Animal animal = model.getAnimal(model.searchIndexOfAnimal(data));
                // search animal
               
                // Learning new commands
                additionalCommands = consoleView.getAdditionalCommandsView().trim();
                validator.validateAdditionalCommands(additionalCommands);
                model.update(animal, additionalCommands);
                consoleView.successfullyTrainingAnimalView(animal.getName(), animal.getCommands());
                break;
            case "comm":
                animal = model.getAnimal(model.searchIndexOfAnimal(data));
                
                // Get commands list
                consoleView.listOfCommandsView(animal.getName(), animal.getCommands());
                break;      

            case "_":
                throw new IllegalArgumentException("Invalid command");
        }

    }

    private String checkAnimalClass(int animalChoice) throws NullPointerException {
        String animalString;
        switch (animalChoice) {
            case 1:
                animalString = "Horse";
                break;
            case 2:
                animalString = "Camel";
                break;
            case 3:
                animalString = "Donkey";
                break;
            case 4:
                animalString = "Cat";
                break;
            case 5:
                animalString = "Dog";
                break;
            case 6:
                animalString = "Hamster";
                break;
            default:
                throw new IllegalArgumentException("Invalid class of animal");
        }
        return animalString;
    }

    private void createAnimal(String animalClass, String[] data) {
        UUID uuid = UUID.randomUUID();
        System.out.println("DATA: " + animalClass + uuid.toString() + data[0] + data[1] + data[2] + data[3] + data[4] + data[5]);
        Animal animal = AnimalFactory.getAnimal(uuid.toString(), animalClass, data[0], data[1], data[2], data[3],
                    data[4], data[5]);
        model.add(animal);
    }

}
