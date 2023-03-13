package Lab.Q14;
/*
这个程序会包含一个双链表的节点类和一个实现了双端队列的双链表类LinkedDeuqe，
LinkedDeque类中将有我们讲到过的八种双端队列的方法，其中有五种需要根据提示补全。
 */
import java.util.NoSuchElementException;
import java.util.Scanner;

class Node {
    /*
    补全一个双链表的Node类，元素类型是int
     */
    public int data;
    public Node prev;
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
        head = null;
        tail = null;
        length = 0;
    }

    public void pushFront(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;//fix题目代码
            head = newNode;
//            System.out.println(head.next.prev.data); //测试prev是否连上
        }
        length++;
    }

    public void pushBack(int val) {
        /*
        补全pushBack 方法：
        这个方法会在双端队列的队尾添加元素
        参考pushFront
         */
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public int popFront() {
        /*
        补全popFront方法：
        这个方法会在双端队列的队首删除元素
        如果链表为空，捕获一个NoSuchElementException，
        打印"链表为空，并返回-1
        参考popBack
         */
        try {
            if (isEmpty()) {
                throw new NoSuchElementException("链表为空");
            }
            int val = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            else {
                head.prev = null;
            }
            length --;
            return val;
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int popBack() {
        try {
            if (isEmpty()) {
                throw new NoSuchElementException("链表为空");
            }
            int val = tail.data;
            tail = tail.prev;
            if (tail == null){
                head = null;
            }
            else{
                tail.next = null;
            }
            length --;
            return val;
        }
        catch (NoSuchElementException e){
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
            if (isEmpty()) {
                throw new NoSuchElementException("链表为空");
            }
            return tail.data;
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public boolean isEmpty() {
        /*
        补全isEmpty方法：
        这个方法会判断双端队列是否为空：如果是，返回true；
        否则返回false
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
            myDeque.pushBack(val);
        }

        int times = scnr.nextInt();
        for (int j = 0; j < times; j++){
            myDeque.popFront();
        }

        System.out.println(myDeque.peekBack());
//        myDeque.pushFront(10); //测试方法
    }
}
