package ir.phgint;

import org.junit.Test;

public class TestPc {

    @Test
    public void pc() {

        Buffer buffer = new Buffer(true);
        Producer producer = new Producer(buffer);
        Consumer consumer1=new Consumer(buffer);
        Thread thread =new Thread( consumer1);

        try {

            thread.start();
            Thread.sleep(1000);
            producer.start();

            producer.join(0);
            consumer1.setIsRunning(false);
            thread.interrupt();
            thread.join(0);
//            Thread.sleep(10000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}
