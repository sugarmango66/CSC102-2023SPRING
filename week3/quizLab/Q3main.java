import java.util.ArrayList;
import java.util.Scanner;

/*
 * 这个代码会创建一个Person类，使它可以根据年龄进行比较。在一个用于比较三个对象的泛型类中，创建三个对象，并打印出比较得出的最小的Person对象的名字。

要求：

Person类：
这个类要实现Comparable接口。
私有字段1：String类型字段name，代表Person的名字。
私有字段2：int类型字段Age，代表Person的年龄。
构造器：构造器依次有两个参数，String类参数n，和int类参数a。n会被赋值给name字段，a会被赋值给age字段。
重写方法CompareTo()：
如果当前对象的age比被比较对象大，返回1；比被比较对象小，返回-1；相等返回0。
重写方法toString()：
返回name字段。

Main类：
定义为public。
泛型方法chooseItem()：定义一个类型参数 T，用类型限界规定 T 必须是实现了Comparable类的类。方法返回值类型是T，有三个T类型的参数。调用compareTo()方法，找出三个参数中最小的一个并返回它。
main()方法：
依次获取用户的三组输入，每一组输入由一个int和一个String构成，代表年龄和名字。
用这三组输入创建三组Person类对象，调用chooseItem方法，打印方法调用的结果，并创建一个新的空行。
 */
public class Q3main {
    public static void main(String[] args) {
        //获取3组输入, 用以创建对象
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> persons = new ArrayList<>();
        
        for (int i = 0; i < 3; ++i) {
            int age = sc.nextInt();
            String name = sc.next();
            persons.add(new Person(name, age));
        }
        
        Person p0 = persons.get(0);
        Person p1 = persons.get(1);
        Person p2 = persons.get(2);
        //调用泛型方法
        Person res = chooseItem(p0, p1, p2);
        System.out.println("最小的对象是" + res);
    }
    //泛型方法-找出最小值
    /*
    1、！！泛型方法签名的语法形式：
    <参数类型> returnType methodName()
    2、<T extends Comparable<T>> 是type bound
    */
    public static <T extends Comparable<T>> T chooseItem(T a, T b, T c) { 
        T minVal = a;
        minVal = b.compareTo(minVal) < 0 ? b : minVal;
        minVal = c.compareTo(minVal) < 0 ? c : minVal;
        return minVal;
    }
}


class Person implements Comparable<Person> {
    //私有字段
    private String name;
    private int age;
    //构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //重写方法
    @Override
    public int compareTo(Person other) {
        // TODO Auto-generated method stub
        if(this.age > other.age) {
            return 1;
        }
        else if (this.age < other.age) {
            return -1;
        }
        else return 0;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }
}
