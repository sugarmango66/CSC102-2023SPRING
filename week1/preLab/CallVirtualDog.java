import java.util.Scanner;
class VirtualDog {
    
    /*在这里补全VirtualDog类*/
    private int age;
    public VirtualDog() { //构造1
        this(-1);
    }
    public VirtualDog(int age) { //构造2
        this.age = age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
}

public class CallVirtualDog {
    public static void main(String [] args) {
        
        /*在这里补全CallVirtualDog类*/
        Scanner scan = new Scanner(System.in);
        int ageInp = scan.nextInt();

        VirtualDog myDog = new VirtualDog();
        myDog.setAge(ageInp);
        System.out.println(myDog.getAge());
        
    }
}
