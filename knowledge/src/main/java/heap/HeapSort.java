package heap;


public class HeapSort {

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0 ; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i);
        }
    }

    private static <E extends Comparable<E>> void siftDown(E[] arr, int k, int n) {
        while (leftChild(k) < n) {
            int j = leftChild(k);
            if (j + 1 < n && arr[j].compareTo(arr[j + 1]) < 0) {
                j++;
            }
            if (arr[j].compareTo(arr[k]) <= 0) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    private static int leftChild(int k) {
        return k * 2 + 1;
    }

    private static int parent(int k) {
        return (k - 1) / 2;
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int l, int r) {
        E tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1, 3, 5, 9, 0, 7};
        sort(arr);
        for (int i = 0; i < 6; i++) {
            System.err.println(arr[i]);
        }
    }
}
