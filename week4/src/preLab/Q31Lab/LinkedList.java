package preLab.Q31Lab;

import java.util.Scanner;

/*
这个程序也会用到单链表的递归遍历，但这次我们要用递归做一个查找的操作。

把LinkedList类定义为public。

要求：
Node类：
定义一个数据类型为int的单链表Node类。

LinkedList类（public）：
方法1：单链表的append方法。
方法2：search(...){...}，这个方法的参数是一个head节点，和一个int类的搜索目标。
方法会用递归方法遍历链表，查找目标是否在链表中。如果在，返回与之匹配的节点；如果不在，返回null。
main方法：
获取用户输入的三个int，调用Node类构造器，依次用这三个int创建三个节点，并按顺序组成一个单链表。
再获取用户输入的一个int，作为搜索目标key。
调用方法2，用链表的head和key作为参数，搜索key是否在链表中。
如果在，打印"找到了"；如果不在，打印"没找到"。
 */
public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }
    //方法 添加节点
    public void append(Node newNode) {
        if (head == null)
            head = newNode;
        else tail.next = newNode;
        tail = newNode;
    }
    //方法 查找
    public Node search(Node head, int key) {
        //base
        if (head == null)
            return null;
        if (head.elem == key)
            return head;
        return search(head.next, key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 3; i++) {
            linkedList.append(new Node(sc.nextInt()));
        }
        //搜索目标
        int key = sc.nextInt();
        Node searchRes = linkedList.search(linkedList.head, key);
        if (searchRes == null)
            System.out.println("没找到");
        else System.out.println("找到了");
    }

}
class Node {
    public int elem;
    public Node next;

    public Node(int elem) {
        this.elem = elem;
    }
}
