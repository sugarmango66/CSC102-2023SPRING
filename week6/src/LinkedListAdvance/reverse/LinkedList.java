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

class Node{
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
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    //方法删除返回tail
//    public int removeLast() {
//        Node temp = tail;
//        if (head.next == null) {
//            head = null;
//            tail = null;
//        }
//        else {
//            Node curr = head;
//            while (curr.next != tail)
//                curr = curr.next;
//            tail = curr;
//            tail.next = null;
//        }
//        return temp.elem;
//    }

//    public void reverse() {
//        LinkedList res = new LinkedList();
//        //依次将尾部节点add到新链表
//        while (head != null) {
//            res.add(removeLast());
//        }
//        //原链表已清空，依次加入反转后的节点
//        Node resCurr = res.head;
//        while (resCurr != null) {
//            add(resCurr.elem);
//            resCurr = resCurr.next;
//        }
//    }
    public void reverse() {
        //方法reverse
        ArrayList<Integer> arr = new ArrayList<>();
        //依次取出节点值 存入arr
        Node curr = head;
        while (curr != null) {
            arr.add(curr.elem);
            curr = curr.next;
        }
        //清空链表 倒序加入arr元素
        head = null;
        for (int i = arr.size()-1; i >= 0; i--) {
            add(arr.get(i));
        }
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

    public static void main (String[] args){
        Scanner scnr = new Scanner(System.in);
        LinkedList myList = new LinkedList();
        while(scnr.hasNextInt()){
            int val = scnr.nextInt();
            myList.add(val);
        }
        scnr.close();
        myList.reverse();
        myList.print();
        System.out.println("完成");
    }
}
