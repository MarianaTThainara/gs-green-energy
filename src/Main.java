import console.commands.Command;

public class Main {
    public static void main(String[] args) {
        try {

            Command command = new Command();
            command.run();
        } catch (RuntimeException e) {
            System.out.println("Sentimos muito =(! Um erro aconteceu.");
        }
    }
}