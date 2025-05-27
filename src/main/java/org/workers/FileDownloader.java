package org.workers;

public class FileDownloader implements Runnable {
    private final String fileName;

    public FileDownloader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run(){
        System.out.println("Downloading " + fileName);
        //simulate delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Download interrupted");
        }
        System.out.println("Download complete" + fileName);
    }

}
