import java.util.Scanner;

/*
 * 这个程序是一个线性搜索的完整程序。它会从用户输入中获取一个10位的数组和一个搜索目标，然后调用方法完成搜索。

要求：
写一个linearSearch方法：
这个方法的参数至少要包含一个int类型的数组，和一个int值作为搜索目标。
要用线性搜索算法完成。
如果搜索目标在数组中，返回这个搜索目标在数组中的索引（一个int值）；
如果搜索目标不在数组中，返回-1。
main()方法：
依次获取用户输入的十个int值，组成一个数组arr。
再获取一个用户输入的int值，作为搜索目标key。
用arr和key调用linearSearch方法，打印方法的返回值，并打印一个新的空行。
 */

public class LinearSearch {
    //main入口
    public static void main(String[] args) {
        int arrLength = 10;
        int[] numArr = new int[arrLength];
        int numKey;
        //获取输入
        Scanner sc = new Scanner(System.in);
        //前10个输入组成数组
        for (int i = 0; i < arrLength; ++i) {
            numArr[i] = sc.nextInt();
        }
        numKey = sc.nextInt();
        //调用线性搜索方法
        int res = linearSearch(numArr, numKey);
        if (res == -1) {
            System.out.println("目标未找到");
        }
        else System.out.println("目标已找到，索引是" + res);

    }

    //linearSearch方法-返回值类型、方法名、参数列表
    public static int linearSearch(int[] arr, int target) {
        //顺次遍历数组元素，与目标比对
        for(int i=0; i<arr.length; ++i) {
            //找得到，返回索引
            if (arr[i] == target) {
                return i;
            }
        }
        //遍历完找不到，返回-1
        return -1;
    }

}
