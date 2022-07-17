package com.liang.data.leetcode.hash;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author liangyt
 * @create 2022-07-03 10:04
 * 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 */
public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> map = new HashMap<>();

        for (String str : strs) {
            String copy = str;
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);

            if (!map.containsKey(s)) {
            ArrayList<String> list = new ArrayList<>();
            list.add(copy);
            map.put(s, list);
            }else {
                List list = map.get(s);
                list.add(copy);
                map.put(s,list);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (List value : map.values()) {

            result.add(value);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams groupAnagrams = new groupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        System.out.println(lists);
    }
}
