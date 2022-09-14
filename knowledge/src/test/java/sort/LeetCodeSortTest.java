package sort;


import java.util.Random;

public class LeetCodeSortTest {

    public static void main(String[] args) {
        int[] weights = new int[]{3, 3, 3, 3, 3, 3};
        System.err.println(getDays(weights, 10));
    }

    public static int getDays(int[] weights, int k) {
        int days = 1;
        int index = 0;
        int sum = k;
        while (index < weights.length) {
            if (sum - weights[index] < 0) {
                sum = k;
                days++;
            } else if (sum - weights[index] == 0) {
                sum = k;
                days++;
                index++;
            } else {
                sum -= weights[index];
                index++;
            }
        }
        if (sum == k) {
            days--;
        }
        return days;
    }

    public static int getSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }

    public static int getMax(int[] weights) {
        int max = 0;
        for (int weight : weights) {
            if (weight > max) {
                max = weight;
            }
        }
        return max;
    }

}
