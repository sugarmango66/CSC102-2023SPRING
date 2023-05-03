package removeDuplicates;
/*
获取一个有序整数数组作为参数，
原地删除重复出现的元素，使得出现次数超过2次的元素只出现2次 ，
返回删除后数组的新长度
扩展：使得出现次数超过n次的元素只出现n次
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Lab {

    /*在这里补全removeDuplicates方法*/
    public static int removeDuplicates(int[] nums, int maxRepeat) {
//        int maxRepeat = 2;
        if (nums.length <= maxRepeat) {
            return nums.length;
        }
        int fast = maxRepeat;
        int slow = maxRepeat;
        while (fast < nums.length) {
            if (nums[slow - maxRepeat] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    @Test
    public void test_removeDuplicates() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
//        int[] nums = {0};
        int got = removeDuplicates(nums, 3);
        int expected = 8;
        Assertions.assertEquals(expected, got);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numsLen = scnr.nextInt();
        int[] nums = new int[numsLen];
        for (int i = 0; i < numsLen; i++) {
            nums[i] = scnr.nextInt();
        }
        int result = removeDuplicates(nums, 2);

        System.out.println(result);

        for (int j = 0; j < result; j++) {
            System.out.print(nums[j] + " ");
        }
    }
}
