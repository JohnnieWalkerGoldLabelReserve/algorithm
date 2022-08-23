package sort;


import java.util.Random;

public class QuickSort implements Sort {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        sort3Ways(arr, 0, arr.length - 1);
    }

    public <E extends Comparable<E>> void quickSort(E[] arr, int l, int r) {
        if (l < r) {
            int p = paratition2(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }


    public <E extends Comparable<E>> int paratition2Way(E[] arr, int l, int r) {
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

    public <E extends Comparable<E>> void sort3Ways(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //randomSwap(arr, l, r);
        // arr[lt+1,i] <v arr[i+1,gt] >v
        int lt = l ;
        int i = l+1;
        int gt = r + 1;
        E cmp = arr[l];
        while (i < gt) {
            // arr[i] < cmp
            if (cmp.compareTo(arr[i]) > 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            }
            // arr[i] > cmp
            else if (cmp.compareTo(arr[i]) < 0) {
                gt--;
                swap(arr, i, gt);
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        sort3Ways(arr, l, lt - 1);
        sort3Ways(arr, gt, r);
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

    public <E extends Comparable<E>> void randomSwap(E[] arr, int l, int r) {
        Random random = new Random();
        int idx = l + random.nextInt(r - l - 1);
        swap(arr, l, idx);
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
