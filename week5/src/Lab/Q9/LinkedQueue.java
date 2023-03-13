package Lab.Q9;

import java.util.NoSuchElementException;
import java.util.Scanner;

/*
这题中的代码和上一题类似，都是在链表中实现队列，区别是换成使用双链表结构，
因此，一些方法和成员变量都会发生相应的改变。

方法：

enqueue
dequeue
peek
 */
class Node {
    /*
    写出双链表的Node类
    要包含三个字段：int dat（代表数据）;
    Node prev（前指针）; Node next（后指针）
    还要有一个构造器
     */
    public int dat;
    public Node prev;
    public Node next;

    public Node(int dat) {
        this.dat = dat;
        this.prev = null;
        this.next = null;
    }
}

public class LinkedQueue {
    /*
    补全这个双链表类
    要包括题目中要求的全部的方法
    注意使用双链表时，要注意必要时更新节点的prev*/
    //字段
    private Node front;
    private Node rear;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
    }
    /*
    enqueue方法：
        在链表的末尾添加元素
        根据情况更新front和rear*/
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = newNode;
        }
        else {
            rear.next = newNode;
            newNode.prev = rear;
        }
        rear = newNode;
    }
    /*
    dequeue方法：
        当链表为空时：捕获一个NoSuchElementException，
        打印"链表为空"，返回-1
        当链表不为空时：根据情况更新front和rear，
        返回被删除节点的值*/
    public int dequeue() {
        try {
            if (front == null)
                throw new NoSuchElementException("链表为空");
            Node temp = front;
            //front.next为空
            if (front.next == null) {
                front = null;
                rear = null;
            }
            //front.next不为空
            else {
                front = front.next;
                front.prev = null;
            }
            return temp.dat;
        }catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    /*
    peek方法：
        当链表为空时：捕获一个NoSuchElementException，
        打印"链表为空"，返回-1
        当链表不为空时：返回队首节点的值*/
    public int peek() {
        try {
            if (front == null)
                throw new NoSuchElementException("链表为空");
            //当链表不为空
            return front.dat;
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    public static void main(String[] args) {
        /*
        创建一个新的空LinkedQueue
        获取用户的输入的5个int，依次进入队列
        获取用户输入的一个int，这个数字是几，
        就对链表进行几次dequeue
        调用peek方法获取链表队首节点值，并打印返回值
        */
        Scanner sc = new Scanner(System.in);
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i = 0; i < 5; i++) {
            linkedQueue.enqueue(sc.nextInt());
        }
        int dequeueCount = sc.nextInt();
        for (int i = 0; i < dequeueCount; i++) {
            linkedQueue.dequeue();
        }
        System.out.println(linkedQueue.peek());

    }
}

