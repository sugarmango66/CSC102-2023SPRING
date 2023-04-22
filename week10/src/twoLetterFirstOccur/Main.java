package twoLetterFirstOccur;

import java.util.HashSet;

/*
题目：
给定一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
如果字母 a 的 第二次 出现比字母 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 比字母 b 先出现两次。
假设 s 包含至少一个出现两次的字母。
 */
public class Main {
    public static void main(String[] args) {
        /*分析
        使用HashSet-快速查询 元素不重复
        1遍历str 字母存入hashset
        2第一次遇到存入失败的 即为最先出现两次的字母
         */
        String str = "bafbld";
        System.out.println(findLetter(str));

    }

    public static Character findLetter (String str) {
        HashSet<Character> hashSet = new HashSet<>();
        for (Character letter : str.toCharArray()) {
            if(hashSet.contains(letter)) {
                return letter;
            } else {
                hashSet.add(letter);
            }
//            boolean isAllowAdd = hashSet.add(letter);
//            if (!isAllowAdd) {
//                return letter;
//            }
        }
        return null;
    }
}
