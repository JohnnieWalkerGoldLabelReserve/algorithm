package sort;


public interface Sort {

    <E extends Comparable<E>> void sort(E[] arr);

    default <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
