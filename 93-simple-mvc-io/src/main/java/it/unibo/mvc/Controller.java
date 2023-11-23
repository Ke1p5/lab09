package it.unibo.mvc;


/**
 * Application controller. Performs the I/O.
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Controller {
    private File current;
    private static final String PATH = System.getProperty("user.home")
            + File.separator
            + "Output.txt";

    public Controller() {
        this.current = new File(PATH);
    }

    public void setCurrentFile(final File current) {
        this.current = current;
    }

    public File getCurrentFile() {
        return this.current;
    }

    public String getPath() {
        return this.current.toString();
    }

    public void write(final String line) {
        try (PrintStream ps = new PrintStream(this.getPath(), StandardCharsets.UTF_8)) {
            ps.print(line);
        } catch (IOException e) {
            System.out.println(e.getMessage()); // NOPMD: allowed as this is just an exercise
        }
    }
}
