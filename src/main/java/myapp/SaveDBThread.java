package myapp;

import java.io.IOException;

public class SaveDBThread extends Thread{

    Boolean isRunning = true;

    void stopThread () {
        isRunning = false;
    }


    @Override
    public void run () {
        BookLoanManager manager = null;
        try {
            manager = BookLoanManager.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (isRunning) {
            try {
                manager.saveDB();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
