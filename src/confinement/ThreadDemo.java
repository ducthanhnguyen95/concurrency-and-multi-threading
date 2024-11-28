package confinement;

import java.util.ArrayList;

public class ThreadDemo {
    public static void show() {
        var listDownloadFileTasks = new ArrayList<DownloadFileTask>();
        var listThread = new ArrayList<Thread>();
        for (var i = 0; i < 10; i++) {
            var downloadFileTask = new DownloadFileTask();
            var thread = new Thread(downloadFileTask);
            thread.start();
            listDownloadFileTasks.add(downloadFileTask);
            listThread.add(thread);
        }


        for (Thread item : listThread) {
            try {
                item.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        var totalBytes = listDownloadFileTasks.stream()
                        .map(item -> item.getStatus().getTotalBytes())
                                .reduce(Integer::sum);

        System.out.println(totalBytes);
    }
}
