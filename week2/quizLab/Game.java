/*
q1
这个程序只包含一个类：Game类（public）。

Game是public类，是一个猜数字的游戏，正确答案是22。

程序会根据用户输入的数字给出提示，直到用户猜出正确答案为止。

要求：
Game类：
包含main方法
打印”请猜测数字“，并创建一个空行（注意，这句话只会被打印一次）。
用一个循环完成以下操作：
获取用户输入的一个整数变量。
情况1：如果用户输入的数字大于22，则打印“大了”，并创建一个新的空行；
情况2：如果小于22，则提示“小了”，并创建一个新的空行；
情况3：如果等于22，则提示“猜对了”，跳出循环。
这个循环会一直要求用户输入数字，直到用户输入的值等于22为止。
 */
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int guess = -1;
        int answer = 22;
        System.out.println("请猜测数字");
        while (guess != answer) {
            guess = sc.nextInt();
            if (guess < answer) {
                System.out.println("小了");
            }
            else if (guess > answer) {
                System.out.println("大了");
            }
            else System.out.println("猜对了");
        }
    }
}
