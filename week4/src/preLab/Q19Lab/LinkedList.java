package preLab.Q19Lab;

import java.util.Scanner;

/*
这是一个用于删除链表节点的程序。

要求：
Node类：
做一个数据类型为int的Node类。

LinkedList类：
成员方法1：removeAfter(...){...}，用来删除链表元素。
成员方法2：append(...){...}，用来给链表添加元素。
成员方法3：printList(){...}，用来打印链表，打印的是节点的数据，每打印一个节点，打印一个空格。
main()方法：
获取用户输入的三个int，调用Node类构造器，依次用这三个int创建三个节点，并按顺序组成一个链表。
用removeAfter方法删除第一个链表节点。
调用printList方法，打印更改后新的链表。
 */
public class LinkedList {
    private Node head;
    private Node tail;
    //构造器
    public LinkedList() {
        head = null;
        tail = null;
    }
    //方法removeAfter
    /*
    情况1：currNode是null，同时链表的head不是null ->删除head

        情况1.1：head.next不是null ->tail不变

        情况1.2：head.next是null ->tail改变

    情况2：currNode是null，同时链表的head也是null ->无需操作

    情况3：如果currNode不是null，说明我们要删除的节点不在开头，那么这又分为两种情况：

        情况3.1：currNode.next存在

                情况3.1.1：currNode.next是tail ->去尾巴 tail改变

                情况3.1.2：currNode.next不是tail ->去中间 tail不变

        情况3.2：currNode.next不存在 ->无需操作
     */
    public void removeAfter(Node currNode) {
        if (currNode == null && head != null){
            if (head.next != null)
                head = head.next;
            else {
                head = null;
                tail = null;
            }
        }

        if (currNode != null && currNode.next != null) {
            if (currNode.next == tail) {
                tail = currNode;
                currNode.next = null;
            }
            else {
                currNode.next = currNode.next.next;
            }
        }
    }
    //方法append
    public void append(Node newNode) {
        if (head == null)
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
    }
    //方法printList
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.elem + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        //获取输入创建链表
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 3; i++) {
            linkedList.append(new Node(scanner.nextInt()));
        }
        //调用removeAfter方法删除首节点
        linkedList.removeAfter(null);
        //调用printList
        linkedList.printList();
    }

}
class Node {
    public int elem;
    public Node next;

    public Node(int elem) {
        this.elem = elem;
        this.next = null;
    }
}
