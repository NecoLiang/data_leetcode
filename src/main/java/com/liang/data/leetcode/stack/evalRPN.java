package com.liang.data.leetcode.stack;

import java.util.Stack;

/**
 * @author liangyt
 * @create 2022-05-29 22:28
 * 逆波兰表达式求值/后缀表达式求值
 * 建立一个存数的栈，逐一扫描后缀表达式中的元素
 * 如果遇到一个数，就把该数入栈
 * 如果遇到运算符，就取出栈顶的两个元素进行计算，然后把结果入栈
 * 扫描完成后，栈中恰好剩下一个数，就是该后缀表达式的值
 */
public class evalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token == "+"|| token == "-"|| token == "*"|| token == "/") {
                Integer x = stack.pop();
                Integer y = stack.pop();
                Integer z = calc(x,y,token);
                stack.push(z);
            }else {
                stack.push(Integer.valueOf(token));
            }
        }
        return  stack.pop();
    }

    private Integer calc(Integer x, Integer y, String token) {
        if (token == "+"){
            return x + y;
        }
        if (token == "-"){
            return x - y;
        }
        if (token == "*"){
            return x * y;
        }
        if (token == "/"){
            return x / y;
        }
        return 0;
    }
    public static void main(String[] args) {
        evalRPN evalRPN = new evalRPN();
      String[] tokens = {"2","1","+","3","*"};
        int i = evalRPN.evalRPN(tokens);
        System.out.println(i);
    }
}
