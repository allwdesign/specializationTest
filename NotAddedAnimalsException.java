public class NotAddedAnimalsException extends NullPointerException{
    public NotAddedAnimalsException() {
        super("Haven't added any animals yet. You can add an animal");
    }
}
