package addOne;
/*
给定一个由整数组成的非空数组digits所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
返回加一新的数组
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Lab {

    /*在这里补全addOne方法*/
    public static int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        boolean isDone = false;
        boolean isAllNine = true; //flag digits contain all 9
        //traverse from back to front
        for (int i = digits.length - 1; i >= 0; i--) {
            if (isDone) {
                res[i] = digits[i];
                continue;
            }
            if (digits[i] < 9) {
                res[i] = digits[i] + 1;
                isAllNine = false;
                isDone = true;
            }
//            if (digits[i] == 9) {
//                res[i] = 0;
//            }
        }
        //must make a new int[] with len+1 (eg 99->100)
        if (isAllNine) {
            res = new int[digits.length + 1];
            res[0] = 1;
        }
        return res;
    }

    @Test
    public void test() {
//        int[] digits = {1, 3};
//        int[] expected = {1, 4};
//        int[] digits = {9, 9};
//        int[] expected = {1, 0, 0};
        int[] digits = {1,9, 9};
        int[] expected = {2, 0, 0};
        int[] got = plusOne(digits);
        Assertions.assertArrayEquals(expected, got);
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numsLen = scnr.nextInt();
        int[] nums = new int[numsLen];
        for (int i = 0; i < numsLen; i++) {
            nums[i] = scnr.nextInt();
        }
        int[] result = plusOne(nums);

        for (int ele : result) {
            System.out.print(ele + " ");
        }
    }
}
