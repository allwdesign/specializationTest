import java.util.Arrays;

import AnimalsReestr.Cat;
import AnimalsReestr.Dog;
import AnimalsReestr.Donkey;
import AnimalsReestr.Hamster;
import AnimalsReestr.Horse;

public class Controller {

    /*
     * This is the Controller class.
     * 
     * Accepts user input commands and delegates the presentation of the data
     * to the view, and the handling of the data to the model.
     */
    private final String[] COMMANDS = new String[] { "add", "comm", "teach", "read", "list" };
    String[] validData = new String[3];
    private static View consoleView = new View();
    private Validator validator = new Validator();

    protected void run() {
        /* Run interaction with user */

        // Getting data from file

        // menu
        consoleView.view();
        try {
            String command = consoleView.getCommand();

            // Validate entered data(command)
            if (Arrays.asList(COMMANDS).contains(command)) {
                // execute command
                executeCommand(command);
            } else {
                throw new IllegalArgumentException("Invalid command");
            }

            // Run the command -> Actions with Model
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }

    private void executeCommand(String command) {

        int choiceNum;
        String choice = consoleView.choiceOfAnimalTypeView();

        try {
            choiceNum = Integer.parseInt(choice);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid type of animal");
        }

        switch (command) {
            case "add":
                // Need params name, birthday, commands
                String rawData = consoleView.getParams();

                try {
                    validator.verifyData(rawData.trim());
                    // incorrect: Lulu:Alur and golop/:07.08.20271:r:z:Abu Halif84
                    createAnimal(choiceNum, validData);
                    consoleView.successfullyAddAnimalView();

                } catch (WrongAmountOfDataException e) {
                    System.out.println("You entered less or more data than required!");
                } catch (NotClearDataException e) {
                    System.out.println("The entered data was incorrect. Try again.\n");
                }

                break;
            case "comm":
                System.out.println("List of commands");
                break;
            case "teach":
                System.out.println("Learning new commands");
                break;
            case "_":
                throw new IllegalArgumentException("Invalid command");
        }

    }

    private void createAnimal(int animal, String[] data) {

        String animalString;
        switch (animal) {
            case 1:
                // new Horse();
                animalString = "Horse";
                break;
            case 2:
                // new Camel();
                animalString = "Camel";
                break;
            case 3:
                // new Donkey();
                animalString = "Donkey";
                break;
            case 4:
                // new Cat();
                animalString = "Cat";
                break;
            case 5:
                // new Dog();
                animalString = "Dog";
                break;
            case 6:
                // new Hamster();
                animalString = "Hamster";
                break;
            default:
                throw new IllegalArgumentException("Invalid type of animal");
        }
        System.out.println("Create " + animalString);

    }
}
