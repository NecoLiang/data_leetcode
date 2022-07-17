package com.liang.data.leetcode.arrays;

/**
 * @author liangyt
 * @create 2022-05-23 9:26
 * 删除有序数组中的重复项
 * [1,1,2]——>[1,2],并返回数组长度
 */
public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i==0 || nums[i]!=nums[i-1]) {
                 nums[n] =nums[i];
                n++;
            }
        }
        return n;
    }
}
