package myapp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NoBookException, IOException {
        App app = new App();

        app.run(args);
    }
}