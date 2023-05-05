package linkedlistAddOne;

import java.util.Scanner;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Lab{

    /*在这里补全plusOne方法*/

    /**
     * 获取一个代表一个整数的链表 head，将这个整数加上1，返回加一后的新链表
     * @return ListNode
     */
    public static ListNode plusOne(ListNode node) {
//        boolean isCarry = true;
        //slow ->将要+1的node
        ListNode slow = new ListNode(0);
        slow.next = node;
        //fast -> 遍历链表
        ListNode fast = node;
        //寻找最右的非9 node 使slow指向它
        while (fast != null) {
            if(fast.val != 9) {
                slow = fast;
//                isCarry = false;
            }
            fast = fast.next;
        }
        //slow指向的node更新val +1
        slow.val += 1;
        //slow之后的node 置为0
        ListNode curr = slow;
        while (curr.next != null) {
            curr.next.val = 0;
            curr = curr.next;
        }
        return slow.next == node ? slow : node;
//        return isCarry ? slow : node;

//        //进位1
//        if (isCarry) {
//            return slow;
//        }
//        return node;//不进位
    }

    public static void main (String[] args){
        Scanner scnr = new Scanner(System.in);
        int num = scnr.nextInt();
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 0; i < num; i++){
            int v = scnr.nextInt();
            temp.next = new ListNode(v);
            temp = temp.next;
        }

        ListNode result = plusOne(head.next);

        while (result != null){
            System.out.print(result.val);
            result = result.next;
        }
    }
}
