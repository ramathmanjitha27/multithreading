package org.workers;

public class MyWorkerThread extends Thread {

    @Override
    public void run(){
        System.out.println("Running in MyWorkerThread: " + Thread.currentThread().getName());
    }
}
