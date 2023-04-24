package firstOnlyLetter;

import java.util.HashMap;

//给定一个字符串 s ，找到它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
public class Main {
    public static void main(String[] args) {
        String s = "ababcdd";
        System.out.println(findFirstOnlyPos(s));

    }

    public static int findFirstOnlyPos(String s) {
        //s的letter和count存入HashMap
        HashMap<Character, Integer> countOccur = new HashMap<Character, Integer>();
        for (Character c : s.toCharArray()) {
            countOccur.put(c, countOccur.getOrDefault(c, 0) + 1);
//            if (countOccur.containsKey(c)) {
//                countOccur.put(c, countOccur.get(c) + 1);
//            } else {
//                countOccur.put(c, 1);
//            }
        }
        //traverse s again find pos of first count 1
        for (int i = 0; i < s.length(); i++) {
            if (countOccur.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

