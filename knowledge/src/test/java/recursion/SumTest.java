package recursion;


import org.junit.Test;

public class SumTest {

    @Test
    public void test(){
        int arr[] = new int[]{1,3,5};
        System.err.println(sum(arr));
    }

    public static int sum(int arr[]) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int i) {
        if (i == arr.length - 1) {
            return arr[i];
        }
        return arr[i] + sum(arr, i + 1);
    }


}
