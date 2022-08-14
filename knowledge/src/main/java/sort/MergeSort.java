package sort;


import java.util.Arrays;

public class MergeSort implements Sort {

    public static <E extends Comparable<E>> void mergeSort(E[] arr, int low, int hight) {
        if (low >= hight) {
            return;
        }
        int middle = low + (hight - low) / 2;
        mergeSort(arr, low, middle);
        mergeSort(arr, middle + 1, hight);
        merge(arr, low, middle, hight);
    }

    public static <E extends Comparable<E>> void mergeSort2(E[] arr, int low, int hight) {
        if (low >= hight) {
            return;
        }
        int middle = low + (hight - low) / 2;
        mergeSort(arr, low, middle);
        mergeSort(arr, middle + 1, hight);
        if (arr[middle].compareTo(arr[middle + 1]) > 0) {
            merge(arr, low, middle, hight);
        }
    }

    public static <E extends Comparable<E>> void merge(E[] arr, int low, int middle, int hight) {
        //拷贝指定区间的数组
        E[] copyArray = copyRangeArray(arr, low, hight + 1);
        int i = low;
        int j = middle + 1;
        for (int k = low; k <= hight; k++) {
            if (i > middle) {
                arr[k] = copyArray[j - low];
                j++;
            } else if (j > hight) {
                arr[k] = copyArray[i - low];
                i++;
            } else if (copyArray[i - low].compareTo(copyArray[j - low]) < 0) {
                arr[k] = copyArray[i - low];
                i++;
            } else {
                arr[k] = copyArray[j - low];
                j++;
            }
        }
    }


    public static <E> E[] copyRangeArray(E[] arr, int low, int hight) {
        return Arrays.copyOfRange(arr, low, hight);
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
}
