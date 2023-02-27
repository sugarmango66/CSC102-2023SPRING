import java.util.Scanner;

/*
 * 这个程序会有一个Shape抽象类包括计算面积和周长的方法，然后创建代表圆形和矩形的两个类，继承Shape并重写一些方法，最后在public类CallShape中根据用户的输入运用。

要求：
抽象类Shape：
公有成员方法1：area(){...}，返回值类型是int，用于计算面积，在Shape类中它直接返回-1，没有其他操作。
公有成员方法2：perimeter(){...}，返回值类型是int，用于计算周长，在Shape类中它直接返回-1，没有其他操作。

Circle类：
这个类要继承抽象类shape。
私有字段：radius，类型是int，代表圆形的半径。
构造器：一个Shape类的构造器，包含一个int类参数r，把r传给radius。
重写方法1：重写area(){...}，使方法返回值为：3 * radius * radius。（πr²，π简化为3）
重写方法2：重写perimeter(){...}，使方法返回值为：2 * 3 * radius。（2πr，π简化为3）

Rectangle类：
这个类要继承抽象类shape。
私有字段1：length，类型是int，代表矩形的长。
私有字段2：width，类型是int，代表矩形的宽。
构造器：一个Shape类的构造器，依次包含一个int类参数 l 和 w，把 l 传给length，把 w 传给width。
重写方法1：重写area(){...}，使方法返回值为：length * radius。
重写方法2：重写perimeter(){...}，使方法返回值为：2(length + radius）。

CallShape类：
定义为public类。
依次获取用户的三个输入，分别赋值给三个int类型变量radius, length, width。
用radius作为参数调用Circle构造器，创建一个实例myCircle。
用length和width作为参数调用Rectangle构造器，创建一个实例myRectangle。
输出1：调用合适的方法获取myCircle的面积，打印一句：”圆形的面积是{圆形面积}“，并创建一个新的空行。
输出2：调用合适的方法获取myRectangle的面积，打印一句：”矩形的周长是{矩形周长}“，并创建一个新的空行。
 */
public class CallShape {
    public static void main(String[] args) {
        //获取输入
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        int length = sc.nextInt();
        int width = sc.nextInt();
        //创建对象
        Circle myCircle = new Circle(radius);
        Rectangle myRectangle = new Rectangle(length, width);
        //调用方法
        System.out.println("圆形的面积是" + myCircle.area());
        System.out.println("矩形的周长是" + myRectangle.perimeter());
    }
}

//抽象类
abstract class Shape {
    //计算面积方法
    public int area() {
        return -1;
    }
    //计算周长方法
    public int perimeter() {
        return -1;
    }
}

//Circle类
class Circle extends Shape {
    //私有字段
    private int radius;
    //构造器
    public Circle(int r) {
        this.radius = r;
    }
    //重写方法
    @Override
    public int area() {
        // TODO Auto-generated method stub
        return 3 * radius * radius;
    }
    //重写方法
    @Override
    public int perimeter() {
        // TODO Auto-generated method stub
        return 2 * 3 * radius;
    }
}

//Rectangle类
class Rectangle extends Shape{
    private int length;
    private int width;
    //构造器
    public Rectangle(int l, int w) {
        this.length = l;
        this.width = w;
    }
    //重写方法
    @Override
    public int area() {
        // TODO Auto-generated method stub
        return length * width;
    }
    @Override
    public int perimeter() {
        // TODO Auto-generated method stub
        return 2 * (length + width);
    }
}
