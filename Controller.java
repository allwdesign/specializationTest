import java.util.Arrays;

public class Controller {

    /*
     * This is the Controller class.
     * 
     * Accepts user input commands and delegates the presentation of the data
     * to the view, and the handling of the data to the model.
     */
    private final String[] COMMANDS = new String[] {"add", "comm", "teach", "read", "list"};
    private static View consoleView = new View();
    
    
    protected void run() {
       /* Run interaction with user */
       
        // Getting data from file

        // menu
        consoleView.view();
        try {
            String command = consoleView.getCommand();

            // Validate entered data(command)

            if (Arrays.asList(COMMANDS).contains(command)) {
                System.out.println("CONTAIN");
                // execute command
            } else {
                throw new IllegalArgumentException("Invalid command");
            }


            // Run the command  -> Actions with Model
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}

