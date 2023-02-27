import java.util.Scanner;

/*
 * 这个代码会创建一个Dog类，使它可以根据平均体型进行比较。在一个用于比较三个对象的泛型类中，创建三个对象，并打印出比较得出的最大的Dog对象的名字。

要求：

Dog类：
这个类要实现Comparable接口。
私有字段1：String类型字段species，代表Dog的品种。
私有字段2：int类型字段avgSize，代表Dog的平均大小。
构造器：构造器依次有两个参数，String类参数s，和int类参数a。s会被赋值给species字段，a会被赋值给avgSize字段。
重写方法CompareTo()：
如果当前对象的age比被比较对象大，返回1；比被比较对象小，返回-1；相等返回0。
重写方法toString()：
返回name字段。

Main类：
定义为public。
泛型方法chooseItem()：定义一个类型参数 T，用类型限界规定 T 必须是实现了Comparable类的类。
方法返回值类型是T，有三个T类型的参数。调用compareTo()方法，找出三个参数中最大的一个并返回它。
main()方法：
依次获取用户的三组输入，每一组输入由一个String和一个int构成，代表的是狗的品种和平均体重。
用这三组输入创建三组Dog类对象，调用chooseItem方法，打印方法调用的结果，并创建一个新的空行。
 */
public class Q4main {
    public static void main(String[] args) {
        //获取3组输入，用以创建对象
        Scanner sc = new Scanner(System.in);

        Dog dog1 = new Dog(sc.next(), sc.nextInt());
        Dog dog2 = new Dog(sc.next(), sc.nextInt());
        Dog dog3 = new Dog(sc.next(), sc.nextInt());
        //调用泛型方法
        Dog res = chooseItem(dog1, dog2, dog3);
        System.out.println("体型最大的狗的品种是" + res);

    }
    //定义泛型方法-找到最大比较结果
    public static <T extends Comparable<T>> T chooseItem(T a, T b, T c) {
        T maxVal = a;
        // if (b.compareTo(maxVal) > 0) {
        //     maxVal = b;
        // }
        // if (c.compareTo(maxVal) > 0) {
        //     maxVal = c;
        // }
        maxVal = b.compareTo(maxVal) > 0 ? b : maxVal;
        maxVal = c.compareTo(maxVal) > 0 ? c : maxVal;
        return maxVal;
    }
}

//编写Dog类
class Dog implements Comparable<Dog>{
    //私有字段
    private String species;
    private int avgSize;
    //构造器
    public Dog(String s, int a) {
        this.species = s;
        this.avgSize = a;
    }
    //重写compareTo
    @Override
    public int compareTo(Dog other) {
        if (this.avgSize > other.avgSize) {
            return 1;
        }
        else if (this.avgSize < other.avgSize) {
            return -1;
        }
        else return 0;
    }
    //重写toString
    @Override
    public String toString() {
        return this.species;
    }

}
