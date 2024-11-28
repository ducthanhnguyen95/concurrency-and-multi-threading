package locks;

import java.util.ArrayList;

public class ThreadDemo {
    public static void show() {
        var status = new DownloadStatus();
        var listThread = new ArrayList<Thread>();
        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            listThread.add(thread);
        }


        for (Thread item : listThread) {
            try {
                item.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(status.getTotalBytes());
    }
}
