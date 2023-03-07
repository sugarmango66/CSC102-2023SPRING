package preLab;

import java.util.Scanner;

/*
我们要编一个链表存储学科的信息；其中需要用Node类和Subject类，做一些简单的操作，帮助我们更好地理解Node类。

Node类是Linkedlist的节点类，包含了指向下一个节点的指针，以及一个subject类data，用于储存学科数据。
主程序会获取用户输入的两行数据，并新建两个节点，第一个指向第二个，而节点内的Subject包含用户输入相应科目的名称。

把Subject类定义为public。

要求：
Node类：
公有成员变量1：一个类型为Subject的变量data，代表节点存放的数据。
公有成员变量2：一个类型为Node的变量next，代表下一个节点。
构造器：构造器会依次获取两个参数，分别为Subject类和Node类，然后赋值给上面规定的两个成员变量。

Subject类（public）：
私有成员变量1：一个类型为String的变量name，代表学科名称。
构造器：构造器会获取一个String类型参数传给成员变量name。
公有成员方法1：printName(){...}，这个方法是一个打印方法，返回值为空。
它会打印“我在学习 + {学科名称name}”，比如如果某个对象的name字段是”Java“，调用该方法则打印”我在学习Java“。
main方法：
获取用户输入的两个String类型输入，并分别用它们作为参数调用构造器创建两个Subject类对象。
把这两个对象分别作为Node的elem参数，null作为next参数，用构造器创建两个Node，第一个叫head，第二个叫tail。
然后把head的next变量改为tail。
做一个循环，循环从head开始：如果当前节点不为null时，调用该节点的elem的printName方法；如果当前节点为null，退出循环。
 */
public class Q11Lab {
    public static void main(String[] args) {
        //获取输入
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        //创建Subject对象
        Subject subject1 = new Subject(input1);
        Subject subject2 = new Subject(input2);
        //创建Node对象
        Node head = new Node(subject1, null);
        Node tail = new Node(subject2, null);
        //head的下一个节点指向tail
        head.next = tail;
        //通过循环调用全部节点的printName方法
        Node current = head;
        while (current != null) {
            current.data.printName();
            current = current.next;
        }

    }
}
class Subject {
    private String name;

    public Subject(String name) {
        this.name = name;
    }
    public void printName() {
        System.out.println("我在学习" + name);
    }
}
class Node {
    public Subject data;
    public Node next;

    public Node(Subject data, Node next) {
        this.data = data;
        this.next = next;
    }
}
