package Lab.Q12;

import java.util.NoSuchElementException;
import java.util.Scanner;
/*
这个程序会包含一个单链节点类和一个实现了双端队列的链表类LinkedDeque，
链表类中将有我们讲到过的八种双端队列的方法，其中有五种需要根据提示补全。
 */
class Node {
    /*
    补全一个单链表的Node类
     */
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedDeque {
    /*
    三个字段：
    Node head 代表队首
    Node tail 代表队尾
    int length 代表队列长度

    一个无参构造器
     */
    private Node head;
    private Node tail;
    private int length;

    public LinkedDeque() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void enqueueFront(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void enqueueBack(int val) {
        /*
        补全enqueueBack 方法：
        这个方法会在双端队列的队尾添加元素
        参考enqueueFront
         */
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public int dequeueFront() {
        /*
        补全dequeueFront方法：
        这个方法会在双端队列的队首删除元素，
        并返回元素值
        如果链表为空，捕获一个NoSuchElementException，
        打印"链表为空，并返回-1
         */
        try {
            if (isEmpty())
                throw new NoSuchElementException("链表为空");
            //链表不为空
            Node temp = head;
            if (head.next == null) {
                head = null;
                tail = null;
            }
            else {
                head = head.next;
            }
            length--;
            return temp.data;
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    public int dequeueBack() {
        /*
        补全dequeueBack 方法：
        这个方法会在双端队列的队尾删除元素，
        并返回元素值
        如果链表为空，捕获一个NoSuchElementException，
        打印"链表为空，并返回-1
         */
        try {
            if (isEmpty())
                throw new NoSuchElementException("链表为空");
            //链表不为空
            Node temp = tail;
            if (head.next == null) {
                head = null;
                tail = null;
            }
            else {
                //定位tail的上一个节点
                Node curr = head;
                while (curr.next != tail)
                    curr = curr.next;

                tail = curr;
                tail.next = null;
            }
            length--;
            return temp.data;
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int peekFront() {
        try {
            if (isEmpty()) {
                throw new NoSuchElementException("链表为空");
            }
            return head.data;
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int peekBack() {
        /*
        补全peekBack方法：
        这个方法会获取双端队列的尾部元素，但不修改队列
        如果链表为空，捕获一个NoSuchElementException，
        打印"链表为空，并返回-1
        参考peekFront方法
         */
        try {
            if (isEmpty())
                throw new NoSuchElementException("链表为空");
            return tail.data;
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public boolean isEmpty() {
        /*
        补全isEmpty方法：
        这个方法会判断双端队列是否为空：如果是，返回true；否则返回false
         */
        return head == null;
    }

    public int getLength() {
        /*
        这个方法会返回双端队列的长度
         */
        return length;
    }

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        LinkedDeque myDeque = new LinkedDeque();
        for (int i = 0; i < 5; i++){
            int val = scnr.nextInt();
            myDeque.enqueueBack(val);
        }

        int times = scnr.nextInt();
        for (int j = 0; j < times; j++){
            myDeque.dequeueFront();
        }

        System.out.println(myDeque.peekBack());
    }
}
