package sort;


public class QuickSort implements Sort {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public <E extends Comparable<E>> void quickSort(E[] arr, int l, int r) {
        if (l < r) {
            int p = paratition2(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }


    public <E extends Comparable<E>> int paratition(E[] arr, int l, int r) {
        int j = l;
        int i = r;
        E cmp = arr[l];
        while (j < i) {
            while (j < i && cmp.compareTo(arr[i]) <= 0) {
                i--;
            }
            while (j < i && cmp.compareTo(arr[j]) >= 0) {
                j++;
            }
            if (j < i) {
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public <E extends Comparable<E>> int paratition2(E[] arr, int l, int r) {
        // arr[l+1,j] <v arr[j+1,i]>=v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[l].compareTo(arr[i]) >= 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }


    public static void main(String[] args) {
        QuickSort mergeSort = new QuickSort();
        Integer[] arr = new Integer[]{1, 3, 2, 5, 6, 4, 9, 5, 7, 9, 0};
        mergeSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.err.print(arr[i]);
        }
        System.err.println();
    }
}
