package stack;

import org.junit.Assert;
import org.junit.Test;


public class ArrayStackTest {

    @Test
    public void testBasicOperator() {
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.err.println(arrayStack);
        }
        arrayStack.pop();
        Assert.assertEquals(3, (int) arrayStack.peek());
    }
}