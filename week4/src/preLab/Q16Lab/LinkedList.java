package preLab.Q16Lab;

import java.util.Scanner;

/*
这是一个用于搜索链表的程序。

把LinkedList类定义为public类。

要求：
Node类：
做一个数据类型为int的Node类。
LinkedList类：
成员方法1：search(...){...}，用来搜索链表中是否有目标节点。如果有，返回该节点；如果没有，返回null。
成员方法2：append(...){...}，用来给链表添加元素。
main()方法：
获取用户输入的三个int，调用Node类构造器，依次用这三个int创建三个节点，并按顺序组成一个链表。
再获取用户输入的一个int，作为搜索目标key。
如果key在链表中，打印"找到了"，并创建一个新的空行。
如果key不在链表中，打印"没找到"，并创建一个新的空行。
 */
public class LinkedList {
    //字段
    private Node head;
    private Node tail;
    //初始化空链表
    public LinkedList() {
        head = null;
        tail = null;
    }

    //方法search
    public Node search(int key) {
        //遍历链表
        Node curr = head;
        while (curr != null) {
            if (key == curr.elem)
                return curr;
            curr = curr.next;
        }
        return null;
    }
    //方法append
    public void append(Node newNode) {
        if (head == null)
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
    }
    //main
    public static void main(String[] args) {
        //获取输入 用以创建节点并添加到链表(节点可以是匿名对象)
        int timeInput = 3;
        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < timeInput; i++) {
            linkedList.append(new Node(scanner.nextInt()));
        }
        //创建节点
//        Node node1 = new Node(arr[0]);
//        Node node2 = new Node(arr[1]);
//        Node node3 = new Node(arr[2]);
        //组成链表
//        linkedList.append(node1);
//        linkedList.append(node2);
//        linkedList.append(node3);
        //获取搜索目标
        int key = scanner.nextInt();
        //调用搜索
        if (linkedList.search(key) == null)
            System.out.println("没找到");
        else
            System.out.println("找到了");
    }
}

//节点类
class Node {
    public int elem;
    public Node next;

    public Node(int elem) {
        this.elem = elem;
        this.next = null;
    }
}
