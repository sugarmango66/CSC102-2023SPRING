package LinkedListAdvance.deleteKey;
/*
这个程序会获取用户输入的一个int（代表目标）和一个单链表，程序中的deleteKey方法会删除链表中所有节点数据为目标的元素。

比如如果目标为5，链表为1 -> 5 -> 3 -> 5 -> 7，那么调用方法后链表就会变成1 -> 3 -> 7。
 */

import java.util.Scanner;

class Node{
    public int data;
    public Node next;

    public Node(int val){
        data = val;
        next = null;
    }
}

public class LinkedList{
    private Node head;
    private Node tail;

    public LinkedList(){
        head = null;
        tail = null;
    }

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

    public void deleteKey(int key){
        /*
        在这里补全deleteKey类，它会删除链表中所有值为key的节点
        */
        //当非空链表的head匹配目标 删除原head 直到head不匹配
        while (head != null && head.data == key) {
            head = head.next;
        }

        //head处理完的前提下 对非空链表才操作
        if (head != null) {
            Node curr = head;
            while (curr.next != null) {
                //curr.next不匹配目标 则curr后移
                if (curr.next.data != key)
                    curr = curr.next;
                else {
                    //当遇到目标匹配值，连续对比直到不匹配
                    while (curr.next != null && curr.next.data == key) {
                        curr.next = curr.next.next;
                    }
                }
            }
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        LinkedList myList = new LinkedList();
        int key = scnr.nextInt();
        while(scnr.hasNextInt()){
            int val = scnr.nextInt();
            myList.add(val);
        }
        scnr.close();
        myList.deleteKey(key);
        myList.print();
        System.out.println("完成");
    }
}
