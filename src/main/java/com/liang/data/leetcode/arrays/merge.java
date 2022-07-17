package com.liang.data.leetcode.arrays;

/**
 * @author liangyt
 * @create 2022-05-23 16:08
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 */
public class merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = n-1;
        for (int k =m+n-1;k>=0;k--){
            if (j<0|| (i>=0 && nums1[i] >=nums2[j]) ){
                nums1[k] = nums1[i];
                i--;
            }else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }

    private void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int x = 0;
        int i = 0;
        int j = 0;
        while (i<m || j<n){
            if (j>n || (i<m && nums1[i]<=nums2[j])) {
                result[x] = nums1[i];
                x++;
                i++;
            }else {
                result[x] = nums2[j];
                x++;
                j++;
            }
        }
        for (int y = 0;y<m+n;y++){
             nums1[y] = result[y];
        }
    }
}
