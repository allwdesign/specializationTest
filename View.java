import java.util.ArrayList;
import java.util.Scanner;

import AnimalsReestr.Animal;

public class View {
    /*
     * This is the View class.
     * 
     * Presents the data to the user.
     */

    static Scanner userInput = new Scanner(System.in);

    public void view() {
        /* Displays to the user what commands are in the application */
        System.out.println("***************************************************************");
        System.out.println("***************************************************************");
        System.out.println("Animal Registry");

        System.out.println("***************************************************************");
        System.out.println("Actions:\n" +
                "add - Add new animal\n" +
                "comm - See the list of commands that the animal " +
                "executes\n" +
                "train - Train the animal new commands\n" +
                "list - List of animals\n" +
                "exit - Exit from app");
        System.out.println("***************************************************************");

        System.out.println("***************************************************************");

    }

    protected String getCommandView() {
        /* Displays to the user adding command interaction */
        System.out.print("Enter the command: ");
        // Getting Input from User
        String command = userInput.nextLine();
        System.out.println("***************************************************************");
        return command;
    }

    protected void successfullyAddAnimalView() {
        System.out.println("You add new animal");

    }

    protected String choiceOfAnimalTypeView() {
        String animalChoiceString;

        System.out.println("***************************************************************");
        System.out.println("Animal classes available:");
        // Packs
        System.out.println("For Packs:");
        System.out.println("\t1 - Horse");
        System.out.println("\t2 - Camell");
        System.out.println("\t3 - Donkey");
        // Pets
        System.out.println("For Pets:");
        System.out.println("\t4 - Cat");
        System.out.println("\t5 - Dog");
        System.out.println("\t6 - Hamster");
        System.out.println("***************************************************************");
        System.out.print("Chose the class of animal: ");
        // Getting Input from User
        animalChoiceString = userInput.nextLine();

        return animalChoiceString;

    }

    public static void printHelperTextView() {
        String textForUser = "Enter the data separated by colon:";

        String dataFormatsInfo = "Data formats:";
        dataFormatsInfo += "\n* name, commands - Strings. May contain numbers, letters in different case, space and underscore";
        dataFormatsInfo += "\n* date of birth - Format string dd.mm.yyyy";
        dataFormatsInfo += "\n* gender - Latin character f or m";
        dataFormatsInfo += "\n* size - Latin character s or m or b";
        // "Small", "Midlle", "Big"
        dataFormatsInfo += "\n\t* s - Small";
        dataFormatsInfo += "\n\t* m - Midlle";
        dataFormatsInfo += "\n\t* b - Big";
        dataFormatsInfo += "\n* ownerFio - Owner data (last name, first name, patronymic)";

        String dataExample = "\nExample data: ";
        dataExample += "\n\tLulu:Alur and golop:07.08.2021:f:b:Abu Halif";
        dataExample += "\n\tGrey Sky:Alur and golop:07.08.2021:m:m:Abu Halif";
        System.out.println("***************************************************************");
        System.out.println(textForUser);
        System.out.println("***************************************************************");
        System.out.println(dataFormatsInfo);

        System.out.println(dataExample);
        System.out.println("***************************************************************");

    }

    protected String getParamsView() {
        printHelperTextView();

        System.out.print("Please enter your data: ");

        String inputString = userInput.nextLine();
        System.out.println("***************************************************************");

        return inputString;
    }

    protected String getAnimalNameView() {
        System.out.print("Enter the name of the animal: ");
        String inputString = userInput.nextLine();
        System.out.println("***************************************************************");

        return inputString;
    }

    protected String getAnimalUuidView() {
        System.out.print("Enter the UUID of the animal: ");
        String inputString = userInput.nextLine();
        System.out.println("***************************************************************");

        return inputString;
    }

    protected String getAdditionalCommandsView() {
        System.out.print("Enter the additional commands for the animal: ");
        String inputString = userInput.nextLine();
        System.out.println("***************************************************************");

        return inputString;
    }

    public void successfullyTrainingAnimalView(String name, String commands) {
        System.out.println("***************************************************************");
        System.out.println("The training was successful");
        System.out.println(name + " can now: " + commands); 
        System.out.println("***************************************************************");
    }

    public void listOfCommandsView(String name, String commands) {
        System.out.println("***************************************************************");
        System.out.println("View List of commands for " + name + ":\n\t" + commands);
        System.out.println("***************************************************************");
    }

    public void animalsView(ArrayList<Animal> animals) {
        String genderStr = "";
        String sizeStr = "";
        String resStr = "";
        System.out.println("***************************************************************");
        System.out.println("View List of animals");
        for (Animal animal : animals) {
            System.out.println("***************************************************************");
            if (animal.getGender().equals("f")) {
                genderStr = "female";
            } else {
                genderStr = "male";
            }

            switch (animal.getSize()) {
                case ("s"):
                    sizeStr = "small";
                    break;
                case ("m"):
                    sizeStr = "midlle";
                    break;
                case ("b"):
                    sizeStr = "big";
                    break;
            }

            String pattern = "UUID: %s\nType: %s\nClass: %s\nName: %s\n";
            pattern += "Commands: %s\nBirthday: %s\nGender: %s\nSize: %s\nOwner: %s";
            resStr = String.format(pattern, animal.getUuid().toString(),
                    animal.getType(), animal.getClass().getSimpleName(),
                    animal.getName(), animal.getCommands(), animal.getBirthday(),
                    genderStr, sizeStr, animal.getOwnerFio());
            System.out.println(resStr);
            System.out.println("***************************************************************");
        }
        System.out.println("***************************************************************");
    }
}
