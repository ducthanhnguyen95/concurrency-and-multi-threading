package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {

    private int totalBytes;
    private Lock lock = new ReentrantLock();
    String a = null;


    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        lock.lock();
        totalBytes++;
        lock.unlock();
    }
}
