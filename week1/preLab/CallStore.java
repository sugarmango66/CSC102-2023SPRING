/*要求：
Store类：
字段：
1.商店名字name（字符串） 2.商店评分rating（整数）3.商店成立年份yearEstablished（整数）
这三个字段在类定义中分别被赋值为 "未定"、-1 和 -1。
方法：
包含三个设置字段值的方法（setName、setRating 和 setYearEstablished）和一个打印字段值的方法（print）。 
打印方法会按顺序打印name，rating，和yearEstablished，并在每两个值之间打印一个逗号和一个空格，这个打印会创建一个新的空行。

 CallStore类：
main 方法：
创建一个新的 Store 对象。
打印一行"默认值: "，并创建一个新的空行。
调用Store类的 print 方法输出商店的默认值。
然后从用户的输入中依次读取商店的名称、评分和成立年份，并使用设置方法将这些值赋给 Store 对象。
打印一行"修改后: "，并创建一个新的空行。
最后，再次调用 print 方法输出修改后的商店信息。
 */
import java.util.Scanner;
class Store {
    
    /*在这里补全代码*/
    private String name = "未定";
    private int rating = -1;
    private int yearEstablished = -1;

    public void setName(String inputName) {
        name = inputName;
    }
    public void setRating(int inputRating) {
        rating = inputRating;
    }
    public void setYearEstablished(int inputYearEstablished) {
        yearEstablished = inputYearEstablished;
    }
    public void print() {
        System.out.println(name + ", " + rating + ", " + yearEstablished);
    }
    
}

public class CallStore {
    public static void main (String[] args) {
        
        /*在这里补全CallStore类*/
        Store myStore = new Store();
        System.out.println("默认值:");
        myStore.print();

        Scanner scan = new Scanner(System.in);
        String storeName = scan.next();
        int rating  = scan.nextInt();
        int startYear = scan.nextInt();
        
        myStore.setName(storeName);
        myStore.setRating(rating);
        myStore.setYearEstablished(startYear);
        System.out.println("修改后:");
        myStore.print();
    }
}