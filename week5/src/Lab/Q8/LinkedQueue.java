package Lab.Q8;

import java.util.NoSuchElementException;
import java.util.Scanner;

/*
这个程序会包含一个节点类和一个实现了队列的链表类，链表类中将有我们讲到过的三种队列的方法，请根据提示补全这个程序。

方法：

enqueue
dequeue
peek
 */
class Node {
    /*
    补全单链表的Node类
    包括两个字段一个构造器
     */
    public int elem;
    public Node next;

    public Node(int elem) {
        this.elem = elem;
    }
}

public class LinkedQueue {
    /*
    LinkedQueue类会有两个字段，和一个构造器：
    字段1：Node front 代表队首元素
    字段2：Node rear 代表队尾元素
    无参构造器：把front和rear都初始化为null
     */
    private Node front;
    private Node rear;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data) {
        /*
        补全enqueue方法：
        在链表的末尾添加元素
        根据情况更新front和rear
        提示：
        怎么判断链表是否为空？如果为空对front有什么影响？
         */
        Node newNode = new Node(data);
        if (front == null)
            front = newNode;
        else rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        /*
        补全dequeue方法：
        当链表为空时：捕获一个NoSuchElementException，
        打印"链表为空"，返回-1
        当链表不为空时：根据情况更新front和rear，
        返回被删除节点的值
         */
        try {
            if (front == null)
                throw new NoSuchElementException("链表为空");
            //链表不为空
            Node temp = front;
            //front.next为空
            if (front.next == null) {
                front = null;
                rear = null;
            }
            //front.next不为空
            else {
                front = front.next;
            }
            return temp.elem;

        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int peek() {
        /*
        补全peek方法：
        当链表为空时：捕获一个NoSuchElementException，
        打印"链表为空"，返回-1
        当链表不为空时：返回队首节点的值
         */
        try {
            if (front == null)
                throw new NoSuchElementException("链表为空");
            //当链表不为空
            return front.elem;
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static void main (String[] args){
        /*
        创建一个新的空LinkedQueue
        获取用户的输入的5个int，依次进入队列
        获取用户输入的一个int，这个数字是几，
        就对链表进行几次dequeue
        调用peek方法获取链表队首节点值，并打印返回值
         */
        Scanner scanner = new Scanner(System.in);
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i = 0; i < 5; i++) {
            linkedQueue.enqueue(scanner.nextInt());
        }

        int dequeueCount = scanner.nextInt();
        for (int i = 0; i < dequeueCount; i++) {
            linkedQueue.dequeue();
        }
        System.out.println(linkedQueue.peek());
    }
}
