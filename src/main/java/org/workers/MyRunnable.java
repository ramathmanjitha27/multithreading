package org.workers;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable thread: " + Thread.currentThread().getName());
    }
}
