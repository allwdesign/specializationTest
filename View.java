import java.util.Scanner;

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
                "teach - Teach the animal new commands\n" +
                "list - list of animals");
        System.out.println("***************************************************************");

        System.out.println("***************************************************************");

    }

    protected String getCommand() {
        /* Displays to the user adding command interaction */

        System.out.print("Enter the command: ");
        // Getting Input from User
        String command = userInput.nextLine();

        System.out.println("You entered string " + command);
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
        System.out.print("Chose the type of animal: ");
        // Getting Input from User
        animalChoiceString = userInput.nextLine();

        // animal.getInfo();
        return animalChoiceString;

    }

    public static void printHelperText() {
        String textForUser = "Enter the data separated by colon: name, commands, birthday";

        String dataFormatsInfo = "Data formats:";
        dataFormatsInfo += "\n* name, commands - Strings. May contain numbers, letters in different case, space and underscore";
        dataFormatsInfo += "\n* date of birth - Format string dd.mm.yyyy";
        dataFormatsInfo += "\n* gender - Latin character f or m";
        dataFormatsInfo += "\n* size - Latin character s or m or b";
        //"Small", "Midlle", "Big"
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

    protected String getParams() {
        printHelperText();

        System.out.print("Please enter your data: ");

        String inputString = userInput.nextLine();
        System.out.println("***************************************************************");

        return inputString;
    }

}
