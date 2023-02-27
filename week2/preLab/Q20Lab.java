import java.util.ArrayList;
import java.util.Scanner;

/*
要求：

Month类：
有一个String类型的private字段month，代表月。
方法1：setMonth(String providedMonth)方法。
方法2：printDate()方法 - 这个方法会先打印"月份: "（英文冒号加空格），然后打印字段month。

Date类：
Date类继承Month类。
有一个int类型的private字段day，代表日。
方法1：setDay(int providedDay)方法。
方法2：重写Month类方法printDate() - 
              这个方法会先打印"日期: "（英文冒号加空格），然后打印字段month，打印一个空格，然后打印字段day。（都打印在同一行）

CallDate类：
main()方法：
创建一个ArrayList，类型是ArrayList<Month>。
创建一个Month类型的对象，把用户输入的一个String赋值给字段month。
创建一个Date类型的对象，把用户输入的一个int赋值给字段day，再把用户输入的一个String赋值给字段month。（注意用户先输入int再输入String）
把这两个对象依次存入创建的ArrayList中，并对ArrayList中的全部元素（共两个）依次调用printDate()方法。
*/
class Month {
    private String month;
    public void setMonth(String providedMonth) {
        this.month = providedMonth;
    }
    public String getMonth() {
        return this.month;
    }
    public void printDate() {
        System.out.println("月份: " + month);
    }
}

class Date extends Month {
    private int day;
    public void setDay(int providedDay) {
        day = providedDay;
    }
    @Override
    public void printDate() {
        System.out.println("日期: " + getMonth() + " " + day); //all ok: this.getMonth()  super.getMonth()
    }
}

public class Q20Lab { //CallDate
    public static void main(String[] args) {
        ArrayList<Month> objs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        Month month = new Month();
        Date date = new Date();
        String month1 = sc.next();
        int day = sc.nextInt();
        String month2 = sc.next();
        month.setMonth(month1);
        date.setMonth(month2);
        date.setDay(day);

        objs.add(month);
        objs.add(date);
        for (Month ele : objs) {
            ele.printDate();
        }
    }
    
}
