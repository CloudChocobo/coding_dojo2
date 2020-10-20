package ah;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static boolean isLeap(int number) {
        if (number / 400) {
            return true;
        }
    }
}
