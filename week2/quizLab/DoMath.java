/*
q4
我们要做一个加减乘除计算器。

这个程序包含两个类：1.Calculator类；2.DoMath类（public)。

Calculator类包含对两个整数字段加减乘除的四个方法，每个方法有自己对应的打印。

DoMath类是public类，其中的main方法中我们会根据用户输入的两个整数创建Calculator类的对象，并依次调用方法打印出这两个数字的和、差、积、商。

要求：
Calculator类：
字段：
字段1：整数a。
字段2：整数b。
构造器：
构造器有两个整数参数，分别赋值给a和b。
方法：
方法1：求a和b的和（a+b），并打印。打印格式为“和为{和}”，并创建一个新的空行。
（例如：和为10）
方法2：求a和b的差（a-b），并打印。打印格式为“差为{差}”，并创建一个新的空行。
方法3：求a和b的乘积（a*b），并打印。打印格式为“乘积为{乘积}”，并创建一个新的空行。
方法4：求a和b的商（a/b），如果不能整除则向下取整，并打印。打印格式为“商为{商}”，并创建一个新的空行。

DoMath类：
获取用户输入的两个整数，依次赋值给变量x和y。
调用Calculator类的构造器创建一个Calculator类对象cal，参数为x和y。
对cal依次调用Calculator类的方法1，方法2，方法3，方法4。
*/
import java.util.Scanner;
class Calculator {
    private int a = 0;
    private int b = 0;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void sum() {
        int res = a + b;
        System.out.println("和为" + res);
    }
    public void diff() {
        int res = a - b;
        System.out.println("差为" + res);
    }
    public void product() {
        int res = a * b;
        System.out.println("乘积为" + res);
    }
    public void division() {
        int res = a / b;
        System.out.println("商为" + res);
    }
}
public class DoMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Calculator cal = new Calculator(x, y);
        cal.sum();
        cal.diff();
        cal.product();
        cal.division();
    }


}
