package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        int[] ints = smallestK(arr, 4);
        for (int i = 0; i < ints.length; i++) {
            System.err.println(ints[i]);
        }
        System.err.println();
    }

    private static Comparator<Integer> comparator = (int1, int2) -> int2 - int1;

    public static int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(comparator);
        if (arr.length <= k) {
            return arr;
        }

        if (k == 0) {
            return new int[]{};
        }

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (!queue.isEmpty() && arr[i] < queue.peek()) {
                queue.remove();
                queue.add(arr[i]);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                break;
            }
            result[i] = queue.remove();
        }
        return result;
    }
}
