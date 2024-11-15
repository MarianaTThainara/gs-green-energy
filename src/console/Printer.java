package console;

public class Printer {

    public void banner(String banner) {
        int lineWidth = 44;
        int padding = (lineWidth - banner.length()) / 2;

        divide();
        soutln("|" + " ".repeat(padding) + banner.toUpperCase() + " ".repeat(padding) + "|");
        divide();
    }

    public void divide() {
        soutln("----------------------------------------------");
    }

    public void sout(String message) {
        System.out.print(message);
    }

    public void soutln(String message) {
        System.out.println(message);
    }

}
