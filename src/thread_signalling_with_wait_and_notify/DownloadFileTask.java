package thread_signalling_with_wait_and_notify;

public class DownloadFileTask implements Runnable {

    private final DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: ".concat(Thread.currentThread().getName()));

        for (var i = 0; i < 10_000_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.incrementTotalBytes();
        }

        status.done();

        synchronized (status) {
            status.notifyAll();
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

}
