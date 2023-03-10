package preLab.Q30Lab;

import java.util.Scanner;

/*
我们现在已经会用递归方法来正向打印链表，这个程序会使用递归倒序打印一个单链表。

把LinkedList类定义为public。

要求：
Node类：
定义一个数据类型为int的单链表Node类。

LinkedList（public）：
方法1：单链表的append方法。
方法2：单链表的递归遍历打印方法，这个方法会打印出倒序的单链表节点数据，每打印一个节点，打印一个空格。
main方法：
获取用户输入的三个int，调用Node类构造器，依次用这三个int创建三个节点，并按顺序组成一个单链表。
调用方法2，倒序打印出这三个节点数据。
 */
public class LinkedList {
    //字段
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    //方法append
    public void append(Node newNode) {
        if (head == null)
            head = newNode;
        else tail.next = newNode;
        tail = newNode;
    }
    //方法递归遍历 倒序打印
    public void traverseList (Node node) {
        //base
        if (node == null)
            return;
        //调用自身
        traverseList(node.next);
        System.out.print(node.elem + " ");
    }
    public static void main(String[] args) {
        //获取输入放入链表的节点
        Scanner sc = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 3; i++) {
            linkedList.append(new Node(sc.nextInt()));
        }
        linkedList.traverseList(linkedList.head);
    }
}
class Node {
    public int elem;
    public Node next;

    public Node(int elem) {
        this.elem = elem;
    }
}
