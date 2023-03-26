package LinkedListAdvance.reverse;
/*
代码练习一：反转链表

这个程序会把用户输入的数字依次存入一个链表，最后反转链表并打印。

把LinkedList类定义为public。

要求：
Node类：
创建一个单链表的Node类，元素类型是int。

LinkedList类：
字段1：Node head，代表链表的头部节点。
字段2：Node tail，代表链表的尾部节点。
构造器：一个无参构造器。
方法1：写一个给链表添加元素的方法add，无返回值，参数类型是一个int。
方法2：写一个反转链表的方法reverse，无返回值，无参数。
比如1 -> 2 ->3这个链表反转后就会变成3 -> 2 -> 1，并且head和tail也会更新。
如果链表为空或者只有一个节点，那么链表无变化。
方法3：打印链表的方法print，每打印一个节点的数据就打印一个空格。
 */

import java.util.ArrayList;
import java.util.Scanner;

class Node {
    /*
    在这里补全单链表的Node类，节点的数据类型是int。
    */
    public int elem;
    public Node next;

    public Node(int elem) {
        this.elem = elem;
        this.next = null;
    }
}

public class LinkedList {
    /*
    在这里补全LinkedList类
    */
    //字段
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    //方法add
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void reverse() {
        //update after Jasmine讲解
//        Node newTail = head;
        Node reversedListHead = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = reversedListHead;
            reversedListHead = curr;
            curr = temp;
        }
        tail = head;
        head = reversedListHead;


        //借鉴gpt
//        if (head == null || head.next == null) {
//            return;
//        }
//        Node prev = null;//代表curr原来的上一个节点
//        Node current = head;
//        Node next = null;//储存curr原来的下一个节点
//        while (current != null) {
//            next = current.next;//保存原curr.next到临时变量 因为要断掉原指向
//            current.next = prev;//改变curr的指向 即反转
//            prev = current;//后移一个节点 以便循环
//            current = next;//后移一个节点 以便循环
//        }
//        tail = head;
//        head = prev;

//        //方法reverse——借助动态数组的绕道写法
//        ArrayList<Integer> arr = new ArrayList<>();
//        //依次取出节点值 存入arr
//        Node curr = head;
//        while (curr != null) {
//            arr.add(curr.elem);
//            curr = curr.next;
//        }
//        //清空链表 倒序加入arr元素
//        head = null;
//        for (int i = arr.size()-1; i >= 0; i--) {
//            add(arr.get(i));
//        }
    }

    public void print() {
        //方法print
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.elem + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        LinkedList myList = new LinkedList();
        while (scnr.hasNextInt()) {
            int val = scnr.nextInt();
            myList.add(val);
        }
        scnr.close();
        myList.reverse();
        myList.print();
        System.out.println("完成");
    }
}
