/*q2
按要求补全代码。

我们要写一个程序来抽象化星巴克顾客喝咖啡。咖啡杯里最开始会有200毫升咖啡，每次续杯可以续50毫升；用户设置自己的咖啡类型，也可以输入自己想喝的数量，如果超过了余量会提示“不够”，否则会提示剩余咖啡的数量。

这个程序包含两个类：1. Coffee类；2. DrinkCoffee类（public）。

Coffee类可以存储Coffee类对象的信息，包括剩余的咖啡量和咖啡的名字；也提供给修改或打印这些信息的方法。

DrinkCoffee类是public类，其中的main方法中，我们会创建新的Coffee类对象，并根据用户的输入对这个对象的值进行特定操作。

要求：
Coffe类：
字段：
字段1：一个整数字段，代表剩余的咖啡的毫升量，初始值为200。
字段2：一个字符串字段，代表咖啡的名字，没有初始值。
方法：
方法1：一个打印咖啡信息的方法。会按照“{咖啡名字} + ”还有“ + {剩余的咖啡} + “毫升”“的格式打印。
（例如：拿铁还有200毫升）
方法2：一个增加剩余咖啡的方法。会给字段1添加50。
方法3：一个设置Coffe的名字的方法。有一个String类型参数，会把字段2设置为该参数。
方法4：喝咖啡的方法。有一个int类型的参数，代表被喝掉的咖啡的毫升量。情况（1）：如果当前剩余的咖啡（字段1）大于或等于这个量，给剩余的咖啡量减去这个参数，然后调用方法1打印出当前咖啡信息；情况（2）：如果剩余咖啡小于这个参数，不要改变剩余咖啡量，并打印“不够”，并创建一个新的空行。

DrinkCoffee类：
main方法：
创建一个Coffee类的对象myCoffee，并对这个对象进行以下操作：
从用户的输入中依次读取一个字符串和一个整数。
步骤1：调用方法把myCoffee的名字设置为用户输入的字符串
步骤2：调用方法实现喝掉myCoffee中指定毫升量（用户输入的整数）咖啡这一操作。
步骤3：调用方法实现给myCoffee的剩余咖啡增加50毫升的操作。
步骤4：调用方法打印当前myCoffee的信息

 */
import java.util.Scanner;
class Coffee{
    private int volume = 200;
    private String type;
    

    //constructor
    // public Coffee(String type, int volume) {
    //     this.type = type;
    //     this.volume = volume;
    // }
    // public Coffee(String type) {
    //     this(type, 200);
    // }
    public Coffee() {
    }

    //setter and getter
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getVolume() {
        return this.volume;
    }

    public void printInfo() {
        System.out.println(type + "还有" + volume + "毫升");
    }
    public void refill() {
        this.volume += 50;
    }
    public void drink(int consume) {
        if (consume <= volume) {
            this.setVolume(volume - consume);
            this.printInfo();
        }
        else System.out.println("不够");
    }
    
}

public class DrinkCoffee{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.next();
        int consume = sc.nextInt();
        Coffee myCoffee = new Coffee();
        myCoffee.setType(type);
        myCoffee.drink(consume);
        myCoffee.refill();
        myCoffee.printInfo();
    }
}