package com.liang.data.leetcode.subarray;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author liangyt
 * @create 2022-07-10 20:32
 * 优美子数组
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中 「优美子数组」 的数目。
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1]
 */
public class numberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n+1];
        s[0] = 0;
        for (int i = 1; i <= n; i++) {
          s[i] = s[i-1] + nums[i-1]%2;
        }
        int[] count =  new int[n+1];
        int ans = 0;
        count[s[0]]++;
        for (int i = 1; i <= n; i++) {
           if (s[i] - k >=0){
               ans += count[s[i] - k ];
           }
            count[s[i]]++;
            
        }
        return ans;
    }

    public static void main(String[] args) {
        numberOfSubarrays numberOfSubarrays = new numberOfSubarrays();
        int []  s = new int[]{1,1,2,1,1,8};
        int i = numberOfSubarrays.numberOfSubarrays(s, 3);
        System.out.println(i);
    }
}
