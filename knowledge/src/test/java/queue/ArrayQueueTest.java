package queue;

import org.junit.Assert;
import org.junit.Test;

public class ArrayQueueTest {

    @Test
    public void testArrayQueueOperation(){
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i <5 ; i++) {
            arrayQueue.enqueue(i);
        }
        Assert.assertEquals(0, (int) arrayQueue.getFront());
        arrayQueue.dequeue();
        Assert.assertEquals(1, (int) arrayQueue.getFront());
        System.err.println(arrayQueue);
    }
}