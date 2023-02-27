import java.util.Scanner;

/*
 * 这个程序会创建一个存储人员信息的类，和一个继承自这个类的存储学生信息的类，最后在public类CallPerson中创建学生对象存储并打印信息。

要求：

Person类：
有一个int类型的私有字段age（代表年龄），和一个String类型的私有字段occupation（代表职业）。
构造器：Person类的构造器有两个参数，int类参数age和String类参数occupation，分别传给age和occupation。
公有成员方法1：getAge(){...}，方法返回类型是int，返回Person类对象的age字段。
公有成员方法2：getOccupation(){...}，方法返回类型是String，返回Person类对象的occupation字段。

Student类：
Student类要继承Person类。
私有字段：String类型字段major，代表Student的专业。
构造器：Student类的构造器获取两个参数，int类参数age和String类参数major。
该构造器分为两部分，首先用age参数和字符串"学生”依次作为两个参数调用父类Person类的构造器。
然后把major赋值给Student的字段major。
公有成员方法：getMajor(){...}，方法返回类型是String，返回Student类的字段major。

CallPerson类（public)：
定义为public类。
依次获取用户输入的一个int类输入赋值给变量a（代表年龄），和一个String类输入赋值给变量m（代表专业）
调用Student类的构造器定义一个Student类对象stu，用用户输入的 a 和 m 作为参数。
输出1：调用合适的方法获取学生的年龄，输出 "年龄-{学生年龄}“，并创建一个新的空行。
输出2：调用合适的方法获取学生的职业，输出 "职业-{学生职业}“，并创建一个新的空行。
输出3：调用合适的方法获取学生的专业，输出 "专业-{学生专业}“，并创建一个新的空行。
 */
public class CallPerson {
    public static void main(String[] args) {
        //获取输入
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String m = sc.next();
        //创建对象
        Student stu = new Student(a, m);
        //调用方法
        System.out.println("年龄-" + stu.getAge()); //从基类继承的方法
        System.out.println("职业-" + stu.getOccupation()); //从基类继承的方法
        System.out.println("专业-" + stu.getMajor());
    }
}

//基类
class Person {
    private int age;
    private String occupation;
    //构造器
    public Person(int age, String occupation) {
        this.age = age;
        this.occupation = occupation;
    }
    //getter
    public int getAge() {
        return age;
    }
    public String getOccupation() {
        return occupation;
    }
}
//派生类
class Student extends Person {
    private String major;
    //构造器
    public Student(int age, String major) {
        super(age, "学生"); //使用基类的构造器
        this.major = major;
    }
    //getter
    public String getMajor() {
        return major;
    }
}


