package com.liang.data.leetcode.stack;

import sun.misc.Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liangyt
 * @create 2022-06-03 18:43
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 *
 */
public class maxSlidingWindow {
    public Deque<Integer> maxSlidingWindow(int[] nums, int k) {
        //维护两个队列，一个记录递增的下标，一个记录递减的值。
        Deque<Integer> ans = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //删除出界的选项
            while (!deque.isEmpty() && deque.peek() <= i - k ){
                deque.removeFirst();
            }
            //插入新选项i，维护值单调性递减
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k-1){
                ans.addLast(nums[deque.getFirst()]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        maxSlidingWindow maxSlidingWindow = new maxSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        Deque<Integer> deque = maxSlidingWindow.maxSlidingWindow(nums, 3);
        System.out.println(deque);
    }
}
