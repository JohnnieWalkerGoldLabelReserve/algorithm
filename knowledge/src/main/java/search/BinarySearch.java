package search;


public class BinarySearch {

    public static int search(int[] arr, int target) {
        return search(arr, 0, arr.length - 1, target);
    }

    private static int search(int[] arr, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int middle = l + (r - l) / 2;
        if (arr[middle] == target) {
            return middle;
        }
        if (arr[middle] < target) {
            search(arr, middle + 1, r, target);
        }
        return search(arr, l, middle - 1, target);
    }

    private static int loopSearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] < target) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return -1;
    }

    private BinarySearch() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.err.println(loopSearch(arr, 3));
    }
}
