package sort;


public class InsertSort implements Sort {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }
}
