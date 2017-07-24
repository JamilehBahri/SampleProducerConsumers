package ir.phgint;

import org.junit.Test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TestPc {

    @Test
    public void pc() {
        final TransferQueue<Integer> tQueue = new LinkedTransferQueue();
        Buffer buffer = new Buffer(true ,tQueue);

        Producer producer = new Producer(buffer);
        Consumer consumer1=new Consumer( buffer);
        Thread thread =new Thread( consumer1);


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
