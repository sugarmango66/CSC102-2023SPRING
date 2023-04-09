import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTests {
    @Test
    public void isValid_testBasic1() {
        boolean res = Parentheses.isValid("{}");
        assertTrue(res);
    }

    @Test
    public void isValid_testBasic2() {
        boolean res = Parentheses.isValid("()");
        assertTrue(res);
    }

    @Test
    public void isValid_testBasic3() {
        boolean res = Parentheses.isValid("[]");
        assertTrue(res);
    }

    @Test
    public void isValid_testNear() {
        boolean res = Parentheses.isValid("{}()");
        assertTrue(res);
    }

    @Test
    public void isValid_testEmbed() {
        boolean res = Parentheses.isValid("([{}])");
        assertTrue(res);
    }

    @Test
    public void isValid_testWrongEmbed() {
        boolean res = Parentheses.isValid("([)]");
        assertFalse(res);
    }

    @Test
    public void isValid_testWrongMatch() {
        boolean res = Parentheses.isValid("(}");
        assertFalse(res);
    }

    @Test
    public void isValid_testNoMatch() {
        boolean res = Parentheses.isValid("]]]");
        assertFalse(res);
    }

    @Test
    public void isValid_testInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Parentheses.isValid("[=]"));
    }


}
