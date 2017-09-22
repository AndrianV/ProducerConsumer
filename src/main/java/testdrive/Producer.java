package testdrive;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Andrian Vangelov
 */
public class Producer implements Runnable {

    private BlockingQueue<Long> s1;
    private BlockingQueue<Long> s2;

    public Producer(BlockingQueue<Long> s1, BlockingQueue<Long> s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
    
    @Override
    public void run() {
        long num;

        while (!s1.isEmpty()) {
            num = s1.poll();
            try {
                s2.put(fib(num));
            } catch (InterruptedException ex) {

            }
        }
    }

    public long fib(long n) throws InterruptedException {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }

    }
}
