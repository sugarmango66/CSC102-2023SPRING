package mergeArray;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab {

    /*在这里补全merge方法*/
    public static int[] merge(int[] arr1, int[] arr2) {
        ArrayList<Integer> res = new ArrayList<>();
        //make 2 pointer
        int i = 0;
        int j = 0;

        while (res.size() != arr1.length + arr2.length) {
            //arr1 finish but arr2 not
            if (i == arr1.length && j < arr2.length) {
                res.add(arr2[j++]);
                continue;
            }
            //arr2 finish but arr1 not
            if (j == arr2.length && i < arr1.length) {
                res.add(arr1[i++]);
                continue;
            }
            //compare current elem
            if (arr1[i] > arr2[j]) {
                res.add(arr2[j++]);
            } else if (arr1[i] < arr2[j]) {
                res.add(arr1[i++]);
            } else if (arr1[i] == arr2[j]) {
                res.add(arr2[j++]);
                res.add(arr1[i++]);
            }
        }
        //turn Arraylist to []
        int[] resArray = new int[res.size()];
        for (int k = 0; k < resArray.length; k++) {
            resArray[k] = res.get(k);
        }
        return resArray;
    }

    @Test
    public void test() {
        int[] arr1 = {};
        int[] arr2 = {2,4,6,8};
        int[] merge = merge(arr1, arr2);
        System.out.println(Arrays.toString(merge));
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int nums1Len = scnr.nextInt();
        int[] arr1 = new int[nums1Len];
        for (int a = 0; a < nums1Len; a++) {
            arr1[a] = scnr.nextInt();
        }

        int nums2Len = scnr.nextInt();
        int[] arr2 = new int[nums2Len];
        for (int b = 0; b < nums2Len; b++) {
            arr2[b] = scnr.nextInt();
        }

        int[] result = merge(arr1, arr2);
        for (int ele : result) {
            System.out.print(ele + " ");
        }
    }
}
