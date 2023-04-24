package sortShow;

import java.util.*;

/*
给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 */
public class Main {
    public static void main(String[] args) {
        String s = "abbccc";
        System.out.println(frequencySort(s));

    }

    public static String frequencySort(String s) {
        //abbccc -> cccbba
        //1 traverse put letter and occur times in hashmap
        Map<Character, Integer> occurMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            occurMap.put(c, occurMap.getOrDefault(c, 0) + 1);
        }

        //2 put all unique letter in list
        ArrayList<Character> letters = new ArrayList<>(occurMap.keySet());

        //3 sort list with custom comparator - descending
        Comparator<Character> comparator = (c1, c2) -> occurMap.get(c2) - occurMap.get(c1);
        Collections.sort(letters, comparator);

        //4 make new string based on times
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : letters) {
            for (int i = 0; i < occurMap.get(c); i++) {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();

    }
}
