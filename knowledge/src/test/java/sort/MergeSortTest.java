package sort;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author zhaoyang
 * @date 2022/8/13 9:02 下午
 */
public class MergeSortTest extends TestCase {

    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        Integer[] arr = new Integer[]{1, 3, 2, 5, 6, 4, 9, 5, 7, 9, 0};
        mergeSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.err.print(arr[i]);
        }
        System.err.println();
    }

    @Test
    public void testMerge() {

    }

    @Test
    public void testCopyRangeArray() {

    }
}