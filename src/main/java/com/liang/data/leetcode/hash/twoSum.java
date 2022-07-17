package com.liang.data.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author liangyt
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * @create 2022-06-26 18:25
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target-nums[i])){
               return new int[]{map.get(target-nums[i]),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        twoSum twoSum = new twoSum();
        int[] nums = {2,7,11,15};
        int[] ints = twoSum.twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }
}
