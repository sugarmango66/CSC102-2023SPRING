package preLab.Q22Lab;

import java.util.Scanner;

/*
下面这个程序中我们会用到双链表。在双链表中添加节点，并倒序打印。重点是双链表的append方法和倒序打印的方法。

定义Sweet类为public类。

要求：
Node类：
写出双链表的Node类，要包括Sweet类数据data，Node类数据prev（代表向前的指针），和Node类数据next。

DoublyLinkedList类：
该类的成员变量和构造器与单链表的没有区别，但注意以下两个方法：
公有方法1：append(...){...}，给双链表末尾添加节点的方法。
因为是双链表，所以添加节点时要注意把新节点的prev改成原来的tail。
公有方法2：printList(...){...}，倒序遍历链表，并对每个节点调用Sweet类的打印方法。

Sweet类（public）：
私有字段1：String name，代表甜品名称。
私有字段2：int calories，代表甜品热量。
构造器：这个构造器有两个参数，依次分别对应上面的两个字段。
公有方法1：一个打印方法，会打印：“{name} + 的热量是 + {calories}"。比如：芝士蛋糕的热量是400。
main方法：
创建一个DoublyLinkedList类的对象myList。
获取用户的三组输入，每组输入为一个String + 一个int。
用这三组输入调用构造器创建出三个Sweet对象，并用三个对象作为Node的数据创建三个Node。
把上面创建的三个Node依次加入myList。
调用DoublyLinkedList的打印方法，打印myList。
 */
public class Sweet {
    //字段
    private String name;
    private int calories;

    public Sweet(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
    public void print() {
        System.out.println(name + "的热量是" + calories);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //创建链表
        DoublyLinkedList myList = new DoublyLinkedList();
        //添加节点
        for (int i = 0; i < 3; i++) {
            myList.append(new Node(new Sweet(sc.next(), sc.nextInt())));
        }
        //调用printList方法
        myList.printList();
    }
}
class Node {
    public Sweet data;
    public Node prev;
    public Node next;

    public Node(Sweet data) {
        this.data = data;
    }
}
class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    public void append(Node newNode) {
        if (head == null) {
            head = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }
    //倒序遍历链表，并对每个节点调用Sweet类的打印方法
    public void printList() {
        Node curr = tail;
        while (curr != null) {
            curr.data.print();
            curr = curr.prev;
        }
    }
}

