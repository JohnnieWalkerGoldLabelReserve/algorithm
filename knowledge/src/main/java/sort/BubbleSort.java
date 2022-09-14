package sort;

/**
 * @author zhaoyang
 * @date 2022/8/14 7:39 下午
 */
public class BubbleSort implements Sort {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}

