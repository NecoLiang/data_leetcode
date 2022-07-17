package com.liang.data.leetcode.stack;

import java.util.Stack;

/**
 * @author liangyt
 * @create 2022-06-02 10:45
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 */
public class trappingRainWater {
    public int trap(int[] heights) {
        Stack<React> stack = new Stack<>();
        int ans = 0;
        for (int height: heights) {
           int accumulateWidth = 0;
            while (!stack.empty() && stack.peek().height <= height){
                int bottom = stack.peek().height;
                accumulateWidth += stack.peek().width;
                stack.pop();
                //栈为空则从左边流走
                if (stack.empty()){
                    continue;
                }
                //以bottom为底的横块水最高可以到up（左右两侧高度的min）
                int up = Math.min(height,stack.peek().height);
                ans += accumulateWidth*(up - bottom);

            }
            stack.push(new React(accumulateWidth+1,height));
        }
        return ans;

    }
    public class React{
        int width;
        int height;
        public React(int width,int height){
            this.height = height;
            this.width = width;
        }
    }
    public static void main(String[] args) {
        trappingRainWater trappingRainWater = new trappingRainWater();
        int [] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int i = trappingRainWater.trap(heights);
        System.out.println(i);
    }
}
