
import java.io.*;

public class Logger {
    private static Logger INSTANCE = new Logger();
    public static Logger getLogger() { return INSTANCE; }
    private Logger() {
        this.string = "";
    }

    private String string;
    public void log(String add) {
        this.string += add;
    }
    public void write() {
        try (PrintWriter out = new PrintWriter("simulation.txt") ) {
            out.print(this.string);
        } catch (FileNotFoundException e) {
            System.err.println("Error while writing");
        }
    }
}
