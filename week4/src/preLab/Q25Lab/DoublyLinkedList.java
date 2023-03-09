package preLab.Q25Lab;

import java.util.Scanner;

/*
这个程序会用到双链表的各种插入方法，最后倒序打印新的链表。

把DoublyLinkedList类定义为public。

要求：
Node类：
这是一个数据类型为int的双链表的节点类。

DoublyLinkedList类（public）：
先定义成员变量和构造器。
包含双链表的全部插入方法：append，prepend，insertAfter。
还有一个倒序打印全部节点数据的方法。（每打印一个节点，打印一个空格）
main方法：
获取用户输入的5个int，用它们创建5个节点，并把这些节点依次添加在一个双链表中。
然后对得到的这个新双链表做以下三步操作：
1. 在链表后添加一个数据为100的节点。
2. 在链表前添加一个数据为0的节点。
3. 在这个数据为0的节点后面插入一个数据为999的节点。
做完这些操作后，调用DoublyLinkedList中定义的打印方法，倒序打印新的链表。
 */
public class DoublyLinkedList {
    //成员变量
    private Node head;
    private Node tail;
    //构造器

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    //成员方法
    //末尾插入
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
    //首前插入
    public void prepend(Node newNode) {
        if (head == null)
            append(newNode);
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    //中间插入
    public void insertAfter(Node currNode, Node newNode) {
        //case1 空链表
        if (head == null)
            append(newNode);
        else {
            //case2 非空链表 currNode是tail
            if (currNode == tail)
                append(newNode);
            //case3 非空链表 currNode不是tail
            else {
                Node temp = currNode.next;
                newNode.next = temp;
                temp.prev = newNode;
                currNode.next = newNode;
                newNode.prev = currNode;
            }
        }
    }
    //倒序打印
    public void printList() {
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.elem + " ");
            curr = curr.prev;
        }
    }
    public static void main(String[] args) {
        //获取输入放入链表的节点
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        for (int i = 0; i < 5; i++) {
            doublyLinkedList.append(new Node(sc.nextInt()));
        }
        //1. 在链表后添加一个数据为100的节点。
        doublyLinkedList.append(new Node(100));
        //2. 在链表前添加一个数据为0的节点。
        doublyLinkedList.prepend(new Node(0));
        //3. 在这个数据为0的节点后面插入一个数据为999的节点。
        doublyLinkedList.insertAfter(doublyLinkedList.head, new Node(999));
        //打印链表
        doublyLinkedList.printList();
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
