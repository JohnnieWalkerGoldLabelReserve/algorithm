package sort;

public class MergeSort {

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }


    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int middle = (l + r) / 2;
        mergeSort(arr, l, middle);
        mergeSort(arr, middle + 1, r);
        merge(arr, l, middle, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] tmpArr = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                tmpArr[idx++] = arr[i];
                i++;
            } else {
                tmpArr[idx++] = arr[j];
                j++;
            }
        }
        for (int tmp = i; tmp <= mid; tmp++) {
            tmpArr[idx++] = arr[tmp];
        }
        for (int tmp = j; tmp <= r; tmp++) {
            tmpArr[idx++] = arr[tmp];
        }
        idx = 0;
        for (int tmp = l; tmp < r + 1; tmp++) {
            arr[tmp] = tmpArr[idx++];
        }

    }
}
