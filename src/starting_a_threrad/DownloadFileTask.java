package starting_a_threrad;

public class DownloadFileTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Downloading a file: ".concat(Thread.currentThread().getName()));
    }
}
