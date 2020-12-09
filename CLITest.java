import java.io.IOException;

public class CLITest {
    public static void main(String[] args)
            throws IOException {
        Management manager = new Management();
        CLI menu = new CLI();
        menu.run();
    }
}
