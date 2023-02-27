/*
这个程序会创建一个存储动物信息的类，和一个继承自这个类的存储狗信息的类，最后创建对象存储并打印信息。

请根据以下指示完成程序。

要求：

Animal类：
有一个String类型的私有字段name，和一个int类型的私有字段age。
公有成员方法1：setName(String nameGiven){...}
公有成员方法2：setAge(int ageGiven){...}
公有成员方法3：printAll(){...}，这个方法会先打印name字段，然后打印一个空格，再打印age字段，然后打印一个空格。（全部在同一行）

Dog类：
Dog类继承Animal类。
有一个独立的int类型私有字段idNum。
成员方法1：setNum(int id){...}
成员方法2：重写方法printAll() 先调用父类的printAll()方法，再在后面打印字段idNum。

Main类（public）:
定义为public类。
定义一个Dog类的对象dog。
使用set方法，把用户输入的一个字符串，一个int，和第二个int分别赋值给字段name，age，和idNum。
最后用dog调用Dog类的printAll方法。
*/
import java.util.Scanner;
class Animal {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void printAll() {
        System.out.print(name + " " + age + " ");
    }
}
class Dog extends Animal {
    private int idNum;
    public void setNum(int id) {
        this.idNum = id;
    }
    @Override
    public void printAll() {
        super.printAll();
        System.out.println(idNum);
    }
}
public class Q11Lab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int age = sc.nextInt();
        int idNum = sc.nextInt();
        Dog dog = new Dog();
        dog.setName(name);
        dog.setAge(age);
        dog.setNum(idNum);
        dog.printAll();
    }
}
