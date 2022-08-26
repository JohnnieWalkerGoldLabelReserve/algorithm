package search;

/**
 * @author zhaoyang
 * @date 2022/8/25 5:08 下午
 */
public class BinarySearchUpper {

    public static int upper(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int middle = l + (r - l) / 2;
            if (nums[middle] <= target) {
                l = middle + 1;
            } else {
                r = middle;
            }
        }
        return l;
    }

    public static int lower(int[] nums, int target) {
        int l = -1;
        int r = nums.length - 1;
        while (l < r) {
            int middle = l + (r - l + 1) / 2;
            if (nums[middle] < target) {
                l = middle;
            } else {
                r = middle - 1;
            }
        }
        return l;
    }

    public static int ceil(int[] nums, int target) {
        int u = upper(nums, target);
        if (u - 1 >= 0 && nums[u - 1] == target) {
            return u - 1;
        }
        return u;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 1, 3, 3, 5, 5};
        for (int i = 0; i < 7; i++) {
            System.err.println(ceil(nums, i));
        }
    }
}
