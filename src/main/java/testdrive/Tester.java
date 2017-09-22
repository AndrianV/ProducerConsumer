package testdrive;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Andrian Vangelov
 */
public class Tester {

    public static void main(String[] args) {
        BlockingQueue s1 = new ArrayBlockingQueue<Long>(11);
        BlockingQueue s2 = new ArrayBlockingQueue<Long>(11);

        s1.add(4L);
        s1.add(5L);
        s1.add(8L);
        s1.add(12L);
        s1.add(21L);
        s1.add(22L);
        s1.add(34L);
        s1.add(35L);
        s1.add(36L);
        s1.add(37L);
        s1.add(42L);

        Thread p1 = new Thread(new Producer(s1, s2));
        Thread p2 = new Thread(new Producer(s1, s2));
        Thread p3 = new Thread(new Producer(s1, s2));
        Thread p4 = new Thread(new Producer(s1, s2));

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        
        Thread c1 = new Thread(new Consumer(s2));
        c1.start();
    }

}
