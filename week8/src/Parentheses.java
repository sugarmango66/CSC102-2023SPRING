import java.util.Scanner;
import java.util.Stack;

public class Parentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); //这一步会创建一个栈，栈中元素是字符串的每一个字符

        for (char c : s.toCharArray()) {
            /*在这里补全方法*/
            if (isLeftType(c)) {
                stack.push(c);
            }
            else if (isRightType(c)) {
                if (stack.empty() || !isMatch(stack.pop(), c)) {
                    return false;
                }
            }
            else {
                throw new IllegalArgumentException("invalid token");
            }
        }
        return true;
    }

    public static boolean isLeftType(char c) {
        return "([{".indexOf(c) != -1;
    }

    public static boolean isRightType(char c) {
        return ")]}".indexOf(c) != -1;
    }

    public static boolean isMatch(char left, char right) {
        String cp = "" + left + right;
        return cp.equals("()") || cp.equals("[]") || cp.equals("{}");
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String s = scnr.next();
        System.out.println(isValid(s));
    }

}
