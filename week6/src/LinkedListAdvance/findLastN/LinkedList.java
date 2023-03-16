package LinkedListAdvance.findLastN;
/*
（附加题）找出倒数第n个节点的值。

这个程序会获取用户输入的一个int代表目标n，和一个单链表，补全find方法找出单链表倒数第n个节点的值，
这个方法会返回这个节点值。

比如如果n是2，链表是1 -> 2 -> 3 -> 4 -> 5，那么find方法就会返回倒数第二个节点的值，也就是4。

假设n一定大于0且小于或等于链表长度，链表不为空。
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

    public int find(int n){
        /*
        在这里补全find方法
        */
        //取得总节点数
        int size = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        //倒数n即为正数size-n(base 0)
        curr = head;
        for (int i = 0; i < size - n; i++) {
            curr = curr.next;
        }
        return curr.data;
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
        int result = myList.find(key);
        System.out.println(result);
        System.out.println("完成");
    }
}
