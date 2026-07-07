package rs.ac.bg.fon.camerarentbackend.infrastructure.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
