package ir.phgint;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

public class TestPc {

    @Test
    public void pc() {

        final BlockingQueue<Integer> tQueue = new LinkedBlockingQueue<Integer>(1);

        Producer producer = new Producer(tQueue);
        Consumer consumer1 = new Consumer(tQueue);
        Thread thread = new Thread(consumer1);

        try {
            thread.start();
            producer.start();
            producer.join(0);
            consumer1.setIsRunning(false);
            thread.interrupt();
            thread.join(0);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
