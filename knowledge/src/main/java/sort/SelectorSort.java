package sort;

/**
 * @author zhaoyang
 * @date 2022/8/14 7:22 下午
 */
public class SelectorSort implements Sort {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[i]) < 0) {
                    swap(arr, i, j);
                }
            }
        }
    }
}
