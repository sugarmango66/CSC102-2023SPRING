/*
q3
我们要写一个程序来记录我们吃饭的营养成分（蛋白质和脂肪）。

这个程序包含两个类：1.Meal类；2.SetMeal类（public）。

Meal类可以存储Meal的信息，包括蛋白质和脂肪，并包括打印这些信息的方法。另外还有一个增加蛋白质的方法和一个减少脂肪的方法。

SetMeal类是public类，在这个类的main方法中，我们将会创建Meal类的对象，并根据用户的输入更改这个对象的信息，最后打印出更改后新的信息。

要求：
Meal类：
字段：
字段1：一个整数类型字段protein，代表蛋白质含量。
字段2：一个整数类型字段fat，代表脂肪含量。
构造器：
构造器有两个整数类型参数x和y，依次赋值给对象的protein和fat。
方法：
方法1：用来打印Meal的信息的方法。
     -第一行打印蛋白质信息，格式为“蛋白质：{蛋白质}”
     （例如：蛋白质：10）
     -第二行打印脂肪信息，格式为”脂肪：{脂肪}“
方法2：增加Meal的蛋白质含量的方法。有一个整数类型的参数，方法会给字段1加上这个参数。
方法3：减少Meal的脂肪含量的方法。有一个整数类型的参数，方法会给字段2减去这个参数。

SetMeal类：
main方法：
创建一个Meal的实例myMeal，调用构造器初始化蛋白质含量和脂肪含量分别为30和10。
依次获取用户输入的两个整数。
调用方法，给myMeal的蛋白质含量加上用户输入的第一个整数。
调用方法，给myMeal的脂肪含量减去用户输入的第二个整数。
调用方法，打印当前myMeal的信息。
 */
import java.util.Scanner;
class Meal{
    private int protein = 0;
    private int fat = 0;
    public Meal(int x, int y) {
        this.protein = x;
        this.fat = y;
    }

    public void printInfo() {
        System.out.println("蛋白质：" + protein);
        System.out.println("脂肪：" + fat);
    }
    public void addProtein(int num) {
        this.protein += num;
    }
    public void subFat(int num) {
        this.fat -= num;
    }

}
public class setMeal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int proteinAdd = sc.nextInt();
        int fatSub = sc.nextInt();

        Meal myMeal = new Meal(30, 10);
        myMeal.subFat(fatSub);
        myMeal.addProtein(proteinAdd);
        myMeal.printInfo();
    }
}

