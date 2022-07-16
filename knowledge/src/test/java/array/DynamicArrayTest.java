package array;

import org.junit.Assert;
import org.junit.Test;


public class DynamicArrayTest {

    @Test
    public void testDynamic() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<Integer>(10);
        for (int i = 0; i < 20; i++) {
            dynamicArray.addLast(i);
        }
        Assert.assertEquals(12, (int) dynamicArray.get(12));
        Assert.assertEquals(19, (int) dynamicArray.getLast());
        dynamicArray.removeLast();
        Assert.assertEquals(18, (int) dynamicArray.getLast());
        System.err.println(dynamicArray);

    }

}