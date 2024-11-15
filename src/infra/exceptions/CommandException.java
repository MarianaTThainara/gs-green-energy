package infra.exceptions;

abstract class CommandException extends RuntimeException {
    public CommandException(String message) {
        super(message);
    }
}
