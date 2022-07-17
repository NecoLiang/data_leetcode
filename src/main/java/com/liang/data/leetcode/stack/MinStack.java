package com.liang.data.leetcode.stack;

import java.util.Stack;

/**
 * @author liangyt
 * @create 2022-05-29 21:51
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 需要维护两个栈，一个用来存数据，一个用来记录之前存入数据的最小值。
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 */
public class MinStack {
    public MinStack() {


    }

    public void push(int val) {
        stack.push(val);
        if (preMin.empty()){
            preMin.push(val);
        }
        preMin.push(Math.min(preMin.peek(),val));

    }

    public void pop() {
        stack.pop();
        preMin.pop();
    }

    public int top() {
      return  stack.peek();

    }

    public int getMin() {
        return preMin.peek();
    }

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> preMin = new Stack<>();
}
