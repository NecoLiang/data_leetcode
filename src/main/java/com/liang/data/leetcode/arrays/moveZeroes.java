package com.liang.data.leetcode.arrays;

/**
 * @author liangyt
 * @create 2022-05-23 9:39
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。在原数组上进行操作
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 思路：将非零依次放置在数组，后面补0
 */
public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                 nums[n] = nums[i];
                 n++;
            }
        }

        assignToZeroV1(nums, n);
    }

    private void assignToZeroV1(int[] nums, int n) {
        for (int j = n; j < nums.length; j++) {
           nums[j] = 0;
        }
    }
    private void assignToZeroV2(int[] nums, int n) {
      while (nums[n]<nums.length){
          nums[n]=0;
          n++;
      }
    }
}
