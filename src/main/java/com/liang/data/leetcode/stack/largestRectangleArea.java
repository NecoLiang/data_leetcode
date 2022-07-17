package com.liang.data.leetcode.stack;

import java.util.Stack;

/**
 * @author liangyt
 * @create 2022-05-30 17:56
 * 单调栈问题
 * 定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Rect> stack = new Stack<>();
        int ans = 0;
      int[] newHeights =   new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i] = heights[i];

        }
        newHeights[heights.length] = 0;
        for (int height : newHeights) {
            int accumulatedWidth = 0 ;
            //当前栈内不为空，且栈顶之前的高度>当前高度，单调性被破坏，确定了栈顶高度的左右扩展范围，进行面积计算并删除栈顶。
            while (!stack.empty() && stack.peek().hight>=height){
                accumulatedWidth += stack.peek().width;
                ans = Math.max(ans,stack.peek().hight*accumulatedWidth);
                stack.pop();
            }
            stack.push(new Rect(accumulatedWidth+1,height));
        }
        return ans;

    }

    private class Rect{
        int width;
        int hight;

        public Rect(int width, int height) {
            this.hight = height;
            this.width = width;
        }
    }

    public static void main(String[] args) {
        largestRectangleArea largestRectangleArea = new largestRectangleArea();
        int [] heights = {2,1,5,6,2,3};
        int i = largestRectangleArea.largestRectangleArea(heights);
        System.out.println(i);
    }
}
