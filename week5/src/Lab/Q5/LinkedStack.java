package Lab.Q5;

import java.util.NoSuchElementException;
import java.util.Scanner;

/*
这个程序会包含一个节点类和一个实现了栈的链表类，链表类中将有我们之前讲到过的几种方法，请根据提示补全这个程序。

方法：

push
pop
peek
getSize
isEmpty
 */
class Node {
    public int elem;
    public Node next;

    public Node(int elem) {
        this.elem = elem;
    }
}
public class LinkedStack {
    //字段
    private Node top;
    private int size;
    //构造器
    public LinkedStack() {
        top = null;
        size = 0;
    }
    //方法
    public void push(int data) {
        //data存入节点 放入栈顶
        Node newTop = new Node(data);
        newTop.next = top;
        top = newTop;
        //!!更新size
        size += 1;
    }
    public int pop() {
        //top节点出栈 返回节点data
        /*
        补全pop方法：
        当链表为空时：捕获一个NoSuchElementException，
        打印"链表为空"，返回-1
        当链表不为空时：更新top，更新size，并返回出栈节点的值
         */
        try {
            if (isEmpty()) {
                throw new NoSuchElementException("链表为空");
            }
            //链表不为空时
            Node temp = top;
            top = top.next;
            size -= 1;
            return temp.elem;

        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    public int peek() {
        //返回top的值 不改变链表
        /*
        补全peek方法：
        当链表为空时：捕获一个NoSuchElementException，
        打印"链表为空"，返回-1
        当链表不为空时：返回栈顶节点的值
         */
        try {
            if (isEmpty())
                throw new NoSuchElementException("链表为空");
            //链表不为空
            return top.elem;
        }catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }
    public int getSize() {
        return this.size;
    }
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        /*
        创建一个新的空LinkedStack
        获取用户的输入的5个int，依次入栈
        获取用户输入的一个int，这个数字是几，就对链表进行几次pop
        调用方法获取链表长度并打印
        调用peek方法获取链表栈顶元素值，并打印返回值
        调用isEmpty方法判断链表是否为空，并打印返回值
         */
        Scanner sc = new Scanner(System.in);
        LinkedStack linkedStack = new LinkedStack();
        for (int i = 0; i < 5; i++) {
            linkedStack.push(sc.nextInt());
        }
        //获取pop次数
        int popCount = sc.nextInt();
        for (int i = 0; i < popCount; i++) {
            linkedStack.pop();
        }
        //调用方法
        System.out.println(linkedStack.getSize());
        System.out.println(linkedStack.peek());
        System.out.println(linkedStack.isEmpty());
    }
}
