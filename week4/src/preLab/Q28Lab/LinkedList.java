package preLab.Q28Lab;

import java.util.Scanner;

/*
这是一个用于删除双链表节点的程序。

把LinkedList类定义为public。

要求：
Node类：
做一个数据类型为int的双链表Node类。

LinkedList类（public）：
成员方法1：remove(...){...}，用来删除链表元素。
成员方法2：append(...){...}，用来给链表添加元素。
成员方法3：printList(){...}，用来倒序打印链表，打印的是节点的数据，每打印一个节点，打印一个空格。
main()方法：
获取用户输入的三个int，调用Node类构造器，依次用这三个int创建三个节点，并按顺序组成一个双链表。
用remove方法删除第一个链表节点。
调用printList方法，倒序打印更改后新的链表。

 */
public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }
    public void remove(Node currNode) {
        //sucNode如果存在，sucNode.prev应该怎么改？
        //predNode如果存在，predNode.next应该怎么改？
        //如果删除了head，新的head是什么？
        //如果删除了tail，新的tail是什么？
        Node sucNode = currNode.next;
        Node predNode = currNode.prev;
        //前后空
        if (sucNode == null && predNode == null) {
            head = null;
            tail = null;
        }
        //后空 即删除tail
        if (sucNode == null && predNode != null) {
            tail = predNode;
            tail.next = null;
        }
        //前空 即删除head
        if (predNode == null && sucNode != null) {
            head = sucNode;
            head.prev = null;
        }
        //前后均非空
        if (sucNode != null && predNode != null) {
            predNode.next = sucNode;
            sucNode.prev = predNode;
        }

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
    public void printList() {
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.elem + " ");
            curr = curr.prev;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 3; i++) {
            linkedList.append(new Node(sc.nextInt()));
        }
        //调用remove
        linkedList.remove(linkedList.head);
        //打印链表
        linkedList.printList();
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

