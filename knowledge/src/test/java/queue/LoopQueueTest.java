package queue;

import org.junit.Assert;
import org.junit.Test;

public class LoopQueueTest {

    @Test
    public void testLoopQueue() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>(3);
        for (int i = 0; i < 5; i++) {
            loopQueue.enqueue(i);
        }
        System.err.println(loopQueue);
        Assert.assertEquals(0, (int) loopQueue.dequeue());
        System.err.println(loopQueue);
        loopQueue.enqueue(-1);
        loopQueue.enqueue(-2);
        loopQueue.dequeue();
        loopQueue.enqueue(-3);
        System.err.println(loopQueue);
    }
}
