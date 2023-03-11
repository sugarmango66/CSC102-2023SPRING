package Lab.Q6;
/*
这题中的代码和上一题类似，都是在链表中实现栈，区别是换成使用双链表结构，
因此，一些方法和成员变量都会发生相应的改变。最终程序会打印栈的长度，以及是否为空。


方法：

push
pop
peek
getSize
isEmpty
 */
import java.util.NoSuchElementException;
import java.util.Scanner;

class Node {

    /*
    写出双链表的Node类
    要包含三个字段：int dat（代表数据）;
    Node prev（前指针）; Node next（后指针）
    还要有一个构造器
     */
    public int dat;
    public Node next;
    public Node prev;

    public Node(int dat) {
        this.dat = dat;
    }
}

public class LinkedStack {
    private Node top;
    private int size;

    public LinkedStack() {
    }
    /*
    push方法：
        把参数data作为数据创建一个节点，
        并把这个节点添加到原链表的前面
        更新top，更新size
     */
    public void push(int data) {
        Node newTop = new Node(data);
        if (!isEmpty()) {
            newTop.next = top;
            top.prev = newTop;
        }
        top = newTop;
        size += 1;
    }
    /*
    pop方法：
        当链表为空时：捕获一个NoSuchElementException，
        打印"链表为空"，返回-1
        当链表不为空时：更新top，更新size，
        并返回出栈节点的值
    */
    public int pop() {
        try {
            if (isEmpty())
                throw new NoSuchElementException("链表为空");
            Node oldTop = top;
            top = top.next;
            if (top != null)
                top.prev = null;
            size -= 1;
            return oldTop.dat;

        }catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    /*
    peek方法：
        当链表为空时：捕获一个NoSuchElementException，
        打印"链表为空"，返回-1
        当链表不为空时：返回栈顶节点的值
    */
    public int peek() {
        try {
            if (isEmpty())
                throw new NoSuchElementException("链表为空");
            return top.dat;
        }catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    /*
    getSize方法：
        返回链表长度
    */
    public int getSize() {
        return size;
    }
    /*
    isEmpty方法：
        判断链表是否为空：如果是，返回true；否则返回false
     */
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        /*
        创建一个新的空链表myStack
        获取用户的输入的5个int，依次入栈
        获取用户输入的一个int，这个数字是几，就对链表进行几次pop
        */
        LinkedStack myStack = new LinkedStack();
        for (int i = 0; i < 5; i++)
            myStack.push(scnr.nextInt());
        int popCount = scnr.nextInt();
        for (int i = 0; i < popCount; i++) {
            myStack.pop();
        }
        System.out.println(myStack.getSize());
        System.out.println(myStack.isEmpty());
    }
}
