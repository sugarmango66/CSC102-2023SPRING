package preLab.Q14Lab;
import java.util.Scanner;
class Node {
    /*
    补全Node类
    有两个公有的成员变量，和一个构造器
     */
    public int elem;
    public Node next;
    //构造器1
    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }
    //构造器2
    public Node(int elem) {
        this(elem, null);
    }
}

class LinkedList {
    /*
    补全链表类的两个成员变量和一个构造器
     */
    private Node head;
    private Node tail;
    //初始化为空链表
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }
    //append方法会在链表 末尾 插入节点
    public void append(Node newNode) {

        /*
        补全append方法，分以下两种情况：
        情况1：链表为空。
              提示：如何判断链表为空？链表的头尾会发生什么变化？
        情况2：链表不为空。
         */
        if (head == null) {
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;
    }
    //prepend方法会在链表 开头 插入节点
    public void prepend(Node newNode) {
        /*
        补全prepend方法，分以下两种情况：
        情况1：链表为空。
        情况2：链表不为空。
         */
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    // insertAfter方法能在链表 中间/结尾 插入节点
    // 这个方法获取的参数是：1.currNode：代表插入位置的前一个节点；2.要插入的节点
    public void insertAfter(Node currentNode, Node newNode) {
        /*
        补全insertAfter方法，分以下三种情况：
        情况1：链表为空。
        情况2：如果currentNode是链表的最后一个节点。
              提示：这说明我们要插入新节点的位置是？
        情况3：如果不是以上两种情况。
         */
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (currentNode == tail) {
            append(newNode);
        } else {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }
    public void printList() {
    /*
    用一个循环打印链表，被打印的东西是每个节点的数据
    每打印一个节点，就打印一个空格
    比如如果链表元素是1，2，3，4，打印结果为：1 2 3 4
     */
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.elem + " ");
            curr = curr.next;
        }
    }
}
public class Main{
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        int i1 = scnr.nextInt();
        int i2 = scnr.nextInt();
        int i3 = scnr.nextInt();
        int i4 = scnr.nextInt();

        Node n1 = new Node(i1);
        Node n2 = new Node(i2);
        Node n3 = new Node(i3);
        Node n4 = new Node(i4);

        LinkedList myList = new LinkedList();
        myList.append(n1);
        myList.prepend(n2);
        myList.insertAfter(n2,n3);
        myList.append(n4);
        myList.printList();
    }
}
