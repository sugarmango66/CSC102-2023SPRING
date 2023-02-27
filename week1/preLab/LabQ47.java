/*
要求：
编写一个程序，读取用户输入的正整数，并把它们存入一个ArrayList中，直到用户输入一个负数。
然后，把ArrayList中的所有数字相加求和，输出这个和，并创建一个新的空行。
 */

import java.util.Scanner;
import java.util.ArrayList;
public class LabQ47 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        int total = 0;
        int numInp = scan.nextInt();
        while(numInp >= 0) {
            nums.add(numInp);
            numInp = scan.nextInt();
        }

        for(int i=0; i<nums.size(); ++i) {
            total += nums.get(i);
        }
        System.out.println(total);
    }

    
}
