package org.threads;

import org.workers.FileDownloader;
import org.workers.MyRunnable;
import org.workers.MyWorkerThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        MyWorkerThread myWorkerThread = new MyWorkerThread();
        myWorkerThread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        Thread t1 = new Thread(new FileDownloader("file1.txt"));
        Thread t2 = new Thread(new FileDownloader("file2.txt"));
        t1.start();
        t2.start();

        //thread pool example
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            final int task = i;
            executor.submit(() -> {
                System.out.println("Running task " + task + " in " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
    }
}