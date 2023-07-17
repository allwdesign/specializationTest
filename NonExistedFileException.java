import java.io.FileNotFoundException;

public class NonExistedFileException extends FileNotFoundException {
    public NonExistedFileException() {
        super("File does not exist");
    }
}