package thread_signalling_with_wait_and_notify;

public class DownloadStatus {

    private volatile boolean isDone;

    private int totalBytes;

    private int totalFiles;

    private Object totalBytesLock = new Object();
    private Object totalFilesLock = new Object();

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    public synchronized void incrementTotalFiles() {
        totalFiles++;
    }


    public void done() {
        isDone = true;
    }

    public boolean isDone() {
        return isDone;
    }
//    public synchronized void incrementTotalBytes() {
//            totalBytes++;
//    }
//
//    public synchronized void incrementTotalFiles() {
//            totalFiles++;
//    }
}
