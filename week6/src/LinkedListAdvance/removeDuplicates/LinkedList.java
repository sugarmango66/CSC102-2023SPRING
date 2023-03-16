package LinkedListAdvance.removeDuplicates;
/*
删除链表中重复的结点。

用户会给出的一个升序排列好的单链表，请补全removeDuplicates方法，使得程序可以删除链表中重复的节点。

比如，如果用户给出的链表是 1 -> 2 -> 2 -> 3 -> 4 -> 4，
那么removeDuplicates方法可以把它改为 1 -> 2 -> 3 -> 4。如果链表为空或只有一个节点，则方法不会更改链表。
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

    public void removeDuplicate(){
        /*
        在这里补全removeDuplicate方法，这个方法会删除链表中重复出现的元素。
        */
        //链表有2个及以上节点才操作
        if (head != null && head.next != null) {
            Node curr = head;
            while (curr.next != null) {
                //对比curr和下一个节点值是否相等
                if (curr.data != curr.next.data) {
                    //不相等则curr后移
                    curr = curr.next;
                }
                else {
                    //相等则连续对比、删除重复节点 直到遇到不相等
                    while (curr.next != null && curr.data == curr.next.data) {
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
        while(scnr.hasNextInt()){
            int val = scnr.nextInt();
            myList.add(val);
        }
        scnr.close();
        myList.removeDuplicate();
        myList.print();
        System.out.println("完成");
    }
}
