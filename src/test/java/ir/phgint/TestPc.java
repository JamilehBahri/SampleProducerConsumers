package ir.phgint;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class TestPc {

    @Test
    public void pc() {

        final Queue<Integer> tQueue = new LinkedList<Integer>();

        Buffer buffer = new Buffer(tQueue,true);
        Producer producer = new Producer(buffer);
        Consumer consumer1 = new Consumer(buffer);
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
