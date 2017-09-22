package testdrive;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrian Vangelov
 */
public class Consumer implements Runnable {

    private BlockingQueue<Long> s2;

    public Consumer(BlockingQueue s2) {
        this.s2 = s2;
    }
    
    
    @Override
    public void run() {
        long sum=0;
        while(true){
            try {
                sum +=s2.take();
                System.out.println("Consumed: "+ s2.take());
                System.out.println(sum);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
