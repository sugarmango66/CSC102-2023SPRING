/*
q5
我们要写一个程序来抽象商店的商品信息，这个程序只包含一个类：Item类（public）。

Item类是public的，它会存储物品的名称和价格，并提供一个打印这些信息的方法。

在Item类的main方法中，我们将根据用户的输入创建Item类的对象，并打印它们。

要求：
Item类：
字段：
字段1：字符串类型，Item名称。
字段2：整数类型，Item价格。
构造器：
构造器有两个参数，会依次赋值给Item的名称和价格。
方法：
有一个用来打印Item的信息的方法。
     -第一行打印Ite名称信息，格式为“名称：{名称}”
     （例如：名称：矿泉水）
     -第二行打印Item价格信息，格式为”价格：{价格}“
main方法：
依次获取用户输入的一个字符串和一个整数。
调用构造器创建一个Item实例myItem，把用户的输入作为两个参数，赋值给myItem的名称和价格。
调用打印myItem的信息。
*/
import java.util.Scanner;;
public class Item {
    private String title = "what";
    private int price = 0;
    public Item(String title, int price) {
        this.title = title;
        this.price = price;
    }
    public void printInfo() {
        System.out.println("商品：" + title);
        System.out.println("价格：" + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String title = sc.next();
        int price = sc.nextInt();
        Item myItem = new Item(title, price);
        myItem.printInfo();
    }
}
