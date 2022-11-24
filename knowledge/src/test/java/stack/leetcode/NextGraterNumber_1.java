package stack.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGraterNumber_1 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> result = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            int rightMaxNum = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
            result.put(nums2[i], rightMaxNum);
        }
        int[] resultNums = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            resultNums[i] = result.get(nums1[i]);
        }
        return resultNums;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {4,1,2};
        int[] nums2 = new int[] {1,3,4,2};
        int[] element = nextGreaterElement(nums1, nums2);
        for (int i : element) {
            System.err.println(i);
        }
    }
}