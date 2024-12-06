package synchronized_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreadDemo {
    public static void show() {
        var collection = Collections.synchronizedCollection(new ArrayList<>());

        var thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1, 2, 3));
        });
        var thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(4, 5, 6));
        });
        var thread3 = new Thread(() -> {
            collection.addAll(Arrays.asList(7, 8, 9));
        });
        var thread4 = new Thread(() -> {
            collection.addAll(Arrays.asList(10,11,12));
        });
        var thread5 = new Thread(() -> {
            collection.addAll(Arrays.asList(13,14,15));
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(collection);
    }
}
