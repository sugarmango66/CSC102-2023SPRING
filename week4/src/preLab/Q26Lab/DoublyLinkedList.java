package preLab.Q26Lab;

import java.util.Scanner;

/*
这是一个用于搜索双链表的程序。

把DoublyLinkedList类定义为public类。

要求：
Node类：
做一个数据类型为int的双链表Node类。

DoublyLinkedList类：
成员方法1：search(...){...}，用来搜索双链表中是否有目标节点。如果有，返回该节点；如果没有，返回null。
成员方法2：append(...){...}，用来给双链表添加元素。
main()方法：
获取用户输入的五个int，调用Node类构造器，依次用这五个int创建五个节点，并按顺序组成一个双链表。
再获取用户输入的一个int，作为搜索目标key。
如果key在链表中，打印"找到了"，并创建一个新的空行。
如果key不在链表中，打印"没找到"，并创建一个新的空行。
 */
public class DoublyLinkedList {
    //成员变量
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    //成员方法
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
    public Node search(int key) {
        Node curr = tail;
        while (curr != null) {
            if (curr.elem == key)
                return curr;
            curr = curr.prev;
        }
        return null;
    }
    public static void main(String[] args) {
        //获取输入放入链表的节点
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        for (int i = 0; i < 5; i++) {
            dll.append(new Node(sc.nextInt()));
        }
        //获取搜索目标
        int key = sc.nextInt();
        if (dll.search(key) == null)
            System.out.println("没找到");
        else System.out.println("找到了");
    }
}

class Node {
    public int elem;
    public Node next;
    public Node prev;

    public Node(int elem) {
        this.elem = elem;
    }
}