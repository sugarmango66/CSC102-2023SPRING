package preLab;

import java.util.Scanner;

/*
要求：
公有静态成员方法1：add(...){...}，这个方法返回值为空，有一个StringBuilder类的参数a。
方法体的作用是调用append方法给a后面追加一个字符串"你好"。
比如如果a是"Java"，调用这个方法后a就会变成"Java你好"。
公有静态成员方法2：change(...){...}，这个方法返回值为空，有一个StringBuilder类的参数b。
方法体会让 b 舍弃原来的引用，改为引用一个新的StringBuilder"再见"，然后方法会打印新得到的b，并创建一个新的空行。

main方法：
依次获取用户的两个字符串输入，存入字符串变量input1和input2。
创建一个StringBuilder类引用sb1，引用一个参数为input1的StringBuilder类对象。
创建另一个StringBuilder类引用sb2，引用一个参数为input2的StringBuilder类对象。
以sb1为参数调用add方法。
以sb2为参数调用change方法。
打印sb1，并创建一个新的空行。
打印sb2，并创建一个新的空行
 */
public class Q7Lab {
    public static void add(StringBuilder a) {
        a.append("你好");
    }
    public static void change(StringBuilder b) {
        b = new StringBuilder("再见");
        System.out.println(b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        StringBuilder sb1 = new StringBuilder(input1);
        StringBuilder sb2 = new StringBuilder(input2);
        add(sb1);
        change(sb2);
        System.out.println(sb1);//sb1变化
        System.out.println(sb2);//sb2不变
    }
}
