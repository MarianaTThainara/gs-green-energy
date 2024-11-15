package infra.exceptions;

public class InvalidOptionException extends CommandException {
    public InvalidOptionException() {
        super("Opção inválida! Tente novamente.");
    }
}
