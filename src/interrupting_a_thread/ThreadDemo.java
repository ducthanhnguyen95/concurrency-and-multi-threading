package interrupting_a_thread;

public class ThreadDemo {
    public static void show() {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
