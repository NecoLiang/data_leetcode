package com.liang.data.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author liangyt
 * @create 2022-07-03 16:50
 * 30.串联所有单词的子串
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 */
public class findSubstring {
    HashMap<String, Integer> map = new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {
        int total = 0;
        int j = 1;
        for (String word : words) {
            total += word.length();
            if (map.containsKey(word)){
                Integer integer = map.get(word);
                map.put(word,integer++);
            }else {
                map.put(word,j);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i+total < s.length(); i++) {
           if (valid(s.substring(i,total+i),words)){
            ans.add(i);
           }
            
        }
        return ans;
    }
    private boolean valid(String s,String[] words){
        int k = words[0].length();
        int l = 1;
        HashMap<String, Integer> splitMap = new HashMap<>();
        for (int i = 0; i < s.length(); i+=k) {
            String substring = s.substring(i, k+i);
            if (splitMap.containsKey(substring)){
                Integer integer = splitMap.get(substring);
                splitMap.put(substring,integer++);
            }else {
                splitMap.put(substring,l);
            }

        }
        return equalsMap(map,splitMap);
    }

    private boolean equalsMap(HashMap<String, Integer> map, HashMap<String, Integer> splitMap) {
        for (String key : map.keySet()) {
            if (!splitMap.containsKey(key)|| splitMap.get(key)!=map.get(key) ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        findSubstring findSubstring = new findSubstring();
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        List<Integer> substring = findSubstring.findSubstring(s, words);
        System.out.println(substring);
    }
}
