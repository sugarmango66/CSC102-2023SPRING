/*
Q10
 要求：
用户会输入一个int代表树的高度。
调用Tree类的方法，把这个高度赋值给一个Tree类的字段。
用户再输入一个int代表树增长的年数。
调用一个Tree类的方法，计算数在这个年数过后的新的高度。
新的高度计算公式为：10*年数+原高度。
最后调用一个Tree类的方法获取这个新的高度，打印它并创建一个新的空行。
 */
import java.util.Scanner;
class Tree {
    
    /*在这里补全Tree类*/
    private int height;
    public void plant(int num) {
        height = num;
    }
    public void grow(int year) {
        height += year * 10;
    }
    public int getHeight() {
        return height;
    }
    
}

public class CallTree {
    public static void main(String [] args) {
        
        /*在这里补全代码*/
        Scanner scan = new Scanner(System.in);
        int startHeight = scan.nextInt();
        int year = scan.nextInt();
        
        Tree upup = new Tree();
        upup.plant(startHeight);
        upup.grow(year);
        System.out.println(upup.getHeight());
        
        
    }
}