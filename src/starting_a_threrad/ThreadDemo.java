package starting_a_threrad;

public class ThreadDemo {
    public static void show() {
        System.out.println(Thread.currentThread().getName());

        for (var i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }
    }
}
