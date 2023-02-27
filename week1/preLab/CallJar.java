/*
Q9
要求：

Jar类：

字段：

一个private的int类型的字段，代表罐子中糖的数量。

方法：

1.设置罐子中糖数量的方法，没有返回值。

2.把罐子中糖数量增加5的方法，没有返回值。

3.获得罐子中糖数量的方法，返回值是一个int值。

CallJar类：

main()方法：

用户会输入一个int值，先用Jar类的方法1把罐子中糖的数量设置为这个值。

按格式"糖的数量是{糖的数量}"打印现在糖的数量，并创建一个新的空行。

然后调用Jar类的方法2给糖的数量加五。

最后按格式"现在糖的数量是{新的糖的数量}"打印新的糖的数量，并创建一个新的空行。
 */

import java.util.Scanner;
class Jar {
    
    /*在这里补全Jar类的字段和方法*/
    private int candyNum;
    public void setCandyNum(int num) {
        candyNum = num;
    }
    public void more() {
        candyNum += 5;
    }
    public int getCandyNum() {
        return candyNum;
    }
}    

public class CallJar {
    public static void main(String [] args) {
        
        /*在这里补全CallJar类的字段和方法*/
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        
        Jar myJar = new Jar();
        myJar.setCandyNum(num);
        System.out.println("糖的数量是"+myJar.getCandyNum());
        myJar.more();
        System.out.println("现在糖的数量是"+myJar.getCandyNum());

    }
}