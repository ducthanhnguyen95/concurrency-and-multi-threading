package joining_a_thread;

public class DownloadFileTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Downloading a file: ".concat(Thread.currentThread().getName()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

}
