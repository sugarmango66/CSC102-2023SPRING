import java.util.Scanner;
/*
这个程序是一个两分搜索的完整程序。它会从用户输入中获取一个10位的数组和一个搜索目标，然后调用方法完成搜索。

要求：
写一个binarySearch方法：
这个方法的参数至少要包含一个int类型的数组，和一个int值作为搜索目标。
要用两分搜索算法完成。
如果搜索目标在数组中，返回这个搜索目标在数组中的索引（一个int值）；
如果搜索目标不在数组中，返回-1。
main()方法：
依次获取用户输入的十个int值，组成一个数组arr。（假设用户输入时已经按照从小到大的顺序输入）
再获取一个用户输入的int值，作为搜索目标key。
用arr和key调用linearSearch方法，打印方法的返回值，并打印一个新的空行。
 */
public class BinarySearch {
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
        //调用二分搜索
        int res = binarySearch(numArr, numKey);
        if (res == -1) {
            System.out.println("目标未找到");
        }
        else System.out.println("目标已找到，索引是" + res);

    }

    //定义二分搜索方法
    public static int binarySearch(int[] arr, int target) {
        //起始搜索索引范围
        int start = 0;
        int end = arr.length - 1;
        int mid;
        //根据搜索范围中间值和目标的大小来更新搜索范围
        while(start <= end) {
            mid = (start + end) / 2; //或者 mid = start + (end - start)/2;
            if(target == arr[mid]) {
                return mid;
            }
            else if(target > arr[mid]) {
                start = mid + 1;
            }
            else if(target < arr[mid]) {
                end = mid - 1;
            }
        }
        //搜索范围已缩到最小，仍未找到
        return -1;
    }
}
