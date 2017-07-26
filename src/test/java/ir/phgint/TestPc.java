package ir.phgint;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

public class TestPc {


    @Test
    public void pc() {


        final Queue<PrimeNumber> pQueue = new PriorityQueue<PrimeNumber>();

        Buffer buffer = new Buffer(true);

        Producer producer = new Producer(pQueue, buffer);
        Consumer consumer1 = new Consumer(pQueue, buffer);
        Thread thread = new Thread(consumer1);

        try {
            thread.start();
            producer.start();
            producer.join(0);
            Thread.sleep(1000);
            consumer1.setIsRunning(false);
            thread.join(0);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
