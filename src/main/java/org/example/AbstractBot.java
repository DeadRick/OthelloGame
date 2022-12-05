package org.example;


public abstract class AbstractBot extends Player {
    public void createTimeDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
