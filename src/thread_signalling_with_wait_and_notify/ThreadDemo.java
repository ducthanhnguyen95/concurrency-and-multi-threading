package thread_signalling_with_wait_and_notify;

public class ThreadDemo {
    public static void show() {
        var status = new DownloadStatus();
        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(() -> {
            synchronized (status) {
                while (!status.isDone()) {
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }
}
